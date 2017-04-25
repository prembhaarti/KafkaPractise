package com.yatra.core.dagger;

import com.yatra.resource.ConsumerResource;
import com.yatra.resource.ProducerResource;
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