package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pr04SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> dwarfMap = new LinkedHashMap<>();

        String line;

        while (!(line = scanner.nextLine()).equals("Once upon a time")) {
            String[] input = line.split(" <:> ");
            String dwarfName = input[0];
            String dwarfHatColor = input[1];
            int dwarfPhysics = Integer.parseInt(input[2]);

            String dwarfColorAndName = dwarfName + " " + dwarfHatColor;

            if (!dwarfMap.containsKey(dwarfColorAndName)) {
                dwarfMap.put(dwarfColorAndName, dwarfPhysics);
            } else if (dwarfMap.get(dwarfColorAndName) < dwarfPhysics) {
                dwarfMap.put(dwarfColorAndName, dwarfPhysics);
            }
        }

        Map<String, Integer> finalDwarfMap = dwarfMap;
        dwarfMap = dwarfMap
                .entrySet().stream()
                .sorted((e1, e2) -> {
                    int comparison = e2.getValue().compareTo(e1.getValue());

                    if (comparison == 0) {
                        String colorOne = e1.getKey().split(" ")[1];
                        String colorTwo = e2.getKey().split(" ")[1];

                        int countOne = (int) finalDwarfMap.keySet().stream().filter(e -> e.contains(colorOne)).count();
                        int countTwo = (int) finalDwarfMap.keySet().stream().filter(e -> e.contains(colorTwo)).count();

                        comparison = countTwo - countOne;
                    }
                    return comparison;
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValues, newValues) -> oldValues, LinkedHashMap::new));

        dwarfMap
                .forEach((k, v) -> {
                    System.out.println(String.format("(%s) %s <-> %d",
                            k.split(" ")[1],
                            k.split(" ")[0],
                            v));
                });
    }
}
