package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr02RawData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carList = new ArrayList<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        while (numberOfCars-- > 0) {
            String[] carInfo = scanner.nextLine().split(" +");

            Car car = new Car(carInfo);
            carList.add(car);
        }

        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
                List<String> modelList = new ArrayList<>();
                for (Car c : carList) {
                    if (c.getCargo().getType().equals("fragile")) {
                        for (Tire t : c.getTires()) {
                            if (t.getPressure() < 1) {
                                if (!modelList.contains(c.getModel())) {
                                    modelList.add(c.getModel());
                                }
                            }
                        }
                    }
                }
                modelList.forEach(System.out::println);
                break;
            case "flamable":
                for (Car c : carList) {
                    if (c.getCargo().getType().equals("flamable")) {
                        if (c.getEngine().getPower() > 250) {
                            System.out.println(c.getModel());
                        }
                    }
                }
                break;
        }
    }

    static class Car {
        String model;
        Engine engine;
        Cargo cargo;
        Tire[] tires = new Tire[4];

        public Car(String[] carInfo) {
            this.model = carInfo[0];
            this.engine = new Engine(Integer.parseInt(carInfo[1]), Integer.parseInt(carInfo[2]));
            this.cargo = new Cargo(Integer.parseInt(carInfo[3]), carInfo[4]);
            setTires(carInfo);
        }

        public void setTires(String[] carInfo) {
            int counter = 0;
            for (int i = 5; i < 13; i += 2) {
                double pressure = Double.parseDouble(carInfo[i]);
                int age = Integer.parseInt(carInfo[i + 1]);
                this.tires[counter++] = new Tire(pressure, age);
            }
        }

        public Tire[] getTires() {
            return tires;
        }

        public Engine getEngine() {
            return engine;
        }

        public Cargo getCargo() {
            return cargo;
        }

        public String getModel() {
            return model;
        }
    }

    static class Engine {
        int speed;
        int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public int getPower() {
            return power;
        }
    }

    static class Cargo {
        int weight;
        String type;

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    static class Tire {
        double pressure;
        int age;

        public Tire(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

        public double getPressure() {
            return pressure;
        }
    }
}
