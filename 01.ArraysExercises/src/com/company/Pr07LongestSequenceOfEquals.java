package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Pr07LongestSequenceOfEquals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int index = 0;
        int biggestLength = 1;
        int currentLength = 1;

        for (int i = 0; i < array.length - 1; i++) {
            int currentNum = array[i];
            int nextNum = array[i + 1];

            if (currentNum == nextNum) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            if (currentLength > biggestLength) {
                biggestLength = currentLength;
                index = i;
            }
        }

        int start = index + 2 - biggestLength;
        int end = start + biggestLength;

        for (int i = start; i < end; i++) {
            System.out.print(array[i] + " ");
        }

//        for (int i = 0; i < array.length - 1; i++) {
//            int currentNum = array[i];
//            int nextNum = array[i + 1];
//
//            if (currentNum == nextNum) {
//                currentLength++;
//
//                if (currentLength == 2) {
//                    currentIndex = i;
//                }
//                if (currentLength > biggestLength) {
//                    biggestLength = currentLength;
//                    startIndex = currentIndex;
//                }
//            } else {
//                currentLength = 1;
//            }
//        }
//
//        for (int i = startIndex; i < startIndex + biggestLength; i++) {
//            System.out.print(array[i] + " ");
//        }

        System.out.println();

        // 2 1 1 2 3 3 2 2 2 1
    }
}
