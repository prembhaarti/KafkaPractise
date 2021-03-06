package com.yatra.core.dagger;

import com.yatra.core.config.ConsumerConfiguration;
import com.yatra.core.config.ProducerConfiguration;
import com.yatra.core.kafka.consumers.SimpleConsumer;
import com.yatra.core.kafka.consumers.SimpleConsumer_Factory;
import com.yatra.core.kafka.producers.SimpleProducer;
import com.yatra.core.kafka.producers.SimpleProducer_Factory;
import com.yatra.resource.ConsumerResource;
import com.yatra.resource.ConsumerResource_Factory;
import com.yatra.resource.ProducerResource;
import com.yatra.resource.ProducerResource_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<SimpleProducer> simpleProducerProvider;

  private Provider<ProducerConfiguration> provideProducerConfigurationProvider;

  private Provider<ProducerResource> producerResourceProvider;

  private Provider<SimpleConsumer> simpleConsumerProvider;

  private Provider<ConsumerConfiguration> provideConsumerConfigurationProvider;

  private Provider<ConsumerResource> consumerResourceProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static ApplicationComponent.Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.simpleProducerProvider = DoubleCheck.provider(SimpleProducer_Factory.create());

    this.provideProducerConfigurationProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideProducerConfigurationFactory.create(
                builder.applicationModule));

    this.producerResourceProvider =
        ProducerResource_Factory.create(
            simpleProducerProvider, provideProducerConfigurationProvider);

    this.simpleConsumerProvider = DoubleCheck.provider(SimpleConsumer_Factory.create());

    this.provideConsumerConfigurationProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideConsumerConfigurationFactory.create(
                builder.applicationModule));

    this.consumerResourceProvider =
        ConsumerResource_Factory.create(
            simpleConsumerProvider, provideConsumerConfigurationProvider);
  }

  @Override
  public ProducerResource producerResource() {
    return producerResourceProvider.get();
  }

  @Override
  public ConsumerResource consumerResource() {
    return consumerResourceProvider.get();
  }

  private static final class Builder implements ApplicationComponent.Builder {
    private ApplicationModule applicationModule;

    @Override
    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    @Override
    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }
  }
}
