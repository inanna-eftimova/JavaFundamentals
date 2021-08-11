package com.company.map.lambda.excercise;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> map = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] text = input.split(" -> ");
            if (!map.containsKey(text[0])){
                List<String> list = new ArrayList<>();
                list.add(text[1]);
                map.put(text[0],list);
            }else{
                List<String> list = map.get(text[0]);
                if (!list.contains(text[1])){
                    list.add(text[1]);
                }
                map.put(text[0],list);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String,List<String>> print: map.entrySet()
             ) {
            String name = print.getKey();
            System.out.println(name);
            List<String> list = print.getValue();
            for (int i = 0; i < list.size() ; i++) {
                System.out.println("-- " + list.get(i));
            }
        }
    }
}
