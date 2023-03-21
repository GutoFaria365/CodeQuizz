package org.example.controller;


import org.example.dto.CarCreatedDto;
import org.example.dto.CarDto;
import org.example.dto.CarUpdateDto;
import org.example.service.CarService;
import org.jboss.resteasy.reactive.MultipartForm;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/car")
public class CarController {

    private CarService carService;

    @Inject
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GET
    @Path("/all")
    public Response getAllCars() {

        List<CarDto> cars = carService.getAllCars();
        return Response.ok(cars).build();
    }

    @GET
    @Path("/{id}")
    public Response getCarById(@PathParam("id") Long id) {
        CarDto carDto = carService.getCarById(id);
        return Response.ok(carDto).build();
    }

    @POST
    public Response createCar(@Valid @MultipartForm CarCreatedDto carCreatedDto) {

        CarDto savedCar = carService.createCar(carCreatedDto);
        return Response.ok(carCreatedDto).build();
    }

    @POST
    @Path("/{id}")
    public Response updateCar(@PathParam("id") Long id, @Valid @MultipartForm CarUpdateDto carUpdateDto) {

        CarDto updatedCar = carService.updateCar(id, carUpdateDto);
        return Response.ok(carUpdateDto).build();
    }
}
