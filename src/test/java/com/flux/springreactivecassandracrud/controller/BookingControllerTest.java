package com.flux.springreactivecassandracrud.controller;

import com.flux.springreactivecassandracrud.dto.AvailableDto;
import com.flux.springreactivecassandracrud.dto.BookingDto;

import com.flux.springreactivecassandracrud.dto.BookingRefDto;
import com.flux.springreactivecassandracrud.service.BookingService;
import com.flux.springreactivecassandracrud.service.CheckAvailabilityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static com.flux.springreactivecassandracrud.dto.ContainerType.REEFER;
import static org.mockito.Mockito.when;
import static com.flux.springreactivecassandracrud.dto.ContainerType.DRY;

@ExtendWith(SpringExtension.class)
@WebFluxTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    private CheckAvailabilityService service;

    @MockBean
    private BookingService bookingService;

    @Test
    void testCheckAvailabilityTrue() {
        Mono<BookingDto> bookingDtoMono = Mono.just(new BookingDto(DRY, 20, "Southampton", "Singapore", 5));
        Mono<AvailableDto> availableDtoMono = Mono.just(new AvailableDto(true));
        when(service.checkAvailable(bookingDtoMono)).thenReturn(availableDtoMono);

        Flux<AvailableDto> responseBody = client.post().uri("/api/bookings/check-availability")
                .body(Mono.just(bookingDtoMono), AvailableDto.class)
                .exchange()
                .expectStatus().isOk()
                .returnResult(AvailableDto.class)
                .getResponseBody();

        StepVerifier.create(responseBody)
                .expectSubscription()
                .expectNext(new AvailableDto(true))
                .verifyComplete();

    }

    @Test
    void testCheckAvailabilityFalse() {
        Mono<BookingDto> bookingDtoMono = Mono.just(new BookingDto(REEFER, 20, "Southampton", "Singapore", 5));
        Mono<AvailableDto> availableDtoMono = Mono.just(new AvailableDto(false));
        when(service.checkAvailable(bookingDtoMono)).thenReturn(availableDtoMono);

        Flux<AvailableDto> responseBody = client.post().uri("/api/bookings/check-availability")
                .body(Mono.just(bookingDtoMono), AvailableDto.class)
                .exchange()
                .expectStatus().isOk()
                .returnResult(AvailableDto.class)
                .getResponseBody();

        StepVerifier.create(responseBody)
                .expectSubscription()
                .expectNext(new AvailableDto(false))
                .verifyComplete();
    }

    //TODO : Field validate scenarios test needs to be written for checkAvailablity endpoint

    @Test
    void book() {
        Mono<BookingDto> bookingDtoMono = Mono.just(new BookingDto(DRY, 20, "Southampton", "Singapore", 5));
        Mono<BookingRefDto> bookingRefDtoMono = Mono.just(new BookingRefDto("957000002"));
        when(bookingService.book(bookingDtoMono)).thenReturn(bookingRefDtoMono);

        client.post().uri("/api/bookings/book")
                .body(Mono.just(bookingDtoMono), BookingRefDto.class)
                .exchange()
                .expectStatus().isOk();
    }

    //TODO : Invalid scenarios test needs to be written for book endpoint
}