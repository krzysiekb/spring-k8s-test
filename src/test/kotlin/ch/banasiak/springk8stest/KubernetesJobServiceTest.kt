package ch.banasiak.springk8stest

import ch.banasiak.springk8stest.model.TestJob
import ch.banasiak.springk8stest.model.TestJobConfig
import ch.banasiak.springk8stest.repository.InMemoryJobRepository
import ch.banasiak.springk8stest.service.KubernetesJobService
import io.fabric8.kubernetes.client.KubernetesClient
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

@EnableKubernetesMockClient(crud = true)
class KubernetesJobServiceTest{

    private lateinit var kubernetesClient: KubernetesClient

    @Test
    fun `kubernetesJobService should create job based on configuration`(){
        runBlocking {
            val jobRepository = InMemoryJobRepository()
            val kubernetesJobService = KubernetesJobService(jobRepository, kubernetesClient)

            // given
            val testJob = TestJob(
                id = "",
                name = "test-job",
                status = "new",
                testJobConfig = TestJobConfig(
                    namespace = "default",
                    image = "busybox",
                    command = listOf("echo", "Hello World"),
                    env = mapOf("TEST_ENV" to "test-env")
                )
            )

            // when
            kubernetesJobService.createJob(testJob)

            // then
            val jobs = kubernetesClient.batch().v1()
                .jobs()
                .inNamespace(testJob.testJobConfig.namespace)
                .list()
                .items

            assert(jobs.size == 1)

            val job = jobs[0]
            assert(job.metadata.name == testJob.name)
        }
    }
}