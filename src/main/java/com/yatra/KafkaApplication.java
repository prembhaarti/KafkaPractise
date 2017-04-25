package com.yatra;

import com.yatra.health.TemplateHealthCheck;
import com.yatra.resource.ConsumerResource;
import com.yatra.resource.ProducerResource;
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
        final ProducerResource producerResource= new ProducerResource(configuration.getProducerConfiguration());
        final ConsumerResource consumerResource= new ConsumerResource(configuration.getConsumerConfiguration());
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getHealthCheckChunk());
        environment.healthChecks().register("healthCheckChunk", healthCheck);
        environment.jersey().register(producerResource);
        environment.jersey().register(consumerResource);
    }
}