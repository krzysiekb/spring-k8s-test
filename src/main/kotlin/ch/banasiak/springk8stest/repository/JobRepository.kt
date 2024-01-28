package ch.banasiak.springk8stest.repository

import ch.banasiak.springk8stest.model.TestJob
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface JobRepository {
    fun findAll(): Flux<TestJob>
    fun findById(id: String): Mono<TestJob>
    fun create(testJob: TestJob): Mono<TestJob>
}