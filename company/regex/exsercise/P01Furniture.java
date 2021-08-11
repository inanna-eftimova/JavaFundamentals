package com.company.regex.exsercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = ">>(?<name>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quality>[0-9]+)\\b";
        String text = scanner.nextLine();
        double sum = 0;
        List<String> things = new ArrayList<>();
        while (!text.equals("Purchase")){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()){
                String name = matcher.group("name");
                things.add(name);
                double price = Double.parseDouble(matcher.group("price"));
                int quality = Integer.parseInt(matcher.group("quality"));
                sum+=price*quality;
            }
            text = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        things.forEach(name -> System.out.println(name));
        System.out.printf("Total money spend: %.2f",sum);
    }
}
