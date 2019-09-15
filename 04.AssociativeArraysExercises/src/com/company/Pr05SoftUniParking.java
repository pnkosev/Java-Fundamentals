package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> userList = new LinkedHashMap<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        while (numberOfCars-- > 0) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String user = input[1];

            switch (command) {
                case "register":
                    String carLicensePlate = input[2];
                    if (!userList.containsKey(user)) {
                        userList.put(user, carLicensePlate);
                        System.out.println(String.format("%s registered %s successfully", user, carLicensePlate));
                    } else {
                        System.out.println(String.format("ERROR: already registered with plate number %s", carLicensePlate));
                    }
                    break;
                case "unregister":
                    if (userList.containsKey(user)) {
                        userList.remove(user);
                        System.out.println(String.format("%s unregistered successfully", user));
                    } else {
                        System.out.println(String.format("ERROR: user %s not found", user));
                    }
                    break;
            }
        }
        userList.forEach((k, v) -> System.out.println(String.format("%s => %s", k, v)));
    }
}
