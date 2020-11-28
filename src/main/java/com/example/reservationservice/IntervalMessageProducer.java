package com.example.reservationservice;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

@Component
public class IntervalMessageProducer {
    Flux<GreetingResponse> produceGreetings(GreetingRequest greetingRequest) {
        return Flux.fromStream(Stream.generate(() -> "Hello" + greetingRequest.getName() + " @ " + Instant.now()))
                .map(GreetingResponse::new)
                .delayElements(Duration.ofSeconds(5));
    }
}
