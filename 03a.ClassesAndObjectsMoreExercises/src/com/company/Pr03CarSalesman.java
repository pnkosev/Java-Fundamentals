package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr03CarSalesman {
    public static boolean tryParseInt(String someText) {
        try {
            Integer.parseInt(someText);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();

        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        while (numberOfEngines-- > 0) {
            String[] input = scanner.nextLine().split(" +");
            String currEngineModel = input[0];
            int currEnginePower = Integer.parseInt(input[1]);
            String currEngineDisplacement = null;
            String currEngineEfficiency = null;

            switch (input.length) {
                case 3:
                    currEngineDisplacement = tryParseInt(input[2]) ? input[2] : null;
                    if (currEngineDisplacement == null) {
                        currEngineEfficiency = input[2];
                    }
                    break;
                case 4:
                    boolean isDisplacementArgTwo = tryParseInt(input[2]);
                    currEngineDisplacement = isDisplacementArgTwo ? input[2] : input[3];
                    currEngineEfficiency = isDisplacementArgTwo ? input[3] : input[2];
                    break;
            }

            Engine currEngine = new Engine(currEngineModel, currEnginePower, currEngineDisplacement, currEngineEfficiency);
            engineList.add(currEngine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        while (numberOfCars-- > 0) {
            String[] input = scanner.nextLine().split(" +");
            String currCarModel = input[0];
            String currCarEngineModel = input[1];
            String currCarWeight = null;
            String currCarColor = null;

            switch (input.length) {
                case 3:
                    currCarWeight = tryParseInt(input[2]) ? input[2] : null;
                    if (currCarWeight == null) {
                        currCarColor = input[2];
                    }
                    break;
                case 4:
                    boolean isCarWeightArgTwo = tryParseInt(input[2]);
                    currCarWeight = isCarWeightArgTwo ? input[2] : input[3];
                    currCarColor = isCarWeightArgTwo ? input[3] : input[2];
                    break;
            }
            Engine engine = null;
            for (Engine currEngine: engineList) {
                if (currEngine.getModel().equals(currCarEngineModel)) {
                    engine = currEngine;
                }
            }
            Car currCar = new Car(currCarModel, engine, currCarWeight, currCarColor);

            carList.add(currCar);
        }

        for (Car car : carList) {
            System.out.println(String.format(
                    "%s:%n" +
                    "  %s:%n" +
                    "    Power: %s%n" +
                    "    Displacement: %s%n" +
                    "    Efficiency: %s%n" +
                    "  Weight: %s%n" +
                    "  Color: %s",
                    car.getModel(),
                    car.getEngineModel(),
                    car.getEngine().getPower(),
                    car.getEngine().getDisplacement(),
                    car.getEngine().getEfficiency(),
                    car.getWeight(),
                    car.getColor()
            ));
        }
    }

    static class Car {
        String model;
        Engine engine;
        String weight;
        String color;

        public Car(String model, Engine engine, String weight, String color) {
            setModel(model);
            setEngine(engine);
            setWeight(weight);
            setColor(color);
        }

        public String getModel() {
            return this.model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Engine getEngine() {
            return this.engine;
        }

        public String getEngineModel() {
            return this.engine.getModel();
        }

        public void setEngine(Engine engine) {
            this.engine = new Engine(engine.getModel(), engine.getPower(), engine.getDisplacement(), engine.getEfficiency());
        }

        public String getWeight() {
            return this.weight;
        }

        public void setWeight(String weight) {
            if (weight == null) {
                this.weight = "n/a";
                return;
            }
            this.weight = weight;
        }

        public String getColor() {
            return this.color;
        }

        public void setColor(String color) {
            if (color == null) {
                this.color = "n/a";
                return;
            }
            this.color = color;
        }
    }

    static class Engine {
        String model;
        int power;
        String displacement;
        String efficiency;

        public Engine(String model, int power, String displacement, String efficiency) {
            setModel(model);
            setPower(power);
            setDisplacement(displacement);
            setEfficiency(efficiency);
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public void setDisplacement(String displacement) {
            if (displacement == null) {
                this.displacement = "n/a";
                return;
            }
            this.displacement = displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }

        public void setEfficiency(String efficiency) {
            if (efficiency == null) {
                this.efficiency = "n/a";
                return;
            }
            this.efficiency = efficiency;
        }
    }
}
