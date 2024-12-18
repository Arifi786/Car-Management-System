package com.example.CarManagement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    // Search by name, model, or fuel type (case-insensitive)
    Page<Car> findByNameContainingIgnoreCaseOrModelContainingIgnoreCaseOrFuelTypeContainingIgnoreCase(
            String name, String model, String fuelType, Pageable pageable);
}

