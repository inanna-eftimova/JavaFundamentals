package com.company.exams.exam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<symbol>[\\=\\/])(?<destination>[A-Z][A-za-z]{2,})\\1";
        int travellPoints = 0;
        List<String> destinations = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String text = matcher.group("destination");
            destinations.add(text);
            travellPoints+=text.length();
        }
        String finalT = String.join(", ",destinations);
        System.out.printf("Destinations: %s%n",finalT );
        System.out.println("Travel Points: " + travellPoints);
    }
}