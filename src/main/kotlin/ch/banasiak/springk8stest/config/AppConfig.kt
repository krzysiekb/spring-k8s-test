package ch.banasiak.springk8stest.config

import ch.banasiak.springk8stest.repository.InMemoryJobRepository
import ch.banasiak.springk8stest.repository.JobRepository
import ch.banasiak.springk8stest.service.KubernetesJobService
import io.fabric8.kubernetes.client.KubernetesClient
import io.fabric8.kubernetes.client.KubernetesClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun jobRepository() = InMemoryJobRepository()

    @Bean
    fun kubernetesClient(): KubernetesClient = KubernetesClientBuilder().build()

    @Bean
    fun jobService(jobRepository: JobRepository, kubernetesClient: KubernetesClient) =
        KubernetesJobService(jobRepository, kubernetesClient)
}