package ch.banasiak.springk8stest.service

import ch.banasiak.springk8stest.model.Job
import ch.banasiak.springk8stest.repository.JobRepository
import reactor.core.publisher.Flux

class KubernetesJobService(
    private val jobRepository: JobRepository
): JobService {
    override fun getJobs(): Flux<Job> {
        return jobRepository.findAll()
    }
}