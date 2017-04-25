package com.yatra.core.kafka.producers;

import com.yatra.api.request.Message;
import com.yatra.api.response.PublishResponse;
import com.yatra.core.config.ProducerConfiguration;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SimpleProducer {

    public SimpleProducer(){}

    public PublishResponse produce(ProducerConfiguration configuration, Message message){
        Properties props = new Properties();
        props.put("bootstrap.servers", configuration.getBootstrapServers());
        //Set acknowledgements for producer requests.
        props.put("acks", configuration.getAcknowledgment());
        //If the request fails, the producer can automatically retry
        props.put("retries", configuration.getRetries());
        //Specify buffer size in config
        props.put("batch.size", configuration.getBatchSize());
        //Reduce the no of requests less than 0
        props.put("linger.ms", configuration.getLingerMs());
        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("buffer.memory", configuration.getBufferMemory());

        props.put("key.serializer", configuration.getKeySerializer());
        props.put("value.serializer", configuration.getValueSerializer());
        Producer<String, String> producer = null;
        try {
            producer = new KafkaProducer<>(props);
            producer.send(new ProducerRecord<>(message.getTopic(), message.getValue()));
            return new PublishResponse("Message has been sent");
        } catch (Exception e) {
            return new PublishResponse("Message sent Failed..!!");
        } finally {
            producer.close();
        }
    }
}