package com.company.map.lambda.lab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String text1 = scanner.nextLine();
        String[] text = text1.split(word);
        for (String wod:text
             ) {
            System.out.println(wod);
        }

    }
}
