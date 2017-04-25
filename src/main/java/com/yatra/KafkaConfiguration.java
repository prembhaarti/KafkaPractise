package com.yatra;

import com.yatra.core.config.ConsumerConfiguration;
import com.yatra.core.config.ProducerConfiguration;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class KafkaConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    private String healthCheckChunk;

    @NotEmpty
    @JsonProperty
    private String defaultName = "Stranger";

    @NotNull
    @JsonProperty("consumerConfig")
    private ConsumerConfiguration consumerConfiguration;

    @NotNull
    @JsonProperty("producerConfig")
    private ProducerConfiguration producerConfiguration;

    @Valid
    @NotNull
    @JsonProperty("swagger")
    private SwaggerBundleConfiguration swaggerBundleConfiguration;

}