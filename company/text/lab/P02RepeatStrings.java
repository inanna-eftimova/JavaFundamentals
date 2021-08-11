package com.company.text.lab;

import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split(" ");
        for (int i = 0; i < text.length ; i++) {
            String[] text1 = text[i].split("");
            int size = text1.length;
            for (int j = 0; j < size ; j++) {
                System.out.print(text[i]);
            }
        }
    }
}
