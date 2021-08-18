package com.flipkart;

import com.flipkart.core.dagger.ApplicationComponent;
import com.flipkart.core.dagger.ApplicationModule;
import com.yatra.core.dagger.DaggerApplicationComponent;
import com.flipkart.health.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

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
        bootstrap.addBundle(createSwaggerBundle());

    }

    @Override
    public void run(KafkaConfiguration configuration,
                    Environment environment) {
        ApplicationComponent component = getApplicationComponent(configuration);

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getHealthCheckChunk());
        environment.healthChecks().register("healthCheckChunk", healthCheck);
        registerJerseyResources(environment,component);
    }

    private ApplicationComponent getApplicationComponent(KafkaConfiguration configuration) {
        return DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(configuration))
                .build();
    }

    private void registerJerseyResources(Environment environment, ApplicationComponent component){
        environment.jersey().register(component.producerResource());
        environment.jersey().register(component.consumerResource());
    }

    private SwaggerBundle<KafkaConfiguration> createSwaggerBundle(){
        return new SwaggerBundle<KafkaConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(KafkaConfiguration configuration) {
                return configuration.getSwaggerBundleConfiguration();
            }
        };
    }

}