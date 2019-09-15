package com.company;

import java.util.*;

public class Pr01Ranking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contestWithPasswords = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        String line;

        while (!(line = scanner.nextLine()).equalsIgnoreCase("end of contests")) {
            String[] input = line.split(":");
            String contest = input[0];
            String password = input[1];

            if (!contestWithPasswords.containsKey(contest)) {
                contestWithPasswords.put(contest, password);
            }
        }

        while (!(line = scanner.nextLine()).equalsIgnoreCase("end of submissions")) {
            String[] input = line.split("=>");
            String contest = input[0];
            String password = input[1];
            String user = input[2];
            int points = Integer.parseInt(input[3]);

            if (contestWithPasswords.containsKey(contest) && contestWithPasswords.get(contest).equals(password)) {
                LinkedHashMap<String, Integer> course = new LinkedHashMap<>();
                course.put(contest, points);

                if (!users.containsKey(user)) {
                    users.put(user, course);
                } else {
                    if (!users.get(user).containsKey(contest) || users.get(user).get(contest) < points) {
                        users.get(user).put(contest, points);
                    }
                }
            }
        }

        users
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().values().stream().mapToInt(i -> i).sum() - e1.getValue().values().stream().mapToInt(i -> i).sum())
                .limit(1)
                .forEach(e -> {
                    System.out.println(
                            String.format(
                                    "Best candidate is %s with total %d points.",
                                    e.getKey(), e.getValue().values().stream().mapToInt(i -> i).sum()));
                });

        System.out.println("Ranking:");

        users
                .forEach((key, value) -> {
                    System.out.println(key);
                    value
                            .entrySet().stream()
                            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            .forEach(v -> {
                                System.out.println(String.format("#  %s -> %s", v.getKey(), v.getValue()));
                            });
                });
    }
}