package com.example.sourceapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

@EnableBinding(Source.class)
@SpringBootApplication
public class SourceApp {

    public static void main(String[] args) {
        SpringApplication.run(SourceApp.class, args);
    }

    /*
     * poller configured with spring.integration.poller.fixed-delay property (see ChannelBindingAutoConfiguration)
     */
    @InboundChannelAdapter(value = Source.OUTPUT)
    public Greeting source() {
        return new Greeting("hello world");
    }

    /*
     * headers: contentType: application/json
     * Payload: { "greeting":"hello world" }
     */
    @Getter
    @AllArgsConstructor
    static class Greeting {
        String greeting;
    }

}
