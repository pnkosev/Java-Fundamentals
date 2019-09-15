package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Pr09KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        String line = scanner.nextLine();

        int[] bestDNA = new int[length];
        int bestSequence = 0;
        int leftMostIndex = length - 1;
        int bestDNABatch = 1;

        int currentDNA = 1;

        while (!line.equals("Clone them!")) {
            int[] dnaSequence = Arrays
                    .stream(line.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int currentBestSequence = 0;

            for (int i = 0; i < length; i++) {
                int currentNum = dnaSequence[i];

                if (currentNum == 1) {
                    currentBestSequence++;

                    if (currentBestSequence > bestSequence) {
                        bestSequence = currentBestSequence;
                        leftMostIndex = i - (bestSequence - 1);
                        bestDNA = Arrays.copyOf(dnaSequence, length);
                        bestDNABatch = currentDNA;
                    } else if (currentBestSequence == bestSequence) {
                        if (i - (currentBestSequence - 1) < leftMostIndex) {
                            bestSequence = currentBestSequence;
                            leftMostIndex = i - (currentBestSequence - 1);
                            bestDNA = Arrays.copyOf(dnaSequence, length);
                            bestDNABatch = currentDNA;
                        } else if (i - (currentBestSequence - 1) == leftMostIndex && bestDNABatch != currentDNA) {
                            int currentDNAOnes = getOnes(dnaSequence);
                            int bestDNAOnes = getOnes(bestDNA);

                            if (currentDNAOnes > bestDNAOnes) {
                                bestSequence = currentBestSequence;
                                leftMostIndex = i - (currentBestSequence - 1);
                                bestDNA = Arrays.copyOf(dnaSequence, length);
                                bestDNABatch = currentDNA;
                            }
                        }
                    }
                } else {
                    currentBestSequence = 0;
                }
            }
            currentDNA++;
            line = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.", bestDNABatch, getOnes(bestDNA));
        System.out.println();
        for (int number : bestDNA) {
            System.out.printf("%d ", number);
        }
        System.out.println();
    }

    public static int getOnes(int[] array) {
        int count = 0;
        for (int el: array) {
            if (el == 1) {
                count++;
            }
        }
        return count;
    }
}
