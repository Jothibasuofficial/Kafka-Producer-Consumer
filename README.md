# Kafka-Producer-Consumer

A java application for pub-sub messages via topic using Kafka Producer and Kafka Consumer

## Kafka Archietecture
![Kafka Archietecture](/assets/kafka_archietecture.png)

## Inside Broker
![Kafka Broker](/assets/inside_broker.png)

## Kafka Terminologies
*   **Record:** Producer sends messages to Kafka in the form of records. A record is a key-value pair. It contains the topic name and partition number to be sent. Kafka broker keeps records inside topic partitions. Records sequence is maintained at the partition level. You can define the logic on which basis partition will be determined. 

*   **Topic:** Producer writes a record on a topic and the consumer listens to it. A topic can have many partitions but must have at least one.

*   **Partition:** A topic partition is a unit of parallelism in Kafka, i.e. two consumers cannot consume messages from the same partition at the same time. A consumer can consume from multiple partitions at the same time.

*   **Offset:** A record in a partition has an offset associated with it. Think of it like this: partition is like an array; offsets are like indexs.

*   **Producer:** Creates a record and publishes it to the broker.

*   **Consumer:** Consumes records from the broker.


To know more click [here](https://kafka.apache.org/)
