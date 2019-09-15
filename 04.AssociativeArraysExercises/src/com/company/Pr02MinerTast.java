package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr02MinerTast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String line;
        while (!(line = scanner.nextLine()).equals("stop")) {
            String resource = line;
            int amount = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(resource)) {
                resources.put(resource, amount);
            } else {
                resources.put(resource, resources.get(resource) + amount);
            }
        }

        // resources.forEach((k, v) -> System.out.println(k + " -> " + v));

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.println(String.format("%s -> %d", entry.getKey(), entry.getValue()));
        }

    }
}
