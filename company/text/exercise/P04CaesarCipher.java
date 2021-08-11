package com.company.text.exercise;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length() ; i++) {
            int firstChar = input.charAt(i);
            firstChar+=3;
            output.append((char) firstChar);
        }
        System.out.println(output);
    }
}
