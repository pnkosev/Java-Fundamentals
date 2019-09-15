package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pr08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String line;

        while (!(line = scanner.nextLine()).equals("3:1")) {
            String command = line.split(" ")[0];
            if (command.equals("merge")) {
                int startIndex = Math.max(0, Integer.parseInt(line.split(" ")[1]));
                int endIndex = Math.min(Integer.parseInt(line.split(" ")[2]) + 1, list.size());
                String sumOfStrings = "";
                for (int i = startIndex; i < endIndex--; i++) {
                    String removedString = list.remove(i);
                    sumOfStrings = sumOfStrings.concat(removedString);
                    i--;
                }
                if (!sumOfStrings.isEmpty()) {
                    list.add(startIndex, sumOfStrings);
                }
            } else {
                int index = Integer.parseInt(line.split(" ")[1]);
                int partition = Integer.parseInt(line.split(" ")[2]);

                String stringToDivide = list.remove(index);
                String[] stringsAfterDivision = new String[partition];

                int step = stringToDivide.length() / partition;
                if (stringToDivide.length() % partition == 0) {
                    int counter = 0;
                    for (int i = 0; i < stringToDivide.length(); i += step) {
                        String currentString = stringToDivide.substring(i, i + step);
                        stringsAfterDivision[counter] = currentString;
                        counter++;
                    }
                } else {
                    int rest = stringToDivide.length() % partition;
                    String stringToAddToLast = stringToDivide.substring(stringToDivide.length() - rest, stringToDivide.length());
                    stringToDivide = stringToDivide.substring(0, stringToDivide.length() - rest);
                    int counter = 0;
                    for (int i = 0; i < stringToDivide.length(); i += step) {
                        String currentString = stringToDivide.substring(i, i + step);
                        stringsAfterDivision[counter] = currentString;
                        counter++;
                    }
                    stringsAfterDivision[stringsAfterDivision.length - 1] = stringsAfterDivision[stringsAfterDivision.length - 1].concat(stringToAddToLast);
                }

                int counter = stringsAfterDivision.length - 1;
                for (int i = 0; i < stringsAfterDivision.length; i++) {
                    list.add(index, stringsAfterDivision[counter]);
                    counter--;
                }
            }
        }
        System.out.println(String.join(" ", list));
    }
}
