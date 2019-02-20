package com.jerome.random.beer;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BeerDto {

    private final String name;
    private final String description;
    private final Double abv;
    private final String breweryLocation;

}
