package com.jerome.random.beer;

public class BeerNotFoundException extends RuntimeException {

    public BeerNotFoundException() {
        super("It was not possible to get any Beer");
    }
}
