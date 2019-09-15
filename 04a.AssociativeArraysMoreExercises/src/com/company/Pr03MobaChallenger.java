package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Pr03MobaChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> playersPool = new LinkedHashMap<>();

        String line;
        while (!(line = scanner.nextLine()).equals("Season end")) {
            if (line.contains(" -> ")) {
                String[] input = line.split(" -> ");
                String player = input[0];
                String position = input[1];
                int skill = Integer.parseInt(input[2]);

                LinkedHashMap<String, Integer> currentPlayerStats = new LinkedHashMap<>();
                currentPlayerStats.put(position, skill);

                if (!playersPool.containsKey(player)) {
                    playersPool.put(player, currentPlayerStats);
                } else if (!playersPool.get(player).containsKey(position)) {
                    playersPool.get(player).put(position, skill);
                } else if (playersPool.get(player).containsKey(position) && playersPool.get(player).get(position) < skill) {
                    playersPool.get(player).put(position, skill);
                }
            } else {
                String[] input = line.split(" vs ");
                String playerOne = input[0];
                String playerTwo = input[1];

                int playerOneTotalSkill = playersPool.containsKey(playerOne) ? playersPool.get(playerOne).values().stream().mapToInt(i -> i).sum() : 0;
                int playerTwoTotalSkill = playersPool.containsKey(playerTwo) ? playersPool.get(playerTwo).values().stream().mapToInt(i -> i).sum() : 0;

                if (playerOneTotalSkill != 0 && playerTwoTotalSkill != 0 && playerOneTotalSkill != playerTwoTotalSkill) {
                    List<String> playerOnePositions = new ArrayList<>(playersPool.get(playerOne).keySet());
                    List<String> playerTwoPositions = new ArrayList<>(playersPool.get(playerTwo).keySet());

                    boolean isHappening = false;

                    for (String pos : playerTwoPositions) {
                        if (playerOnePositions.contains(pos)) {
                            isHappening = true;
                            break;
                        }
                    }

                    if (isHappening) {
                        if (playerOneTotalSkill > playerTwoTotalSkill) {
                            playersPool.remove(playerTwo);
                        } else {
                            playersPool.remove(playerOne);
                        }
                    }
                }


            }
        }

        playersPool
                .entrySet().stream()
                .sorted((e1, e2) -> {
                    int comparison = getSum(e2.getValue()) - getSum(e1.getValue());
                    if (comparison == 0) {
                        comparison = e1.getKey().compareTo(e2.getKey());
                    }
                    return comparison;
                })
                .forEach(e -> {
                    System.out.println(String.format("%s: %d skill", e.getKey(), getSum(e.getValue())));
                    e.getValue()
                            .entrySet().stream()
                            .sorted((e1, e2) -> {
                                int comparison = e2.getValue().compareTo(e1.getValue());
                                if (comparison == 0) {
                                    comparison = e1.getKey().compareTo(e2.getKey());
                                }
                                return comparison;
                            })
                            .forEach(v -> {
                                System.out.println(String.format("- %s <::> %d", v.getKey(), v.getValue()));
                            });
                });
    }

    public static int getSum(Map<String, Integer> entry) {
        return entry.values().stream().mapToInt(i -> i).sum();
    }
}
