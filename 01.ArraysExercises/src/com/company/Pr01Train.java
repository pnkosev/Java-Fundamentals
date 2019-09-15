package com.company;

import java.util.Scanner;

public class Pr01Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] train = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int passengers = scanner.nextInt();
            train[i] = passengers;
            sum += passengers;
        }

        for (int wagon : train) {
            System.out.printf("%d ", wagon);
        }
        System.out.println();
        System.out.println(sum);
    }
}
