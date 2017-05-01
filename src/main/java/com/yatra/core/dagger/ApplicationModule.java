package com.yatra.core.dagger;

import com.yatra.KafkaConfiguration;
import com.yatra.core.config.ConsumerConfiguration;
import com.yatra.core.config.ProducerConfiguration;
import com.yatra.core.kafka.consumers.SimpleConsumer;
import com.yatra.core.kafka.producers.SimpleProducer;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ApplicationModule {

    private final KafkaConfiguration configuration;

    public ApplicationModule(final KafkaConfiguration configuration){
        this.configuration=configuration;
    }


    @Provides
    @Singleton
    ConsumerConfiguration provideConsumerConfiguration(){
        return configuration.getConsumerConfiguration();
    }

    @Provides
    @Singleton
    ProducerConfiguration provideProducerConfiguration(){
        return configuration.getProducerConfiguration();
    }


}