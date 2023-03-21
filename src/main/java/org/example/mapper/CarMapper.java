package org.example.mapper;


import org.example.dto.CarCreatedDto;
import org.example.dto.CarDto;
import org.example.model.Car;
import org.mapstruct.Mapper;

import javax.enterprise.context.ApplicationScoped;

@Mapper(componentModel = "cdi")
public interface CarMapper {

    CarDto fromCarEntityToCarDto(Car car);

    CarDto fromCarCreatedDtoToCarDto(CarCreatedDto carCreatedDto);

    Car fromCarDtoToCarEntity(CarDto carDto);

    Car fromCarCreatedDtoToCarEntity(CarCreatedDto carCreatedDto);
}

