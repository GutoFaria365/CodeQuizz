package org.example.service;

import academy.mindswap.rentacar.dto.CarCreatedDto;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.dto.CarUpdateDto;

import java.util.List;

public interface CarService {
    CarDto createCar(CarCreatedDto carDto);

    CarDto getCarById(Long carId);

    List<CarDto> getAllCars();

    CarDto updateCar(Long carId, CarUpdateDto carUpdateDto);

}
