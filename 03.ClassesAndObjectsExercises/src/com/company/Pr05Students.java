package com.company;

import java.util.*;

public class Pr05Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> listOfStudents = new ArrayList<>();

        int lineCount = Integer.parseInt(scanner.nextLine());

        while (lineCount-- > 0) {
            String[] line = scanner.nextLine().split(" ");
            String firstName = line[0];
            String lastName = line[1];
            float grade = Float.parseFloat(line[2]);

            Student currentStudent = new Student(firstName, lastName, grade);

            if (!listOfStudents.contains(currentStudent)) {
                listOfStudents.add(currentStudent);
            }
        }

        listOfStudents.sort(Comparator.comparing(Student::getGrade));
        Collections.reverse(listOfStudents);

        for (Student student: listOfStudents) {
            System.out.printf("%s %s: %.2f", student.firstName, student.lastName, student.grade);
            System.out.println();
        }
    }

    static class Student {
        String firstName;
        String lastName;
        float grade;
        public Student(String firstName, String lastName, float grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public float getGrade() {
            return grade;
        }
    }
}
