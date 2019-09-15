package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pr01Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maximumPassengers = Integer.parseInt(scanner.nextLine());

        String line;

        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.contains("Add")) {
                int wagon = Integer.parseInt(line.split(" ")[1]);
                wagons.add(wagon);
                continue;
            }
            int passengers = Integer.parseInt(line);

            for (int i = 0; i < wagons.size(); i++) {
                if (wagons.get(i) + passengers <= maximumPassengers) {
                    wagons.set(i, wagons.get(i) + passengers);
                    break;
                }
            }
        }
        for (int wagon: wagons) {
            System.out.printf("%d ", wagon);
        }
        System.out.println();
    }
}
