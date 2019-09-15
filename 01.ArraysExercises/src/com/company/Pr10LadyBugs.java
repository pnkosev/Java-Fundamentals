package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Pr10LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int length = Integer.parseInt(scanner.nextLine());

        int[] array = new int[length];

        int[] ladyBugsIndexes = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < ladyBugsIndexes.length; i++) {
            int currentPos = ladyBugsIndexes[i];
            if (0 <= currentPos && currentPos < array.length) {
                array[currentPos] = 1;
            }
        }

        String line;

        while (!(line = scanner.nextLine()).equals("end")) {
            String[] command = line.split(" ");
            int index = Integer.parseInt(command[0]);
            String direction = command[1];
            int flyRange = Integer.parseInt(command[2]);

            if (0 <= index && index < array.length && array[index] == 1) {
                array[index] = 0;
                int currentFlyRange = flyRange;
                if (direction.equals("left")) {
                    while (index - currentFlyRange >= 0 && index - currentFlyRange < array.length) {
                        if (array[index - currentFlyRange] == 0) {
                            array[index - currentFlyRange] = 1;
                            break;
                        }
                        currentFlyRange += flyRange;
                    }
                } else {
                    while (index + currentFlyRange < array.length && index + currentFlyRange >= 0) {
                        if (array[index + currentFlyRange] == 0) {
                            array[index + currentFlyRange] = 1;
                            break;
                        }
                        currentFlyRange += flyRange;
                    }
                }
                //array = fly(array, direction, target, flyRange);
            }
        }

        for (int element: array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

//    public static int[] fly(int[] arr, String dir, int target, int step) {
//        boolean isLandedOrGone = false;
//        int currentStep = 0;
//
//        while (!isLandedOrGone) {
//            if (dir.equals("left") && target - currentStep >= 0) {
//                if (arr[target - currentStep] == 0) {
//                    arr[target - currentStep] = 1;
//                    isLandedOrGone = true;
//                } else {
//                    currentStep += step;
//                }
//            } else if (dir.equals("left") && target - currentStep < 0) {
//                isLandedOrGone = true;
//            } else if (dir.equals("right") && target + currentStep < arr.length) {
//                if (arr[target + currentStep] == 0) {
//                    arr[target + currentStep] = 1;
//                    isLandedOrGone = true;
//                } else {
//                    currentStep += step;
//                }
//            } else if (dir.equals("right") && target + currentStep >= arr.length) {
//                isLandedOrGone = true;
//            }
//        }
//        return Arrays.copyOf(arr, arr.length);
//    }
}
