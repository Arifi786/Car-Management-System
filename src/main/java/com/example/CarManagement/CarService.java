package com.example.CarManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    // Add a new car
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    // Get cars with pagination, sorting, and searching
    public Page<Car> getCars(int page, int size, String sortBy, String search) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        if (search == null || search.isBlank()) {
            return carRepository.findAll(pageable);
        }
        return carRepository.findByNameContainingIgnoreCaseOrModelContainingIgnoreCaseOrFuelTypeContainingIgnoreCase(
                search, search, search, pageable);
    }
    public Page<Car> searchCars(String term, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return carRepository.findByNameContainingIgnoreCaseOrModelContainingIgnoreCaseOrFuelTypeContainingIgnoreCase(
                term, term, term, pageable);
    }

    // Get a car by ID
    public Car getCarById(Long id) {
        Optional<Car> carOptional = carRepository.findById(id);
        return carOptional.orElse(null); // Return null if not found
    }

    // Update a car
    public Car updateCar(Long id, Car carDetails) {
        Optional<Car> existingCarOptional = carRepository.findById(id);
        if (existingCarOptional.isPresent()) {
            Car existingCar = existingCarOptional.get();
            existingCar.setName(carDetails.getName());
            existingCar.setModel(carDetails.getModel());
            existingCar.setYear(carDetails.getYear());
            existingCar.setPrice(carDetails.getPrice());
            existingCar.setColor(carDetails.getColor());
            existingCar.setFuelType(carDetails.getFuelType());
            return carRepository.save(existingCar);
        }
        return null; // Return null if car not found
    }

    // Delete a car
    public boolean deleteCar(Long id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            carRepository.deleteById(id);
            return true;
        }
        return false; // Return false if car not found
    }
}
