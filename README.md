# spring-k8s-test

Repository containes a test of creating kubernetes job using fabric8 kubernetes client.

## Build

`./gradlew clean build`

## Run

`./gradlew bootRun`

## Test

`./gradlew test`

Most important part of the test was trying out the fabric8 Kubernetes Mock Client. It allows for mocking of the kubernetes APIServer API and later assertions of the created resources.
