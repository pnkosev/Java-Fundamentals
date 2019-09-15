package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, double[]> productList = new LinkedHashMap<>();

        String line;

        while (!(line = scanner.nextLine()).equals("buy")) {
            String[] order = line.split(" ");
            String product = order[0];
            double price = Double.parseDouble(order[1]);
            double quantity = Double.parseDouble(order[2]);

            if (!productList.containsKey(product)) {
                productList.put(product, new double[2]);
            }

            double[] currentValues = productList.get(product);
            currentValues[0] = price;
            currentValues[1] += quantity;
        }

        productList.forEach((k, v) -> System.out.println(String.format("%s -> %.2f", k, v[0] * v[1])));
    }
}
