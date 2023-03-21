package org.example.mapper;


import org.example.dto.CarCreatedDto;
import org.example.dto.CarDto;
import org.example.model.Car;
import org.mapstruct.Mapper;


@Mapper(componentModel = "quarkus")
public interface CarMapper {

    CarDto fromCarEntityToCarDto(Car car);

    CarDto fromCarCreatedDtoToCarDto(CarCreatedDto carCreatedDto);

    Car fromCarDtoToCarEntity(CarDto carDto);

    Car fromCarCreatedDtoToCarEntity(CarCreatedDto carCreatedDto);
}
