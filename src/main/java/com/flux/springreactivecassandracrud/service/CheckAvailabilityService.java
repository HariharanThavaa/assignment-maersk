package com.flux.springreactivecassandracrud.service;

import com.flux.springreactivecassandracrud.dto.AvailableDto;
import com.flux.springreactivecassandracrud.dto.BookingDto;
import reactor.core.publisher.Mono;


public interface CheckAvailabilityService {

    public Mono<AvailableDto> checkAvailable(Mono<BookingDto> bookingDtoMono);
}
