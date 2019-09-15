package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Pr04Articles2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Article> listOfArticles = new ArrayList<>();

        int lineCount = Integer.parseInt(scanner.nextLine());

        while (lineCount-- > 0) {
            String[] line = scanner.nextLine().split(", ");
            String title = line[0];
            String content = line[1];
            String author = line[2];

            Article currentArticle = new Article(title, content, author);

            if (!listOfArticles.contains(currentArticle)) {
                listOfArticles.add(currentArticle);
            }
        }

        String parameter = scanner.nextLine();

        switch (parameter) {
            case "title":
                listOfArticles.sort(Comparator.comparing(a -> a.title));
                break;
            case "content":
                listOfArticles.sort(Comparator.comparing(a -> a.content));
                break;
            case "author":
                listOfArticles.sort(Comparator.comparing(a -> a.author));
                break;
        }

        for (Article article: listOfArticles) {
            System.out.println(article.toString());
        }
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

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }
}
