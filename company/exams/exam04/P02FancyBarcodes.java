package com.company.exams.exam04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+";
        String numRegex = "[0-9]";
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            StringBuilder num = new StringBuilder();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                pattern = Pattern.compile(numRegex);
                matcher = pattern.matcher(text);
                if (matcher.find()) {
                    num.append(matcher.group());
                    while (matcher.find()){
                        num.append(matcher.group());
                    }
                } else {
                    num.append("00");
                }
                System.out.println("Product group: "+num);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
