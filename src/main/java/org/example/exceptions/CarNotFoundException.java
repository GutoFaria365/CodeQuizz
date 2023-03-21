package org.example.exceptions;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException() {
        super("Car not found");
    }
}
