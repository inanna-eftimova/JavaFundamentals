package com.company.text.exercise;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] password = scanner.nextLine().split(", ");
        for (int i = 0; i < password.length ; i++) {
            String tekPassword = password[i];
            if (tekPassword.length()>=3 && tekPassword.length()<=16){
                for (int j = 0; j <tekPassword.length() ; j++) {
                    char symbol = tekPassword.charAt(j);
                    if (Character.isLetterOrDigit(symbol) || tekPassword.contains("-")|| tekPassword.contains("_")){
                        if (j==tekPassword.length()-1){
                            System.out.println(tekPassword);
                        }
                    }else{
                        break;
                    }
                }

            }
        }
    }
}
