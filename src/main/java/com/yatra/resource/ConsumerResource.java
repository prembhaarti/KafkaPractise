package com.yatra.resource;

import com.yatra.api.response.MessageResponse;
import com.yatra.core.config.ConsumerConfiguration;
import com.yatra.core.kafka.consumers.SimpleConsumer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("consume/{topic}/{group}")
@Produces(MediaType.APPLICATION_JSON)
public class ConsumerResource {

    private ConsumerConfiguration configuration;
    private SimpleConsumer consumer;

    @Inject
    public ConsumerResource(SimpleConsumer consumer, ConsumerConfiguration configuration){
        this.consumer=consumer;
        this.configuration=configuration;
    }

    @GET
    @Path("/message")
    public List<MessageResponse> consumeMessage(@PathParam("topic") String topic,
                                                @PathParam("group") String group){
        return consumer.consume(configuration,topic,group);
    }
}