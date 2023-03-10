package com.flux.springreactivecassandracrud.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BookingDto {

    private ContainerType containerType;
    private int containerSize;
    private String origin, destination;
    private int quantity;

    // TODO javax.validation.constraints can be used for field validation


}
