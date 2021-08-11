package com.company.text.lab;

import java.util.Scanner;

public class P01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        while (!text.equals("end")){
            String[] text1 = text.split("");
            String reverseWord = "";
            for (int i = text.length()-1; i >=0 ; i--) {
                reverseWord+=text.charAt(i);
            }
            System.out.println(text + " = " + reverseWord);
            text = scanner.nextLine();
        }
    }
}
