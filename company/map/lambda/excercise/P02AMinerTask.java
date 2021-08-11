package com.company.map.lambda.excercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<String, Integer> map = new LinkedHashMap<>();
        while (!text.equals("stop")) {
            int quality = Integer.parseInt(scanner.nextLine());
            if (!map.containsKey(text)) {
                map.put(text, quality);
                }else{
                int quality1 = map.get(text);
                quality1+=quality;
                map.put(text,quality1);
                }
                text = scanner.nextLine();
            }
        for (Map.Entry<String,Integer> num:map.entrySet()
             ) {
            System.out.printf("%s -> %d%n",num.getKey(),num.getValue());
        }
        }
    }

