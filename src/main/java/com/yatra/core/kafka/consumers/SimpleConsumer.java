package com.yatra.core.kafka.consumers;

import com.yatra.api.response.MessageResponse;
import com.yatra.core.config.ConsumerConfiguration;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Singleton
public class SimpleConsumer {

    @Inject
    public SimpleConsumer(){}

    public List<MessageResponse> consume(ConsumerConfiguration configuration,String topic,String group){
        Properties props = new Properties();
        props.put("bootstrap.servers", configuration.getBootstrapServers());
        props.put("group.id", group);
        props.put("enable.auto.commit", configuration.isEnableAutoCommit());
        props.put("auto.commit.interval.ms", configuration.getAutoCommitIntervalMs());
        props.put("auto.offset.reset", configuration.getAutoOffsetReset());
        props.put("session.timeout.ms", configuration.getSessionTimeOutMs());
        props.put("key.deserializer", configuration.getKeyDeserializer());
        props.put("value.deserializer", configuration.getValueDeserializer());

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(props);
        kafkaConsumer.subscribe(Arrays.asList(topic));
        List<MessageResponse> messageResponses = new ArrayList<>();
        ConsumerRecords<String, String> records = kafkaConsumer.poll(configuration.getPollTime());
        for (ConsumerRecord<String, String> record : records) {
            System.out.println(record.toString());
            messageResponses.add(new MessageResponse(record.offset(),record.key(),record.value()));
        }
        kafkaConsumer.close();
        return messageResponses;
    }
}