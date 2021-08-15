package com.company.exams.exam00;

import java.util.*;

public class P03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" \\| ");
        Map<String, List<String>> map = new TreeMap<>();
        for (int i = 0; i < input.length ; i++) {
            String[] text = input[i].split(": ");
            String name = text[0];
            String definition = text[1];
            if (!map.containsKey(name)){
                List<String> list = new ArrayList<>();
                list.add(definition);
                map.put(name,list);
            }else{
                List<String> list = map.get(name);
                list.add(definition);
                map.put(name,list);
            }
        }
        String[] text1 = scanner.nextLine().split(" \\| ");
        String command = scanner.nextLine();
        switch (command){
            case "Test":
                for (int i = 0; i < text1.length ; i++) {
                    if (map.containsKey(text1[i])){
                        List<String> list = map.get(text1[i]);
                        list.sort(Comparator.comparingInt(String::length).reversed());
                        System.out.println(text1[i] + ":");
                        for (String element:list
                             ) {
                            System.out.println("-" + element);
                        }
                    }
                }
                break;
            case "Hand Over":
                List<String> list = new ArrayList<>();
                for (Map.Entry<String,List<String>> print: map.entrySet()
                     ) {
                    list.add(print.getKey());
                }
                list.stream().forEach(e -> System.out.print(e + " "));
                break;
        }
    }
}
