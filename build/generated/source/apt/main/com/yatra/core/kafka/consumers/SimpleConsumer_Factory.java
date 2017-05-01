package com.yatra.core.kafka.consumers;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum SimpleConsumer_Factory implements Factory<SimpleConsumer> {
  INSTANCE;

  @Override
  public SimpleConsumer get() {
    return new SimpleConsumer();
  }

  public static Factory<SimpleConsumer> create() {
    return INSTANCE;
  }
}
