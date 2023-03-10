package com.flux.springreactivecassandracrud.service;

import com.flux.springreactivecassandracrud.dto.BookingDto;
import com.flux.springreactivecassandracrud.dto.BookingRefDto;
import reactor.core.publisher.Mono;

public interface BookingService {

    public Mono<BookingRefDto> book(Mono<BookingDto> bookingDtoMono);
}
