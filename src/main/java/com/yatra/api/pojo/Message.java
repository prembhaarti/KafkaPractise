package com.yatra.api.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String topic;
    private String key;
    private String value;

    public Message(String topic, String key, String value) {
        this.topic=topic;
        this.key=key;
        this.value=value;
    }
}
