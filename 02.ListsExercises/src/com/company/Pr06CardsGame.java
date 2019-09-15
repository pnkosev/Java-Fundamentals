package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pr06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> playerOne = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> playerTwo = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (playerOne.size() > 0 && playerTwo.size() > 0) {
            int playerOneCard = playerOne.get(0);
            int playerTwoCard = playerTwo.get(0);

            if (playerOneCard == playerTwoCard) {
                playerOne.remove(0);
                playerTwo.remove(0);
            } else if (playerOneCard > playerTwoCard) {
                int cardOfLooser = playerTwo.remove(0);
                int cardOfWinner = playerOne.remove(0);
                playerOne.add(cardOfWinner);
                playerOne.add(cardOfLooser);
            } else {
                int cardOfLooser = playerOne.remove(0);
                int cardOfWinner = playerTwo.remove(0);
                playerTwo.add(cardOfWinner);
                playerTwo.add(cardOfLooser);
            }
        }

        int sum = 0;
        if (playerOne.size() == 0) {
            for (int num: playerTwo) {
                sum += num;
            }
            System.out.println("Second player wins! Sum: " + sum);
        } else {
            for (int num: playerOne) {
                sum += num;
            }
            System.out.println("First player wins! Sum: " + sum);
        }
    }
}
