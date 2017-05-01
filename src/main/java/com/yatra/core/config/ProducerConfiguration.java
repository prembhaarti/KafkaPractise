package com.yatra.core.config;

import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

@Getter
public class ProducerConfiguration {

    @NotBlank
    private String bootstrapServers;

    @NotBlank
    private String acknowledgment;

    @NotNull
    private Integer retries;
    
    @NotNull
    private Integer batchSize;

    @NotNull
    private Integer lingerMs;

    @NotNull
    private Integer bufferMemory;
    
    @NotBlank
    private String keySerializer;
    
    @NotBlank
    private String valueSerializer;

}
