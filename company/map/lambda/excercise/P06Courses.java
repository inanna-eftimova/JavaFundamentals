package com.company.map.lambda.excercise;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> map = new LinkedHashMap<>();
        while (!input.equals("end")) {
            String[] text = input.split(" : ");
            String courseName = text[0];
            String person = text[1];
            if (!map.containsKey(courseName)) {
                List<String> list = new ArrayList<>();
                list.add(person);
                map.put(courseName, list);
            } else {
                List<String> list = map.get(courseName);
                list.add(person);
                map.put(courseName, list);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> sorted : map.entrySet()
        ) {
            List<String> list = map.get(sorted.getKey());
            List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
            map.put(sorted.getKey(), sortedList);
        }
        Map<String, List<String>> sortedMap = map.entrySet().stream().sorted((a,b) -> b.getValue().size() - a.getValue().size()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        for (Map.Entry<String, List<String>> print:sortedMap.entrySet()
             ) {
            String name = print.getKey();
            int size = print.getValue().size();
            List<String> list = print.getValue();
            System.out.println(name + ": " + size);
            for (int i = 0; i < list.size() ; i++) {
                System.out.println("-- " + list.get(i));
            }
        }
    }
}