package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pr06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courseList = new LinkedHashMap<>();

        String line;

        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
            String[] input = line.split(" : ");
            String course = input[0];
            String student = input[1];

            if (!courseList.containsKey(course)) {
                courseList.put(course, new ArrayList<>());
            }

            if (!courseList.get(course).contains(student)) {
                courseList.get(course).add(student);
            }
        }

        courseList.entrySet().stream()
                .sorted((k1, k2) -> k2.getValue().size() - k1.getValue().size())
                .forEach(entry -> {
                    System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue().size()));
                    entry.getValue().stream().sorted(String::compareTo).forEach(v -> System.out.println(String.format("-- %s", v)));
                });
    }
}
