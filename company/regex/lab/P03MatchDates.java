package com.company.regex.lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "\\b(?<data>[0-9]{2})(?<separator>[. \\/-])(?<month>[A-Z][a-z]{2})\\2(?<year>[0-9]{4})\\b";
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            String data = matcher.group("data");
            String mount = matcher.group("month");
            String year = matcher.group("year");
            System.out.printf("Day: %s, Month: %s, Year: %s%n",data,mount,year);
        }

    }
}
