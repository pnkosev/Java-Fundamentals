package com.company;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> peopleResults = new LinkedHashMap<>();
        Map<String, Integer> submissions = new LinkedHashMap<>();

        String line;

        while (!(line = scanner.nextLine()).equalsIgnoreCase("exam finished")) {
            String[] input = line.split("-");
            String user = input[0];

            if (input.length == 3) {
                String language = input[1];
                int points = Integer.parseInt(input[2]);

                if (!peopleResults.containsKey(user) || peopleResults.get(user) < points) {
                    peopleResults.put(user, points);
                }

                if (!submissions.containsKey(language)) {
                    submissions.put(language, 0);
                }

                submissions.put(language, submissions.get(language) + 1);
            } else if (input.length == 2) {
                peopleResults.remove(user);
            }
        }

        System.out.println("Results:");
        peopleResults
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                    .reversed()
                    .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> {
                    System.out.println(String.format("%s | %d", e.getKey(), e.getValue()));
                });
        System.out.println("Submissions:");
        submissions
                .entrySet().stream()
                .sorted((e1, e2) -> {
                    int comparison = e2.getValue().compareTo(e1.getValue());
                    if (comparison == 0) {
                        comparison = e1.getKey().compareTo(e2.getKey());
                    }
                    return comparison;
                })
                .forEach(e -> {
                    System.out.println(String.format("%s - %d", e.getKey(), e.getValue()));
                });
    }
}
