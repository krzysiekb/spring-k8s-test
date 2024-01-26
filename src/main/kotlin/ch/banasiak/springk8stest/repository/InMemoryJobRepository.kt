package ch.banasiak.springk8stest.repository

import ch.banasiak.springk8stest.model.Job
import reactor.core.publisher.Flux

class InMemoryJobRepository(
    private val jobs: List<Job> =  mutableListOf()
): JobRepository {

    override fun findAll(): Flux<Job> {
       return Flux.fromIterable(jobs)
    }

}