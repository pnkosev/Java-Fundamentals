package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Pr08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = scanner.nextInt();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int currentNum = array[i];
                int nextNum = array[j];
                int currentSum = currentNum + nextNum;
                if (currentSum == sum) {
                    System.out.println(currentNum + " " + nextNum);
                }
            }
        }
    }
}
