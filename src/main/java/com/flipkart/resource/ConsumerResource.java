package com.flipkart.resource;

import com.flipkart.api.response.MessageResponse;
import com.flipkart.core.config.ConsumerConfiguration;
import com.flipkart.core.kafka.consumers.SimpleConsumer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("consume/{topic}/{group}")
@Produces(MediaType.APPLICATION_JSON)
@Api(value= "consume/{topic}/{group}")
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
    @ApiOperation(
            value = "consumes messages from given topic",
            tags = "Consumer",
            notes = "consumes message from given topic and sets a consumer group",
            response = MessageResponse.class
    )
    public List<MessageResponse> consumeMessage(@PathParam("topic") String topic,
                                                @PathParam("group") String group){
        return consumer.consume(configuration,topic,group);
    }
}