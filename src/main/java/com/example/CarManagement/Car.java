//package com.example.CarManagement;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//public class Car {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private String model;
//
//    @Column(nullable = false)
//    private int year;
//
//    @Column(nullable = false)
//    private double price;
//
//    @Column(nullable = false)
//    private String color;
//
//    @Column(nullable = false)
//    private String fuelType; // Example: Petrol, Diesel, Electric
//}
package com.example.CarManagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;


@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Car name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Car model is required")
    @Column(nullable = false)
    private String model;

    @NotNull(message = "Car year is required")
    @Min(value = 1900, message = "Year must be greater than or equal to 1900")
    @Max(value = 2024, message = "Year cannot be greater than the current year")
    @Column(nullable = false)
    private int year;

    @NotNull(message = "Car price is required")
    @Min(value = 1, message = "Price must be greater than 0")
    @Column(nullable = false)
    private double price;

    @NotBlank(message = "Car color is required")
    @Column(nullable = false)
    private String color;

    @NotBlank(message = "Fuel type is required")
    @Column(nullable = false)
    private String fuelType; // Example: Petrol, Diesel, Electric
}
