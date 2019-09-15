package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pr06VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();

        String line;

        while (!(line = scanner.nextLine()).equals("End")) {
            String[] input = line.split(" ");
            String type = input[0];
            String model = input[1];
            String color = input[2];
            int hp = Integer.parseInt(input[3]);

            Vehicle vehicle = new Vehicle(type, model, color, hp);
            vehicles.add(vehicle);
        }

        while (!(line = scanner.nextLine()).equals("Close the Catalogue")) {
            String model = line;

            vehicles
                    .stream()
                    .filter(e -> e.getModel().equals(model))
                    .forEach(e -> System.out.println(String.format(
                            "Type: %s%n" +
                            "Model: %s%n" +
                            "Color: %s%n" +
                            "Horsepower: %s",
                            e.getType().equals("car") ? "Car" : "Truck", e.getModel(), e.getColor(), e.getHp()
                    )));
        }

        System.out.println(String.format(
                "Cars have average horsepower of: %.2f.",
                getAverageHp(vehicles.stream().filter(v -> v.getType().equals("car")).collect(Collectors.toList()))
        ));

        System.out.println(String.format(
                "Trucks have average horsepower of: %.2f.",
                getAverageHp(vehicles.stream().filter(v -> v.getType().equals("truck")).collect(Collectors.toList()))
        ));
    }

    public static double getAverageHp(List<Vehicle> vehicles) {
        if (vehicles.size() == 0) {
            return 0.0;
        }
        double sum = 0;

        for (Vehicle vehicle: vehicles) {
            sum += vehicle.getHp();
        }

        return sum / vehicles.size();
    }

    static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int hp;
        public Vehicle(String type, String model, String color, int hp) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.hp = hp;
        }

        public String getType() {
            return this.type;
        }

        public String getModel() {
            return this.model;
        }

        public String getColor() {
            return this.color;
        }

        public int getHp() {
            return this.hp;
        }
    }
}
