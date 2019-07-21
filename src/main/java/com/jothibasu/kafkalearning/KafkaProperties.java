package com.jothibasu.kafkalearning;

import java.util.Properties;

public class KafkaProperties {

	Properties props = new Properties();

	String BROKER_INSTANCE = "localhost:9092";
	String ACK_TYPE = "all";
	int BATCH_SIZE_IN_BYTES = 16384;
	int BUFFER_MEMORY_IN_BYTES = 33554432;
	int LINGER_TIME_IN_MILLISECONDS = 1;
	int DELIVERY_TIMEOUT_IN_MILLISECONDS = 30000;

	String topic;

	Properties getProperties() {
		return props;
	}

	void setProperties() {
		/*props.put("bootstrap.servers", BROKER_INSTANCE);
		props.put("acks", ACK_TYPE);
		props.put("delivery.timeout.ms", DELIVERY_TIMEOUT_IN_MILLISECONDS);
		props.put("batch.size", BATCH_SIZE_IN_BYTES);
		props.put("linger.ms", LINGER_TIME_IN_MILLISECONDS);
		props.put("buffer.memory", BUFFER_MEMORY_IN_BYTES);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");*/

		props.put("bootstrap.servers", BROKER_INSTANCE);
		props.put("transactional.id", "my-transactional-id");
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
