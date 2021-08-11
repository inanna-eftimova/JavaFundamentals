package com.company.exams.exam04;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        String text = scanner.nextLine();
        while (!text.equals("Done")){
            String[] text1 = text.split(" ");
            String command = text1[0];
            switch (command){
                case "TakeOdd":
                    String newText = "";
                    for (int i = 0; i < input.length() ; i++) {
                        if (i%2!=0){
                            newText = newText + input.toString().charAt(i);
                        }
                    }
                    input = new StringBuilder(newText);
                    System.out.println(input.toString());
                    break;
                case "Cut":
                    int start = Integer.parseInt(text1[1]);
                    int period  = Integer.parseInt(text1[2]);
                    for (int i = start; i <period+start; i++) {
                        input.deleteCharAt(start);
                    }
                    System.out.println(input.toString());
                    break;
                case "Substitute":
                    String newText1 = "";
                    String substring = text1[1];
                    String substitute = text1[2];
                    if (input.toString().contains(substring)){
                        newText1 = input.toString().replace(substring,substitute);
                        input = new StringBuilder(newText1);
                        System.out.println(input.toString());
                    }else{
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            text = scanner.nextLine();
        }
        System.out.println("Your password is: " + input.toString());
    }
}
