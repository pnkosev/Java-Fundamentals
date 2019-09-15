package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Pr03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMats = new HashMap<>();
        keyMats.put("shards", 0);
        keyMats.put("fragments", 0);
        keyMats.put("motes", 0);

        Map<String, Integer> junkMats = new TreeMap<>();

        boolean isNotEnough = true;
        String winningMat = "none";

        while (isNotEnough) {
            String[] input = scanner.nextLine().split(" ");
            for (int i = 0; i < input.length; i += 2) {
                int amount = Integer.parseInt(input[i]);
                String mat = input[i + 1].toLowerCase();

                if (keyMats.containsKey(mat)) {

                    keyMats.put(mat, keyMats.get(mat) + amount);

                    if (keyMats.get(mat) >= 250) {
                        keyMats.put(mat, keyMats.get(mat) - 250);
                        winningMat = mat;
                        isNotEnough = false;
                        break;
                    }
                } else {
                    if (!junkMats.containsKey(mat)) {
                        junkMats.put(mat, amount);
                    } else {
                        junkMats.put(mat, junkMats.get(mat) + amount);
                    }
                }
            }
        }

        String item = "none";

        switch (winningMat) {
            case "shards":
                item = "Shadowmourne";
                break;
            case "fragments":
                item = "Valanyr";
                break;
            case "motes":
                item = "Dragonwrath";
                break;
        }

        System.out.println(item + " obtained!");

        keyMats.entrySet().stream().sorted((k1, k2) -> {
            int comparison = k2.getValue().compareTo(k1.getValue());
            if (comparison == 0) {
                comparison = k1.getKey().compareTo(k2.getKey());
            }
            return comparison;
        }).forEach(entry -> System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue())));

        junkMats.forEach((k, v) -> System.out.println(String.format("%s: %s", k, v)));
    }
}
