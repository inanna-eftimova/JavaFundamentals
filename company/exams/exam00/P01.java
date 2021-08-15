package com.company.exams.exam00;

import javax.print.DocFlavor;
import java.util.Locale;
import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        String text = scanner.nextLine();
        while (!text.equals("Done")) {
            String[] text1 = text.split(" ");
            String command = text1[0];
            switch (command) {
                case "Change":
                    String tek = text1[1];
                    String replacement = text1[2];
                    String text2 = input.toString().replace(tek, replacement);
                    input = new StringBuilder(text2);
                    System.out.println(input);
                    break;
                case "Includes":
                    String otherString = text1[1];
                    if (input.toString().contains(otherString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String stringOther = text1[1];
                    int size = stringOther.length();
                    String newText = "";
                    String input1 = input.toString();
                    int counter = 0;
                    for (int i = input1.length()-1; i > 0; i--) {
                        counter++;
                        if (counter>size){
                            break;
                        }
                        char a = input1.charAt(i);
                        newText = newText + a;
                    }
                    StringBuilder newStringBuilder = new StringBuilder(newText);
                    newStringBuilder.reverse();
                    if (stringOther.equals(newStringBuilder.toString())){
                        System.out.println("True");
                    }else{
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    String text3 = input.toString().toUpperCase(Locale.ROOT);
                    input = new StringBuilder(text3);
                    System.out.println(input);
                    break;
                case "FindIndex":
                    String charIndex = text1[1];
                    for (int i = 0; i <input.toString().length() ; i++) {
                        char tekText = input.toString().charAt(i);
                        String text4 = String.valueOf(tekText);
                        if (charIndex.equals(text4)){
                            System.out.println(i);
                            break;
                        }
                    }
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(text1[1]);
                    int length = Integer.parseInt(text1[2]);
                    String text5 = "";
                    for (int i = startIndex; i <startIndex+length ; i++) {
                        text5 = text5 + input.toString().charAt(i);
                    }
                    input = new StringBuilder(text5);
                    System.out.println(input);
                    break;
            }
            text = scanner.nextLine();
        }

    }
}
