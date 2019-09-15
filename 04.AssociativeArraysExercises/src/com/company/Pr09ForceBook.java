package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Pr09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> forceBook = new LinkedHashMap<>();

        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("lumpawaroo")) {
            if (line.split(" \\| ").length == 2) {
                String[] input = line.split(" \\| ");
                String forceSide = input[0];
                String forceUser = input[1];
                boolean isExisting = false;

                for (Map.Entry<String, List<String>> entry: forceBook.entrySet()) {
                    if (entry.getValue().contains(forceUser)) {
                        isExisting = true;
                    }
                }

                if (!forceBook.containsKey(forceSide)) {
                    forceBook.put(forceSide, new ArrayList<>());
                }

                if (!isExisting) {
                    forceBook.get(forceSide).add(forceUser);
                }
            } else {
                String[] input = line.split(" -> ");
                String forceUser = input[0];
                String forceSide = input[1];

                for (Map.Entry<String, List<String>> entry : forceBook.entrySet().stream().filter(e -> !e.getKey().equals(forceSide)).collect(Collectors.toList())) {
                    for (String user : entry.getValue()) {
                        if (user.equals(forceUser)) {
                            entry.getValue().remove(user);
                            break;
                        }
                    }
                }

                if (!forceBook.containsKey(forceSide)) {
                    forceBook.put(forceSide, new ArrayList<>());
                }
                forceBook.get(forceSide).add(forceUser);
                System.out.println(String.format("%s joins the %s side!", forceUser, forceSide));
            }
        }

        forceBook
                .entrySet().stream()
                .filter(e -> e.getValue().size() > 0)
                .sorted((e1, e2) -> {
                    int comparison = e2.getValue().size() - e1.getValue().size();
                    if (comparison == 0) {
                        comparison = e1.getKey().compareTo(e2.getKey());
                    }
                    return comparison;
                })
                .forEach(e -> {
                    System.out.println(String.format("Side: %s, Members: %d", e.getKey(), e.getValue().size()));
                    e.getValue()
                            .stream().sorted(String::compareTo)
                            .forEach(u -> {
                        System.out.println(String.format("! %s", u));
                    });
                });
    }
}
