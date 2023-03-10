package com.flux.springreactivecassandracrud.entity;

import com.flux.springreactivecassandracrud.dto.ContainerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bookings")
public class Booking {

    @Id
    private String bookingRef;
    private ContainerType containerType;
    private int containerSize;
    private String origin, destination;
    private int quantity;
    private LocalDateTime timeStamp;
}
