package com.company.exams.exam03;

import java.util.Scanner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        String text = scanner.nextLine();
        while (!text.equals("Reveal")){
            String[] text1 = text.split(":\\|:");
            String command = text1[0];
            switch (command){
                case "InsertSpace":
                    int index = Integer.parseInt(text1[1]);
                    input.insert(index," ");
                    System.out.println(input);
                    break;
                case "Reverse":
                    String substring = text1[1];
                    if (input.toString().contains(substring)){
                        StringBuilder reverced = new StringBuilder(substring);
                        StringBuilder reverce = reverced.reverse();
                        String text2 = input.toString().replaceFirst(substring,"");
                        String newText =  text2 + reverce.toString();
                       input = new StringBuilder(newText);
                        System.out.println(input);
                    }else{
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String start = text1[1];
                    String end = text1[2];
                    String TextTek = input.toString().replace(start,end);
                    input = new StringBuilder(TextTek);
                    System.out.println(input);
                    break;

            }
            text  = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + input);
    }
}
