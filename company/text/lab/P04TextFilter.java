package com.company.text.lab;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        String newText = "";
        for (int i = 0; i < words.length ; i++) {
            int length = words[i].length();
            String starWord = "";
            for (int j = 0; j < length; j++) {
                starWord = starWord + "*";
            }
            text = text.replace(words[i],starWord);
        }
        newText += text;
        System.out.println(newText);

    }
}
