package com.yatra.core.dagger;

import com.yatra.core.config.ConsumerConfiguration;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideConsumerConfigurationFactory
    implements Factory<ConsumerConfiguration> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideConsumerConfigurationFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public ConsumerConfiguration get() {
    return Preconditions.checkNotNull(
        module.provideConsumerConfiguration(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ConsumerConfiguration> create(ApplicationModule module) {
    return new ApplicationModule_ProvideConsumerConfigurationFactory(module);
  }
}
