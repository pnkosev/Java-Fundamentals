package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Pr05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            boolean isBigger = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (number <= arr[j]) {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
}
