package com.flipkart.core.kafka.producers;

import com.flipkart.api.request.Message;
import com.flipkart.api.response.PublishResponse;
import com.flipkart.core.config.ProducerConfiguration;
import com.flipkart.core.kafka.callbacks.ProducerCallback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Properties;

    @Singleton
    public class AsyncProducer {

        @Inject
        public AsyncProducer(){}

        public PublishResponse produce(ProducerConfiguration configuration, Message message){
            Properties props = new Properties();
            //--compulsory
            //kafka brokers
            props.put("bootstrap.servers", configuration.getBootstrapServers());
            props.put("key.serializer", configuration.getKeySerializer());
            props.put("value.serializer", configuration.getValueSerializer());

            //Set acknowledgements for producer requests.
            props.put("acks", configuration.getAcknowledgment());
            //If the request fails, the producer can automatically retry
            //if leader was down and time gap b/w next leader elected, retry and get succeded
            props.put("retries", configuration.getRetries());
            //Specify buffer size in config
            props.put("batch.size", configuration.getBatchSize());
            //Reduce the no of requests less than 0
            props.put("linger.ms", configuration.getLingerMs());
            //The buffer.memory controls the total amount of memory available to the producer for buffering.
            props.put("buffer.memory", configuration.getBufferMemory());

            Producer<String, String> producer = null;
            try {
                producer = new KafkaProducer<>(props);
                producer.send(new ProducerRecord<>(message.getTopic(), message.getValue()), new ProducerCallback());
                return new PublishResponse("Message sent to Offset");
            } catch (Exception e) {
                return new PublishResponse("Message sent Failed..!!");
            } finally {
                producer.close();
                //clean all resources it might be using.
            }
        }
    }