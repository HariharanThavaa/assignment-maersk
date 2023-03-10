package com.flux.springreactivecassandracrud.controller;

import com.flux.springreactivecassandracrud.dto.AvailableDto;
import com.flux.springreactivecassandracrud.dto.BookingDto;
import com.flux.springreactivecassandracrud.dto.BookingRefDto;
import com.flux.springreactivecassandracrud.service.BookingService;
import com.flux.springreactivecassandracrud.service.CheckAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bookings/")
public class BookingController {

    @Autowired
    private CheckAvailabilityService checkAvailabilityService;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/check-availability")
    public Mono<AvailableDto> checkAvailability(@RequestBody Mono<BookingDto> bookingDtoMono) {
        return checkAvailabilityService.checkAvailable(bookingDtoMono);
    }

    @PostMapping("/book")
    public Mono<BookingRefDto> book(@RequestBody Mono<BookingDto> bookingDtoMono) {
        return bookingService.book(bookingDtoMono);
    }
}
