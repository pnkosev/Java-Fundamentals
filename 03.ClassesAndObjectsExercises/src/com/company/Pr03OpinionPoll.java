package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Pr03OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> listOfStudents = new ArrayList<>();

        int lineCount = Integer.parseInt(scanner.nextLine());

        while (lineCount-- > 0) {
            String[] line = scanner.nextLine().split(" ");
            String name = line[0];
            int age = Integer.parseInt(line[1]);
            Student currentStudent = new Student(name, age);
            if (!listOfStudents.contains(currentStudent)) {
                listOfStudents.add(currentStudent);
            }
        }

        listOfStudents.sort(Comparator.comparing(a -> a.name));
        for (Student student: listOfStudents) {
            if (student.age > 30) {
                String print = String.format("%s - %d", student.name, student.age);
                System.out.println(print);
            }
        }
    }
    static class Student {
        String name;
        int age;
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
