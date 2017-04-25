package com.yatra.core.dagger;

import com.yatra.core.config.ProducerConfiguration;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideProducerConfigurationFactory
    implements Factory<ProducerConfiguration> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideProducerConfigurationFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public ProducerConfiguration get() {
    return Preconditions.checkNotNull(
        module.provideProducerConfiguration(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ProducerConfiguration> create(ApplicationModule module) {
    return new ApplicationModule_ProvideProducerConfigurationFactory(module);
  }
}
