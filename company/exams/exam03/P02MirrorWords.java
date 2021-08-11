package com.company.exams.exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<symbol>[\\@\\#])[A-Za-z]{3,}\\1\\1[A-Za-z]{3,}\\1";
        List<String> mirrorWords = new ArrayList<>();
        List<String> mirrorWords1 = new ArrayList<>();
        int counter = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            counter++;
            String[] text = matcher.group().split("[\\#\\@]+");
            StringBuilder firstWord = new StringBuilder(text[1]);
            StringBuilder secondWord = new StringBuilder(text[2]);
            if (firstWord.toString().equals(secondWord.reverse().toString())){
                mirrorWords.add(firstWord.toString());
                mirrorWords1.add(text[2]);
            }
        }
        if (counter==0){
            System.out.println("No word pairs found!");
        }else{
            System.out.printf("%s word pairs found!%n",counter);
        }
        if (mirrorWords.size()==0){
            System.out.println("No mirror words!");
        }else{
            System.out.println("The mirror words are:");
            for (int i = 0; i < mirrorWords.size() ; i++) {
                if (i!= mirrorWords.size()-1){
                    System.out.print(mirrorWords.get(i) + " <=> " + mirrorWords1.get(i) + ", ");
                }else{
                    System.out.print(mirrorWords.get(i) + " <=> " + mirrorWords1.get(i));
                }
            }
        }
    }
}
