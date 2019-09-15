package com.company;

import java.util.*;

public class Pr08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companies = new TreeMap<>();

        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
            String[] input = line.split(" -> ");
            String companyName = input[0];
            String employeeID = input[1];

            if (!companies.containsKey(companyName)) {
                companies.put(companyName, new ArrayList<>());
            }

            if (!companies.get(companyName).contains(employeeID)) {
                companies.get(companyName).add(employeeID);
            }
        }

        companies.forEach((k, v) -> {
            System.out.println(String.format("%s", k));
            v.forEach(e -> {
                System.out.println(String.format("-- %s", e));
            });
        });
    }
}
