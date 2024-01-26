package ch.banasiak.springk8stest.config

import ch.banasiak.springk8stest.repository.InMemoryJobRepository
import ch.banasiak.springk8stest.repository.JobRepository
import ch.banasiak.springk8stest.service.KubernetesJobService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun jobRepository() = InMemoryJobRepository()

    @Bean
    fun jobService(jobRepository: JobRepository) =
        KubernetesJobService(jobRepository)
}