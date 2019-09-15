package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pr05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listofNums = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] line = scanner.nextLine().split(" ");
        int specialBombNumber = Integer.parseInt(line[0]);
        int power = Integer.parseInt(line[1]);

        int initialLength = listofNums.size();

        while (listofNums.contains(specialBombNumber)) {
            int index = listofNums.indexOf(specialBombNumber);
            int startIndex = Math.max(index - power, 0);
            int endIndex = Math.min(index + power + 1, initialLength);

            for (int i = startIndex; i < endIndex--; i++) {
                listofNums.remove(i);
                i--;
            }
//            int iterations = endIndex - startIndex;
//
//            while (iterations-- > 0) {
//                listofNums.remove(startIndex);
//            }
        }

        int sum = 0;

        for (int num: listofNums) {
            sum += num;
        }

        System.out.println(sum);
    }
}
