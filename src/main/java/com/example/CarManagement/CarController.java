package com.example.CarManagement;

//import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarService carService;

    // Create: Add a new car
    @Operation(summary = "Add a new car", description = "Create a new car entry in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Car created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Car> addCar(@Valid @RequestBody Car car) {
        Car savedCar = carService.addCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    // Read: Get all cars with pagination, sorting, and searching
    @Operation(summary = "Get all cars", description = "Retrieve a paginated list of cars with optional search and sorting.")
    @GetMapping

    public ResponseEntity<Page<Car>> getCars(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
          @RequestParam(defaultValue = "") String search) {
        Page<Car> cars = carService.getCars(page, size, sortBy, search);
        return ResponseEntity.ok(cars);
    }
    @Operation(summary = "Get a car by name, fuel, model", description = "Retrieve details of a specific car using its ID.")
    @GetMapping("/search/{term}")
    public ResponseEntity<Page<Car>> searchCars(
            @PathVariable String term,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Page<Car> cars = carService.searchCars(term, page, size, sortBy);
        return ResponseEntity.ok(cars);
    }


    // Read: Get a single car by ID

    @Operation(summary = "Get a car by ID", description = "Retrieve details of a specific car using its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car found"),
            @ApiResponse(responseCode = "404", description = "Car not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Update: Update the details of an existing car
    @Operation(summary = "Update car details", description = "Modify details of an existing car.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car updated successfully"),
            @ApiResponse(responseCode = "404", description = "Car not found", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @Valid @RequestBody Car carDetails) {
        Car updatedCar = carService.updateCar(id, carDetails);
        if (updatedCar != null) {
            return ResponseEntity.ok(updatedCar);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete: Delete a car entry
    @Operation(summary = "Delete a car", description = "Remove a car entry from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Car deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Car not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        boolean isDeleted = carService.deleteCar(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

