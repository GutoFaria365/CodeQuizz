package org.example.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.example.model.Car;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {
}
