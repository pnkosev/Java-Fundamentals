package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pr03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>();

        while (numberOfCommands-- > 0) {
            String[] line = scanner.nextLine().split(" ");
            String name = line[0];
            boolean isGoing = line[2].equals("going!");

            if (!isGoing) {
                boolean isInTheGuestList = guests.contains(name);
                if (!isInTheGuestList) {
                    System.out.println(name + " is not in the list!" );
                    continue;
                }
                guests.remove(name);
                continue;
            }
            if (!guests.contains(name)) {
                guests.add(name);
                continue;
            }
            System.out.println(name + " is already in the list!" );
        }

        guests.forEach(System.out::println);
    }
}
