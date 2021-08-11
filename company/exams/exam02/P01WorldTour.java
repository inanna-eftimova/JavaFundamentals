package com.company.exams.exam02;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        String text = scanner.nextLine();
        while (!text.equals("Travel")){
            String[] text1 = text.split(":");
            String command = text1[0];
            switch (command){
                case "Add Stop":
                    int index = Integer.parseInt(text1[1]);
                    String string = text1[2];
                    int length = input.length();
                    if (length>index){
                        input.insert(index,string);
                    }
                    System.out.println(input);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(text1[1]);
                    int endIndex = Integer.parseInt(text1[2]);
                    int length1 = input.length();
                    if (endIndex<length1 && startIndex<=endIndex){
                        input.delete(startIndex,endIndex+1);
                    }
                    System.out.println(input);
                    break;
                case "Switch":
                    String oldString = text1[1];
                    String newString = text1[2];
                    if (input.toString().contains(oldString)){
                        String newText = input.toString().replaceAll(oldString,newString);
                        input = new StringBuilder(newText);
                    }
                    System.out.println(input);
                    break;
            }
            text = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + input);
    }
}
