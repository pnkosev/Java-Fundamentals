package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Pr07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays
                .stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        Collections.reverse(list);
        String toPrint = list.toString().replaceAll("[]\\[,]", "").trim();

        System.out.println(String.join(" ", toPrint.split(" +")));
    }
}
