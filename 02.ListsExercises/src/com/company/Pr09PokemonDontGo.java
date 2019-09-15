package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pr09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfPokemons = Arrays
                .stream(scanner.nextLine().split(" +"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sumOfPokemons = 0;

        while (listOfPokemons.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            int pokemonToSumUp;

            if (index < 0) {
                index = 0;
                int lastNumToCopy = listOfPokemons.get(listOfPokemons.size() - 1);
                pokemonToSumUp = listOfPokemons.remove(index);
                sumOfPokemons += pokemonToSumUp;
                listOfPokemons.add(index, lastNumToCopy);
            } else if (index >= listOfPokemons.size()) {
                index = listOfPokemons.size() - 1;
                int firstNumToCopy = listOfPokemons.get(0);
                pokemonToSumUp = listOfPokemons.remove(index);
                sumOfPokemons += pokemonToSumUp;
                listOfPokemons.add(firstNumToCopy);
            } else {
                pokemonToSumUp = listOfPokemons.remove(index);
                sumOfPokemons += pokemonToSumUp;
            }

            for (int i = 0; i < listOfPokemons.size(); i++) {
                int pokemon = listOfPokemons.get(i);
                if (pokemon <= pokemonToSumUp) {
                    pokemon += pokemonToSumUp;
                    listOfPokemons.set(i, pokemon);
                } else {
                    pokemon -= pokemonToSumUp;
                    listOfPokemons.set(i, pokemon);
                }
            }
        }

        System.out.println(sumOfPokemons);
    }
}
