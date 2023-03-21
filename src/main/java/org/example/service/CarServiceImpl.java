package org.example.service;

import org.example.dto.CarCreatedDto;
import org.example.dto.CarDto;
import org.example.dto.CarUpdateDto;
import org.example.exceptions.CarNotFoundException;
import org.example.mapper.CarMapper;
import org.example.model.Car;
import org.example.repository.CarRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class CarServiceImpl implements CarService {

    CarMapper carMapper;
    private CarRepository carRepository;


    @Inject
    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public CarDto createCar(CarCreatedDto carCreatedDto) {
        Car savedCar = carMapper.fromCarCreatedDtoToCarEntity(carCreatedDto);
        carRepository.persistAndFlush(savedCar);
        return carMapper.fromCarEntityToCarDto(savedCar);
    }

    @Override
    public CarDto getCarById(Long carId) {
        Optional<Car> optionalCar = Optional.ofNullable(carRepository.findById(carId));
        return optionalCar.map(carMapper::fromCarEntityToCarDto).orElseThrow(() -> new CarNotFoundException());
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carRepository.listAll();
        return cars.stream()
                .map(carMapper::fromCarEntityToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarDto updateCar(Long carId, CarUpdateDto carUpdateDto) {
        Car carToUpdate = carRepository.findById(carId);
        if (carToUpdate == null) {
            throw new CarNotFoundException();
        }
        if (carUpdateDto.getBrand() != null) {
            carToUpdate.setBrand(carUpdateDto.getBrand());
        }

        if (carUpdateDto.getModel() != null) {
            carToUpdate.setModel(carUpdateDto.getModel());
        }

        if (carUpdateDto.getPricePerDay() <= 0) {
            carToUpdate.setPricePerDay(carUpdateDto.getPricePerDay());
        }

        carRepository.persistAndFlush(carToUpdate);
        return carMapper.fromCarEntityToCarDto(carToUpdate);
    }
}
