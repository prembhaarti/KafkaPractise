package com.yatra.core.dagger;

import com.yatra.core.kafka.consumers.SimpleConsumer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideConsumerFactory implements Factory<SimpleConsumer> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideConsumerFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public SimpleConsumer get() {
    return Preconditions.checkNotNull(
        module.provideConsumer(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SimpleConsumer> create(ApplicationModule module) {
    return new ApplicationModule_ProvideConsumerFactory(module);
  }
}
