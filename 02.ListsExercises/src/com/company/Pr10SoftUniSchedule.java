package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pr10SoftUniSchedule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String line;

        while (!(line = scanner.nextLine()).equals("course start")) {
            String command = line.split(":")[0];
            String lessonTitle = line.split(":")[1];

            if (command.equals("Add") && !schedule.contains(lessonTitle)) {
                schedule.add(lessonTitle);
            } else if (command.equals("Insert") && !schedule.contains(lessonTitle)) {
                int index = Integer.parseInt(line.split(":")[2]);
                if (0 <= index && index < schedule.size()) {
                    schedule.add(index, lessonTitle);
                }
            } else if (command.equals("Remove") && schedule.contains(lessonTitle)) {
                schedule.remove(lessonTitle);
                String lessonExercise = lessonTitle + "-Exercise";
                schedule.remove(lessonExercise);
            } else if (command.equals("Swap")) {
                String lessonTitle2 = line.split(":")[2];
                if (schedule.contains(lessonTitle) && schedule.contains(lessonTitle2)) {
                    int firstLessonIndex = schedule.indexOf(lessonTitle);
                    int secondLessonIndex = schedule.indexOf(lessonTitle2);

                    schedule.add(secondLessonIndex, lessonTitle);
                    schedule.remove(lessonTitle2);
                    schedule.remove(firstLessonIndex);
                    schedule.add(firstLessonIndex, lessonTitle2);

                    String firstLessonExercise = lessonTitle + "-Exercise";
                    String secondLessonExercise = lessonTitle2 + "-Exercise";

                    if (schedule.contains(firstLessonExercise)) {
                        schedule.remove(firstLessonExercise);
                        int newFirstLessonIndex = schedule.indexOf(lessonTitle);
                        if (newFirstLessonIndex == schedule.size() - 1) {
                            schedule.add(firstLessonExercise);
                        } else {
                            schedule.add(newFirstLessonIndex + 1, firstLessonExercise);
                        }
                    }

                    if (schedule.contains(secondLessonExercise)) {
                        schedule.remove(secondLessonExercise);
                        int newSecondLessonIndex = schedule.indexOf(lessonTitle2);
                        if (newSecondLessonIndex == schedule.size() - 1) {
                            schedule.add(secondLessonExercise);
                        } else {
                            schedule.add(newSecondLessonIndex + 1, secondLessonExercise);
                        }
                    }
                }
            } else if (command.equals("Exercise")) {
                String exercise = lessonTitle + "-Exercise";
                if (schedule.contains(lessonTitle)) {
                    int lessonIndex = schedule.indexOf(lessonTitle);
                    if (lessonIndex == schedule.size() - 1) {
                        schedule.add(exercise);
                    } else {
                        if (!schedule.get(lessonIndex + 1).equals(exercise)) {
                            schedule.add(lessonIndex + 1, exercise);
                        }
                    }
                } else {
                    schedule.add(lessonTitle);
                    schedule.add(exercise);
                }
            }
        }

        for (int i = 0; i < schedule.size(); i++) {
            System.out.println(i + 1 + "." + schedule.get(i));
        }
    }
}
