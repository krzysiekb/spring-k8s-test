package ch.banasiak.springk8stest.service

import ch.banasiak.springk8stest.model.TestJob
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface JobService {
    fun getJobs(): Flux<TestJob>
    fun createJob(testJob: TestJob): Mono<TestJob>
}