package com.flipkart.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Message {
    private String topic;
    private String key;
    private String value;
}
