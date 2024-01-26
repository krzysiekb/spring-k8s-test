package ch.banasiak.springk8stest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringK8sTestApplication

fun main(args: Array<String>) {
	runApplication<SpringK8sTestApplication>(*args)
}
