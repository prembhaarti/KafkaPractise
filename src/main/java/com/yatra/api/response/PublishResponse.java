package com.yatra.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublishResponse {

    @JsonProperty("response")
    private String response;

    public PublishResponse(String response) {
        this.response=response;
    }
}
