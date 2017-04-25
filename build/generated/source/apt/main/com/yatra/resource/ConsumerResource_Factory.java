package com.yatra.resource;

import com.yatra.core.config.ConsumerConfiguration;
import com.yatra.core.kafka.consumers.SimpleConsumer;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ConsumerResource_Factory implements Factory<ConsumerResource> {
  private final Provider<SimpleConsumer> consumerProvider;

  private final Provider<ConsumerConfiguration> configurationProvider;

  public ConsumerResource_Factory(
      Provider<SimpleConsumer> consumerProvider,
      Provider<ConsumerConfiguration> configurationProvider) {
    assert consumerProvider != null;
    this.consumerProvider = consumerProvider;
    assert configurationProvider != null;
    this.configurationProvider = configurationProvider;
  }

  @Override
  public ConsumerResource get() {
    return new ConsumerResource(consumerProvider.get(), configurationProvider.get());
  }

  public static Factory<ConsumerResource> create(
      Provider<SimpleConsumer> consumerProvider,
      Provider<ConsumerConfiguration> configurationProvider) {
    return new ConsumerResource_Factory(consumerProvider, configurationProvider);
  }
}
