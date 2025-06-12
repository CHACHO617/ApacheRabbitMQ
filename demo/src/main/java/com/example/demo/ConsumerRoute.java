package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("rabbitmq://localhost/test.camel.queue?username=guest&password=guest")
            .log("Consumidor recibe: ${body}");
    }
}
