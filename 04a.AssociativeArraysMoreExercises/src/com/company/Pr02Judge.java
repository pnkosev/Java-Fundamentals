package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr02Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();
        Map<String, Integer> users = new LinkedHashMap<>();

        String line;
        while (!(line = scanner.nextLine()).equals("no more time")) {
            String[] input = line.split(" -> ");
            String user = input[0];
            String contest = input[1];
            int points = Integer.parseInt(input[2]);

            Map<String, Integer> currUserPerformance = new HashMap<>();
            currUserPerformance.put(user, points);

            if (!contests.containsKey(contest)) {
                contests.put(contest, currUserPerformance);
                if (!users.containsKey(user)) {
                    users.put(user, 0);
                }
                users.put(user, users.get(user) + points);
            } else {
                if (!contests.get(contest).containsKey(user)) {
                    contests.get(contest).put(user, points);
                    if (!users.containsKey(user)) {
                        users.put(user, 0);
                    }
                    users.put(user, users.get(user) + points);
                }
                if (contests.get(contest).get(user) < points) {
                    contests.get(contest).put(user, points);
                    users.put(user, points);
                }
            }
        }

        int[] count = new int[1];
        contests
                .forEach((k, v) -> {
                    System.out.println(String.format("%s: %d participants", k, v.size()));
                    count[0] = 0;
                    v.entrySet().stream()
                            .sorted((e1, e2) -> {
                                int comparison = e2.getValue().compareTo(e1.getValue());
                                if (comparison == 0) {
                                    comparison = e1.getKey().compareTo(e2.getKey());
                                }
                                return comparison;
                            })
                            .forEach(e -> {
                                System.out.println(String.format("%d. %s <::> %s", ++count[0], e.getKey(), e.getValue()));
                            });
                });

        System.out.println("Individual standings:");
        count[0] = 0;

        users
                .entrySet().stream()
                .sorted((e1, e2) -> {
                    int comparison = e2.getValue().compareTo(e1.getValue());
                    if (comparison == 0) {
                        comparison = e1.getKey().compareTo(e2.getKey());
                    }
                    return comparison;
                })
                .forEach(e -> {
                    System.out.println(String.format("%d. %s -> %d", ++count[0], e.getKey(), e.getValue()));
                });
    }
}
