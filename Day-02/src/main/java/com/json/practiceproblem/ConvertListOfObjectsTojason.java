package com.json.practiceproblem;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

class Car {
    private String brand;
    private String model;
    private int year;

    // Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters (required for serialization)
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

public class ConvertListOfObjectsTojason {
    public static void main(String[] args) {
        try {
            // Create a list of Car objects
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("Toyota", "Corolla", 2022));
            cars.add(new Car("Honda", "Civic", 2023));
            cars.add(new Car("Ford", "Mustang", 2021));

            // Convert list to JSON array
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cars);

            // Print JSON array
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
