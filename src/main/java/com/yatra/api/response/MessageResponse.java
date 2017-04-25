package com.yatra.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@ApiModel("response")
public class MessageResponse {

    @NotNull
    @JsonProperty
    private long offSet;

    @NotBlank
    @JsonProperty
    private String key;

    @NotBlank
    @JsonProperty
    private String value;

    public MessageResponse(long offSet, String key, String value) {
        this.offSet = offSet;
        this.key = key;
        this.value = value;
    }
}