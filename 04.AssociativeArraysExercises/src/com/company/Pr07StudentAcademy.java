package com.company;

import java.util.*;

public class Pr07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> students = new LinkedHashMap<>();

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        while (numberOfStudents-- > 0) {
            String name = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }
            students.get(name).add(grade);
        }

        students
                .entrySet().stream()
                .filter(entry -> getAverageAsDouble(entry.getValue()) >= 4.50)
                .sorted((s1, s2) -> getAverageAsDouble(s2.getValue()).compareTo(getAverageAsDouble(s1.getValue())))
                .forEach(entry -> {
                    System.out.println(String.format("%s -> %.2f", entry.getKey(), getAverageAsDouble(entry.getValue())));
                });

    }
    public static Double getAverageAsDouble(List<Double> grades) {
        return grades.stream().mapToDouble(v -> v).average().getAsDouble();
    }
}
