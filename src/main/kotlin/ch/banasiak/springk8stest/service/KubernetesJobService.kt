package ch.banasiak.springk8stest.service

import ch.banasiak.springk8stest.model.TestJob
import ch.banasiak.springk8stest.repository.JobRepository
import io.fabric8.kubernetes.api.model.batch.v1.JobBuilder
import io.fabric8.kubernetes.client.KubernetesClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class KubernetesJobService(
    private val jobRepository: JobRepository,
    private val kubernetesClient: KubernetesClient,
): JobService {
    override fun getJobs(): Flux<TestJob> {
        return jobRepository.findAll()
    }

    override fun createJob(testJob: TestJob): Mono<TestJob> {
        val k8sJob = JobBuilder()
            .withApiVersion("batch/v1")
            .withNewMetadata()
            .withName(testJob.name)
            .endMetadata()
            .withNewSpec()
            .withBackoffLimit(3)
            .withNewTemplate()
            .withNewSpec()
            .addNewContainer()
            .withName("${testJob.name}-container")
            .withImage(testJob.testJobConfig.image)
            .withCommand(testJob.testJobConfig.command)
            .endContainer()
            .withRestartPolicy("Never")
            .endSpec()
            .endTemplate()
            .endSpec()
            .build()

        kubernetesClient.batch().v1()
            .jobs()
            .inNamespace(testJob.testJobConfig.namespace)
            .resource(k8sJob)
            .create()

        return jobRepository.create(testJob)
    }
}