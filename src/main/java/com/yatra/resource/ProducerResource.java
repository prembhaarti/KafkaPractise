package com.yatra.resource;

import com.yatra.api.request.Message;
import com.yatra.api.response.PublishResponse;
import com.yatra.core.config.ProducerConfiguration;
import com.yatra.core.kafka.producers.SimpleProducer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/produce/{topic}")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/produce/{topic}")
public class ProducerResource {

    private ProducerConfiguration configuration;
    private SimpleProducer producer;

    @Inject
    public ProducerResource(SimpleProducer producer, ProducerConfiguration configuration){
        this.producer=producer;
        this.configuration=configuration;
    }

    @GET
    @Path("/publish")
    @ApiOperation(
            value = "publish messages on given topic",
            tags = "Producer",
            notes = "publishes message on given topic",
            response = PublishResponse.class
    )
    public PublishResponse produceMessage(@PathParam("topic") final String topic, @QueryParam("key") String key,
                                          @QueryParam("value") String value){
        return producer.produce(configuration,new Message(topic,key,value));
    }
}