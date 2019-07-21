package com.jothibasu.kafkalearning;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.AuthorizationException;
import org.apache.kafka.common.errors.OutOfOrderSequenceException;
import org.apache.kafka.common.errors.ProducerFencedException;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer {

	public static void main(String[] args) {

		KafkaProperties propertiesObj = new KafkaProperties();
		propertiesObj.setProperties();
		Properties props = propertiesObj.getProperties();
		propertiesObj.setTopic("test-topic");
		String topic = propertiesObj.getTopic();

		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props, new StringSerializer(),
				new StringSerializer());
		producer.initTransactions();

		try {
			producer.beginTransaction();
			for (int i = 0; i < 5; i++)
				producer.send(new ProducerRecord<String, String>(topic, Integer.toString(i), Integer.toString(i)));
			producer.commitTransaction();
		} catch (ProducerFencedException | OutOfOrderSequenceException | AuthorizationException e) {
			// We can't recover from these exceptions, so our only option is to close the
			// producer and exit.
			producer.close();
		} catch (KafkaException e) {
			// For all other exceptions, just abort the transaction and try again.
			producer.abortTransaction();
		}
		producer.close();
	}

}

