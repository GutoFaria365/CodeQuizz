package org.example.service;


import org.example.dto.CarCreatedDto;
import org.example.dto.CarDto;
import org.example.dto.CarUpdateDto;

import java.util.List;


public interface CarService {
    CarDto createCar(CarCreatedDto carDto);

    CarDto getCarById(Long carId);

    List<CarDto> getAllCars();

    CarDto updateCar(Long carId, CarUpdateDto carUpdateDto);

}
