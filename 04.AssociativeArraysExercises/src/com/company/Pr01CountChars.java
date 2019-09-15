package com.company;

import java.util.*;

public class Pr01CountChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> map = new LinkedHashMap<>();

        String text = scanner.nextLine().replaceAll(" +", "");

        for (int i = 0; i < text.length(); i++) {
            char currChar = text.charAt(i);
            if (!map.containsKey(currChar)) {
                map.put(currChar, 0);
            }
            int count = map.get(currChar);
            map.put(currChar, count + 1);
        }

        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
