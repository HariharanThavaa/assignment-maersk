package com.flux.springreactivecassandracrud.service;

import com.flux.springreactivecassandracrud.dto.AvailableDto;
import com.flux.springreactivecassandracrud.dto.BookingDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CheckAvailabilityServiceImpl implements CheckAvailabilityService {

    // TODO: Write test for below service method
    @Override
    public Mono<AvailableDto> checkAvailable(Mono<BookingDto> bookingDtoMono) {
        // TODO: Needs to call the external API here

        // TODO: Based on the availableNumbers needs to return AvailableDTO
        return null;
    }
}
