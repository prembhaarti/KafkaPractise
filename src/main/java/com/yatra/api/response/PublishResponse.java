package com.yatra.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel("response")
public class PublishResponse {

    @JsonProperty("response")
    private String response;

    public PublishResponse(String response) {
        this.response=response;
    }
}