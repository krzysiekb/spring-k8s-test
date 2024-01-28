package ch.banasiak.springk8stest.model

data class TestJob(
    var id: String?,
    var name: String,
    var status: String,
    var testJobConfig: TestJobConfig,
)