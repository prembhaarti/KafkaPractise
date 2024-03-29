package com.flipkart.core.dagger;

import com.flipkart.KafkaConfiguration;
import com.flipkart.core.config.ConsumerConfiguration;
import com.flipkart.core.config.ProducerConfiguration;
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