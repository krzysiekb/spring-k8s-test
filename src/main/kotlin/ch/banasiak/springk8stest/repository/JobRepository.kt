package ch.banasiak.springk8stest.repository

import ch.banasiak.springk8stest.model.Job
import reactor.core.publisher.Flux

interface JobRepository {
    fun findAll(): Flux<Job>
}