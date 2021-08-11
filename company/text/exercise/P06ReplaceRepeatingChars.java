package com.company.text.exercise;

import java.util.Scanner;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder output = new StringBuilder();
        output.append(text.charAt(0));
        for (int i = 1; i <text.length() ; i++) {
            if (text.charAt(i)!=text.charAt(i-1)){
                output.append(text.charAt(i));
            }
        }
        System.out.println(output.toString());
    }
}
