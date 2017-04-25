package com.yatra.core.dagger;

import com.yatra.core.kafka.producers.SimpleProducer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideProducerFactory implements Factory<SimpleProducer> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideProducerFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public SimpleProducer get() {
    return Preconditions.checkNotNull(
        module.provideProducer(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SimpleProducer> create(ApplicationModule module) {
    return new ApplicationModule_ProvideProducerFactory(module);
  }
}
