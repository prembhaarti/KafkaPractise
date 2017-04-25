package com.yatra;

import com.yatra.core.dagger.ApplicationComponent;
import com.yatra.core.dagger.ApplicationModule;
import com.yatra.core.dagger.DaggerApplicationComponent;
import com.yatra.health.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class KafkaApplication extends Application<KafkaConfiguration> {
    public static void main(String[] args) throws Exception {
        new KafkaApplication().run(args);
    }

    @Override
    public String getName() {
        return "KAFKA PRACTISE APPLICATION";
    }

    @Override
    public void initialize(Bootstrap<KafkaConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(KafkaConfiguration configuration,
                    Environment environment) {
        ApplicationComponent component = getApplicationComponent(configuration);

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getHealthCheckChunk());
        environment.healthChecks().register("healthCheckChunk", healthCheck);
        environment.jersey().register(component.producerResource());
        environment.jersey().register(component.consumerResource());
    }

    private ApplicationComponent getApplicationComponent(KafkaConfiguration configuration) {
        return DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(configuration))
                .build();
    }

}