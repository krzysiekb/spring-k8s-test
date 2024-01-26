package ch.banasiak.springk8stest.controller

import ch.banasiak.springk8stest.service.JobService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("jobs/")
class JobController (
    private val jobService: JobService
){

    @GetMapping
    fun getJobs() = jobService.getJobs()

    @PostMapping("")
    fun createJob() = "OK"
}