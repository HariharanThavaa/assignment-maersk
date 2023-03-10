package com.flux.springreactivecassandracrud.repository;

import com.flux.springreactivecassandracrud.entity.Booking;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends ReactiveMongoRepository<Booking,String> {}
