package com.yatra.core.kafka.producers;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum SimpleProducer_Factory implements Factory<SimpleProducer> {
  INSTANCE;

  @Override
  public SimpleProducer get() {
    return new SimpleProducer();
  }

  public static Factory<SimpleProducer> create() {
    return INSTANCE;
  }
}
