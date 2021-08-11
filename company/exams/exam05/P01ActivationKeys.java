package com.company.exams.exam05;

import java.util.Locale;
import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        String text = scanner.nextLine();
        while (!text.equals("Generate")) {
            String[] text1 = text.split(">>>");
            String type = text1[0];
            switch (type) {
                case "Contains":
                    String substring = text1[1];
                    if (input.toString().contains(substring)) {
                        System.out.printf("%s contains %s%n", input, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String command = text1[1];
                    int start = Integer.parseInt(text1[2]);
                    int end = Integer.parseInt(text1[3]);
                    int diff = end - start;
                    if (command.equals("Upper")) {
                        String name = input.substring(start, end).toUpperCase();
                        input.replace(start, end, name);
                    } else {
                        String name = input.substring(start, end).toLowerCase(Locale.ROOT);
                        input.replace(start, end, name);
                    }
                    System.out.println(input);
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt(text1[1]);
                    int endIndex = Integer.parseInt(text1[2]);
                    input.delete(startIndex, endIndex);
                    System.out.println(input);
                    break;
            }
            text = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + input);
    }
}
