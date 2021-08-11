package com.company.text.exercise;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            String[] text = input[i].split("");
            String letterOne = text[0];
            char one = letterOne.charAt(0);
            String letterTwo = text[text.length - 1];
            char two = letterTwo.charAt(0);
            String num = "";
            for (int j = 1; j < text.length - 1; j++) {
                num = num + text[j];
            }
            double number = Double.parseDouble(num);
            if (Character.isUpperCase(one)) {
                int position = (int) one - 64;
                number /= position;
            }else{
                int position = (int) one - 96;
                number*=position;
            }
            if (Character.isUpperCase(two)){
                int position = (int) two -64;
                number-=position;
            }else{
                int position = (int) two -96;
                number+=position;
            }
            sum+=number;
        }
        System.out.printf("%.2f",sum);
    }
}
