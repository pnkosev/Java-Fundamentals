package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Pr04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();

        int rotations = scanner.nextInt();

        rotations = rotations % arr.length;

        for (int i = 0; i < rotations; i++) {
            int firstNum = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = firstNum;
        }

        for (int number: arr) {
            System.out.printf("%d ", number);
        }

        System.out.println();
    }
}


