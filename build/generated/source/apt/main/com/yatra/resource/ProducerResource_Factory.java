package com.yatra.resource;

import com.yatra.core.config.ProducerConfiguration;
import com.yatra.core.kafka.producers.SimpleProducer;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ProducerResource_Factory implements Factory<ProducerResource> {
  private final Provider<SimpleProducer> producerProvider;

  private final Provider<ProducerConfiguration> configurationProvider;

  public ProducerResource_Factory(
      Provider<SimpleProducer> producerProvider,
      Provider<ProducerConfiguration> configurationProvider) {
    assert producerProvider != null;
    this.producerProvider = producerProvider;
    assert configurationProvider != null;
    this.configurationProvider = configurationProvider;
  }

  @Override
  public ProducerResource get() {
    return new ProducerResource(producerProvider.get(), configurationProvider.get());
  }

  public static Factory<ProducerResource> create(
      Provider<SimpleProducer> producerProvider,
      Provider<ProducerConfiguration> configurationProvider) {
    return new ProducerResource_Factory(producerProvider, configurationProvider);
  }
}
