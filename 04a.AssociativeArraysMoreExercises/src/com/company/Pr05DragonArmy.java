package com.company;

import java.util.*;

public class Pr05DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, List<Integer>>> dragonMap = new LinkedHashMap<>();

        int numberOfDragons = Integer.parseInt(scanner.nextLine());

        while (numberOfDragons-- > 0) {
            String[] input = scanner.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            int damage = input[2].equals("null") ? 45 : Integer.parseInt(input[2]);
            int health = input[3].equals("null") ? 250 : Integer.parseInt(input[3]);
            int armor = input[4].equals("null") ? 10 : Integer.parseInt(input[4]);

            if (!dragonMap.containsKey(type)) {
                LinkedHashMap<String, List<Integer>> currDragon = new LinkedHashMap<>();
                List<Integer> currDragonStats = new ArrayList<>(Arrays.asList(damage, health, armor));
                currDragon.put(name, currDragonStats);
                dragonMap.put(type, currDragon);
            } else if (dragonMap.containsKey(type)) {
                List<Integer> currDragonStats = new ArrayList<>(Arrays.asList(damage, health, armor));
                dragonMap.get(type).put(name, currDragonStats);
            }
        }

        dragonMap
                .forEach((k, v) -> {
                    System.out.println(String.format(
                            "%s::(%.2f/%.2f/%.2f)",
                            k, getAverageDamage(v), getAverageHealth(v), getAverageArmor(v)
                    ));
                    v.entrySet().stream()
                            .sorted(Comparator.comparing(Map.Entry::getKey))
                            .forEach(entry -> {
                                System.out.println(String.format(
                                        "-%s -> damage: %d, health: %d, armor: %d",
                                        entry.getKey(), entry.getValue().get(0), entry.getValue().get(1), entry.getValue().get(2)
                                ));
                            });
                });
    }

    public static double getAverageDamage(Map<String, List<Integer>> entry) {
        return entry.values().stream().mapToInt(integers -> integers.get(0)).average().getAsDouble();
    }

    public static double getAverageHealth(Map<String, List<Integer>> entry) {
        return entry.values().stream().mapToInt(integers -> integers.get(1)).average().getAsDouble();
    }

    public static double getAverageArmor(Map<String, List<Integer>> entry) {
        return entry.values().stream().mapToInt(integers -> integers.get(2)).average().getAsDouble();
    }
}
