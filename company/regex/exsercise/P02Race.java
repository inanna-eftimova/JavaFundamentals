package com.company.regex.exsercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String,Integer> map = new LinkedHashMap<>();
        String regexForText = "[A-Za-z]";
        String numRegex = "[0-9]";
        String nameOfPerson = "";
        for (int i = 0; i < input.size() ; i++) {
            map.put(input.get(i),0 );
        }
        String text = scanner.nextLine();
        while (!text.equals("end of race")){
            int sum = 0;
            nameOfPerson = "";
            Pattern pattern = Pattern.compile(regexForText);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()){
                nameOfPerson = nameOfPerson+matcher.group();
            }
            pattern = Pattern.compile(numRegex);
            matcher = pattern.matcher(text);
            while (matcher.find()){
                sum+=Integer.parseInt(matcher.group());
            }
            if (map.containsKey(nameOfPerson)){
                int tekSum = map.get(nameOfPerson);
                tekSum+=sum;
                map.put(nameOfPerson,tekSum);
            }
            text = scanner.nextLine();
        }
        Map<String,Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (a1,a2) -> a1, LinkedHashMap::new));
        List<String> first = new ArrayList<>();
        sortedMap.entrySet().forEach(entry->first.add(entry.getKey()));
        System.out.println("1st place: " + first.get(0));
        System.out.println("2nd place: " + first.get(1));
        System.out.println("3rd place: " + first.get(2));
    }
}
