package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Pr06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        if (array.length == 1) {
            System.out.println("0");
            return;
        }

        int leftSum = array[0];
        int rightSum = array[array.length - 1];
        int currentLeftIndex = 0;
        int currentRightIndex = array.length - 1;

        for (int i = 1; i < array.length; i++) {
            if (leftSum > rightSum) {
                rightSum += array[currentRightIndex - 1];
                currentRightIndex--;
            } else if (rightSum > leftSum) {
                leftSum += array[currentLeftIndex + 1];
                currentLeftIndex++;
            }

            if (leftSum == rightSum) {
                System.out.println((currentLeftIndex + currentRightIndex) / 2);
                return;
            }
        }

        System.out.println("no");

//        boolean isSumEqual = false;
//        int indexOfBalance = -1;
//
//        for (int i = 0; i < array.length; i++) {
//            int leftSum = 0;
//            int rightSum = 0;
//            for (int j = 1 + i; j < array.length; j++) {
//                rightSum += array[j];
//            }
//            for (int k = 0; k < i; k++) {
//                leftSum += array[k];
//            }
//
//            if (leftSum == rightSum) {
//                isSumEqual = true;
//                indexOfBalance = i;
//                break;
//            }
//        }
//
//        if (isSumEqual) {
//            System.out.println(indexOfBalance);
//        } else {
//            System.out.println("no");
//        }
    }
}

