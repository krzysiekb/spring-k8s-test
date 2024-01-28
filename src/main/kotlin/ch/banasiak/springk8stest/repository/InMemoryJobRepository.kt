package ch.banasiak.springk8stest.repository

import ch.banasiak.springk8stest.model.TestJob
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class InMemoryJobRepository(
    private val testJobs: List<TestJob> =  mutableListOf()
): JobRepository {

    override fun findAll(): Flux<TestJob> {
        return Flux.fromIterable(testJobs)
    }

    override fun findById(id: String): Mono<TestJob> {
        return testJobs.first { it.id == id }.let { Mono.just(it) }
    }

    override fun create(testJob: TestJob): Mono<TestJob> {
        testJob.id = uuid()
        testJobs.addLast(testJob)
        return Mono.just(testJob)
    }

    private fun uuid(): String {
        return java.util.UUID.randomUUID().toString()
    }
}