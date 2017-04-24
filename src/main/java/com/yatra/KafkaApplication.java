package com.yatra;

import com.yatra.resource.ConsumerResource;
import com.yatra.resource.ProducerResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class KafkaApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new KafkaApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        final ProducerResource producerResource= new ProducerResource(configuration.getProducerConfiguration());
        final ConsumerResource consumerResource= new ConsumerResource(configuration.getConsumerConfiguration());
        //        final HelloWorldResource resource = new HelloWorldResource(
//                configuration.getTemplate(),
//                configuration.getDefaultName()
//        );
//        final TemplateHealthCheck healthCheck =
//                new TemplateHealthCheck(configuration.getTemplate());
//        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(producerResource);
        environment.jersey().register(consumerResource);
    }
}