package com.company.regex.exsercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<name>[A-Z][a-z]+)%[^\\$\\%\\.\\|]*<(?<product>\\w+)>[^\\|\\$\\%\\.]*\\|(?<quality>[0-9]+)\\|[^\\|\\$\\%\\.]*(?<price>[1-9][0-9]*\\.?[0-9]*)\\$";
        String input = scanner.nextLine();
        double totalIncome = 0;
        while (!input.equals("end of shift")){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quality = Integer.parseInt(matcher.group("quality"));
                double price = Double.parseDouble(matcher.group("price"));
                double totalPrice = quality*price;
                totalIncome+=totalPrice;
                System.out.printf("%s: %s - %.2f%n",name,product,totalPrice);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f",totalIncome);
    }
}
