package com.company.map.lambda.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toLowerCase(Locale.ROOT);
        String[] text1 = text.split(" ");
        int counter = 0;
        List<String> newText = new ArrayList<>();
        for (int i = 0; i < text1.length ; i++) {
            String currentWord = text1[i];
            for (int j = 0; j < text1.length ; j++) {
                String word = text1[j];
                if (currentWord.equals(word)){
                    counter++;
                }
            }
            if (counter%2!=0 && !newText.contains(currentWord)){
                newText.add(currentWord);
            }
            counter=0;
        }
        System.out.println(String.join(", ", newText));
    }
}
