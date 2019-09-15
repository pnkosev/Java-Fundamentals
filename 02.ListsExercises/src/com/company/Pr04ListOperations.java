package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pr04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfNums = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line;

        while(!(line = scanner.nextLine()).equals("End")) {
            String command = line.split(" ")[0];

            if (command.equals("Add")) {
                int number = Integer.parseInt(line.split(" ")[1]);

                listOfNums.add(number);
            } else if (command.equals("Remove")) {
                int index = Integer.parseInt(line.split(" ")[1]);
                if (index < 0 || index >= listOfNums.size()) {
                    System.out.println("Invalid index");
                    continue;
                }
                listOfNums.remove(index);
            } else if (command.equals("Insert")) {
                int number = Integer.parseInt(line.split(" ")[1]);
                int index = Integer.parseInt(line.split(" ")[2]);
                if (index < 0 || index >= listOfNums.size()) {
                    System.out.println("Invalid index");
                    continue;
                }
                listOfNums.add(index, number);
            } else if (command.equals("Shift")) {
                String direction = line.split(" ")[1];
                int count = Integer.parseInt(line.split(" ")[2]);
                if (direction.equals("left")) {
                    while (count-- > 0) {
                        int firstNum = listOfNums.remove(0);
                        listOfNums.add(firstNum);
                    }
                } else {
                    while (count-- > 0) {
                        int lastNum = listOfNums.remove(listOfNums.size() - 1);
                        listOfNums.add(0, lastNum);
                    }
                }
            }
        }

        listOfNums.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
