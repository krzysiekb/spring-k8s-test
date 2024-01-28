package ch.banasiak.springk8stest.model

data class TestJobConfig(
    val namespace: String,
    val image: String,
    val command: List<String>,
    val env: Map<String, String>
)