package com.example.reservationservice;

import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationRestController {
    private final ReservationRepository reservationRepository;
    private final IntervalMessageProducer messageProducer;

    @GetMapping("/reservations")
    Publisher<Reservation> reservationPublisher() {
        return reservationRepository.findAll();
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/sse/{name}")
    Publisher<GreetingResponse> stringPublisher(@PathVariable String name) {
        return messageProducer.produceGreetings(new GreetingRequest(name));
    }
}
