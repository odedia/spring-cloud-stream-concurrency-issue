# spring-cloud-stream-concurrency-issue
A demo app that shows concurrency parameter is not honored in Spring Cloud Stream Kafka

- Start a single publisher, and 2 consumer apps
- from terminal, run:
while true; do curl -X POST -d 'hello' localhost:8080/sendEvent; done

- since application.properties claim to have concurrecy of 20, and you have two processes, and the publisher created 40 partitions, you expect the prints to happen all the time, but in fact you only process with a single thread.

