package com.company.text.lab;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String[] text1 = scanner.nextLine().split(word);
        String text = String.join("", text1);
        text = text.replace(word,"");
        System.out.println(text);

    }
}
