package com.flipkart.core.dagger;

import com.flipkart.resource.ConsumerResource;
import com.flipkart.resource.ProducerResource;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {

    ProducerResource producerResource();
    ConsumerResource consumerResource();

    @Component.Builder
    interface Builder {
        Builder applicationModule(final ApplicationModule applicationModule);
        ApplicationComponent build();
    }
}