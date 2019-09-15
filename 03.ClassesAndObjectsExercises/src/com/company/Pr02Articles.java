package com.company;

import java.util.Scanner;

public class Pr02Articles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int commandCount = Integer.parseInt(scanner.nextLine());

        Article article = new Article(input[0], input[1], input[2]);

        while (commandCount-- > 0) {
            String[] line = scanner.nextLine().split(": +");
            String command = line[0];
            String text = line[1];

            switch (command) {
                case "Edit":
                    article.editContent(text);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(text);
                    break;
                case "Rename":
                    article.renameTitle(text);
                    break;
            }
        }
        System.out.println(article.toString());
    }

    static class Article {
        private String title;
        private String content;
        private String author;
        Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        private void editContent(String newContent) {
            this.content = newContent;
        }

        private void changeAuthor(String newAuthor) {
            this.author = newAuthor;
        }

        private void renameTitle(String newTitle) {
            this.title = newTitle;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }
}
