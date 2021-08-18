package com.flipkart.core.kafka.callbacks;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerCallback implements Callback{
    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        if (exception != null) {
            System.out.println("Exception occured:"+exception.toString());
        }
        else {
            System.out.println("Offset:"+metadata.offset()+", Partition:"+metadata.partition());
        }
    }
}
