package com.company.map.lambda.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        List<String> newWords = new ArrayList<>();
        for (int i = 0; i < words.length ; i++) {
            String currentWord = words[i];
            if (currentWord.length()%2==0){
                newWords.add(currentWord);
            }
        }
        for (String word:newWords
             ) {
            System.out.println(word);
        }
    }
}
