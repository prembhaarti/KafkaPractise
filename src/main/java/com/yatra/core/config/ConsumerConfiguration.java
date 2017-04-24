package com.yatra.core.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Getter
public class ConsumerConfiguration {

    @NotBlank
    @JsonProperty
    private String bootstrapServers;

    @NotBlank
    @JsonProperty
    private boolean enableAutoCommit;

    @NotBlank
    @JsonProperty
    private String groupId;

    @NotNull
    @JsonProperty
    private Integer autoCommitIntervalMs;

    @NotBlank
    @JsonProperty
    private String autoOffsetReset;

    @NotNull
    @JsonProperty
    private Integer sessionTimeOutMs;

    @NotBlank
    @JsonProperty
    private String keyDeserializer;

    @NotBlank
    @JsonProperty
    private String valueDeserializer;

    @NotNull
    @JsonProperty
    private Integer pollTime;
}
