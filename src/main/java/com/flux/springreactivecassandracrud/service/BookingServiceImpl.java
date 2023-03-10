package com.flux.springreactivecassandracrud.service;

import com.flux.springreactivecassandracrud.dto.BookingDto;
import com.flux.springreactivecassandracrud.dto.BookingRefDto;
import com.flux.springreactivecassandracrud.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository repository;

    // TODO: Write test for below service method
    @Override
    public Mono<BookingRefDto> book(Mono<BookingDto> bookingDtoMono) {
        // TODO: needs to implement external API call for booking

        // TODO: needs to implment save booking logic

        return null;
    }
}
