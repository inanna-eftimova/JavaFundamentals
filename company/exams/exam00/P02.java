package com.company.exams.exam00;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "U\\$(?<username>[A-Z][a-z]{2,})U\\$P\\@\\$(?<password>[A-Za-z]{5,}[0-9]+)P\\@\\$";
        Pattern pattern = Pattern.compile(regex);
        int counter = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                counter++;
                System.out.println("Registration was successful");
                String username = matcher.group("username");
                String password = matcher.group("password");
                System.out.printf("Username: %s, Password: %s%n",username,password);
            }else{
                System.out.println("Invalid username or password");
            }
        }
        System.out.println("Successful registrations: " + counter);
    }
}
