package com.yatra.resource;

import com.yatra.api.pojo.MessageResponse;
import com.yatra.consumers.SimpleConsumer;
import com.yatra.core.config.ConsumerConfiguration;

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

    public ConsumerResource(ConsumerConfiguration configuration) {
        this.configuration=configuration;
    }

    @GET
    @Path("/message")
    public List<MessageResponse> consumeMessage(@PathParam("topic") String topic,
                                                @PathParam("group") String group){
        SimpleConsumer consumer= new SimpleConsumer();
        return consumer.consume(configuration,topic,group);
    }
}