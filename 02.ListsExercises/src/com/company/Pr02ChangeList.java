package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pr02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line;

        while (!(line = scanner.nextLine()).equals("end")) {
            String[] input = line.split("\\s+");
            String command = input[0];

            if (command.equals("Delete")) {
                int value = Integer.parseInt(input[1]);
                while (list.contains(value)) {
                    list.remove(Integer.valueOf(value));
                }
            } else {
                int value = Integer.parseInt(input[1]);
                int index = Integer.parseInt(input[2]);

                if (index < list.size()) {
                    list.add(index, value);
                }
            }
        }

        list.forEach(e -> System.out.print(e + " "));

        System.out.println();
    }
}
