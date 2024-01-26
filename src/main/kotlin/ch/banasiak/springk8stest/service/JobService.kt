package ch.banasiak.springk8stest.service

import ch.banasiak.springk8stest.model.Job
import reactor.core.publisher.Flux

interface JobService {
    fun getJobs(): Flux<Job>
}