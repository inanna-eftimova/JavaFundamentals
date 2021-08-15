package com.company.exams.exam01;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<symbol>[\\#\\|])(?<productName>[A-Za-z ]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>[0-9]{1,4})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> items = new ArrayList<>();
        int calculatorCalories = 0;
        while (matcher.find()){
            calculatorCalories += Integer.parseInt(matcher.group("calories"));
            String productName = matcher.group("productName");
            String date = matcher.group("date");
            String calories = matcher.group("calories");
            items.add(String.format("Item: %s, Best before: %s, Nutrition: %s",productName, date, calories));
        }
        int days = calculatorCalories/2000;
        System.out.printf("You have food to last you for: %d days!%n",days);
        for (int i = 0; i <items.size() ; i++) {
            System.out.println(items.get(i));
        }
    }
}
