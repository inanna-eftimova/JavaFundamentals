package com.company.text.exercise;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arguments = scanner.nextLine().split(" ");
        String firstArgument = arguments[0];
        String secondArgument = arguments[1];
        int sum = 0;
        if (firstArgument.length()==secondArgument.length()){
            int length = firstArgument.length();
            for (int i = 0; i < length ; i++) {
                int one = firstArgument.charAt(i);
                int two = secondArgument.charAt(i);
                int multiply =one*two;
                sum+=multiply;
            }
        }else if (firstArgument.length()<secondArgument.length()){
            int length = firstArgument.length();
            for (int i = 0; i < length; i++) {
                int one = firstArgument.charAt(i);
                int two = secondArgument.charAt(i);
                int multiply =one*two;
                sum+=multiply;
            }
            int drop = secondArgument.length()-length;
            for (int i = secondArgument.length()-1; i >=secondArgument.length()-drop ; i--) {
                int argument = secondArgument.charAt(i);
                sum+=argument;
            }
        }else{
            int length = secondArgument.length();
            for (int i = 0; i < length; i++) {
                int one = firstArgument.charAt(i);
                int two = secondArgument.charAt(i);
                int multiply =one*two;
                sum+=multiply;
            }
            int drop = firstArgument.length()-length;
            for (int i = firstArgument.length()-1; i >=firstArgument.length()-drop ; i--) {
                int argument = firstArgument.charAt(i);
                sum+=argument;
            }
        }
        System.out.println(sum);
    }
}
