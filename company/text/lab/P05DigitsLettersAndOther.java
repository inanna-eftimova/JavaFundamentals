package com.company.text.lab;

import java.util.Scanner;

public class P05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder letter = new StringBuilder();
        StringBuilder digit = new StringBuilder();
        StringBuilder characher = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char one = text.charAt(i);
            if (Character.isLetter(one)){
                letter.append(one);
            }else if (Character.isDigit(one)){
                digit.append(one);
            }else{
                characher.append(one);
            }
        }
        System.out.println(digit);
        System.out.println(letter);
        System.out.println(characher);
    }
}
