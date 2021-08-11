package com.company.text.exercise;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split("\\\\");
        String[] input = text[text.length-1].split("\\.");
        System.out.println("File name: " + input[0]);
        System.out.println("File extension: " + input[1]);
    }
}
