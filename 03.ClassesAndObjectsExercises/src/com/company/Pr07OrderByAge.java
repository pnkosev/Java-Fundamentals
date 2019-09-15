package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr07OrderByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> listOfPersons = new ArrayList<>();

        String line;

        while (!(line = scanner.nextLine()).equals("End")) {
            String[] lineArray = line.split(" ");
            String name = lineArray[0];
            String id = lineArray[1];
            int age = Integer.parseInt(lineArray[2]);

            Person person = new Person(name, id, age);

            if (!listOfPersons.contains(person)) {
                listOfPersons.add(person);
            }
        }

        listOfPersons.sort((a, b) -> a.getAge() - b.getAge());

        for (Person person: listOfPersons) {
            String print = String.format("%s with ID: %s is %d years old.", person.getName(), person.getId(), person.getAge());
            System.out.println(print);
        }
    }
    static class Person {
        String name;
        String id;
        int age;

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
