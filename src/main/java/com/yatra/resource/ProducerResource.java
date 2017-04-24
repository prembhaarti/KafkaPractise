package com.yatra.resource;

import com.yatra.api.pojo.Message;
import com.yatra.api.response.PublishResponse;
import com.yatra.core.config.ProducerConfiguration;
import com.yatra.producers.SimpleProducer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/produce/{topic}")
@Produces(MediaType.APPLICATION_JSON)
public class ProducerResource {

    private ProducerConfiguration configuration;

    public ProducerResource(ProducerConfiguration configuration){
        this.configuration=configuration;
    }

    @GET
    @Path("/publish")
    public PublishResponse produceMessage(@PathParam("topic") final String topic, @QueryParam("key") String key,
                                          @QueryParam("value") String value){
        SimpleProducer producer= new SimpleProducer();
        return producer.produce(configuration,new Message(topic,key,value));
    }
}