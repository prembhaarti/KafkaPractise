package com.yatra.core.kafka.producers;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum AsyncProducer_Factory implements Factory<AsyncProducer> {
  INSTANCE;

  @Override
  public AsyncProducer get() {
    return new AsyncProducer();
  }

  public static Factory<AsyncProducer> create() {
    return INSTANCE;
  }
}
