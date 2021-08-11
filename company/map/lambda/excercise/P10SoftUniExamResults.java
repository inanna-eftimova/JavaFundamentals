package com.company.map.lambda.excercise;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String,Integer> map = new TreeMap<>();
        Map<String,Integer> map1 = new TreeMap<>();
        while (!input.equals("exam finished")){
            String[] text = input.split("-");
            String username = text[0];
            String language = text[1];
            int points = 0;
            if (!language.equals("banned")) {
                points = Integer.parseInt(text[2]);
                if (map.containsKey(username)) {
                    if (map.get(username)<points){
                        map.put(username, points);
                    }
                }else{
                    map.put(username, points);

                }
            }
            if (!language.equals("banned")){
                if (!map1.containsKey(language)) {
                    map1.put(language,1);
                }else {
                    int num = map1.get(language);
                    num++;
                    map1.put(language, num);
                }
            }else{
                map.remove(username);
            }
            input = scanner.nextLine();
        }
       Map<String,Integer> sorted =  map.entrySet().stream().sorted(Collections.reverseOrder(comparingByValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("Results:");
        for (Map.Entry<String,Integer> print: sorted.entrySet()
             ) {
            System.out.printf("%s | %d%n",print.getKey(),print.getValue());
        }
        Map<String,Integer> sorted1 =  map1.entrySet().stream().sorted(Collections.reverseOrder(comparingByValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("Submissions:");
        for (Map.Entry<String,Integer> print: sorted1.entrySet()
        ) {
            System.out.printf("%s - %d%n",print.getKey(),print.getValue());
        }
    }
}
