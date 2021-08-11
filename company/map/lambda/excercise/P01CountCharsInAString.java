package com.company.map.lambda.excercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character,Integer> map = new LinkedHashMap<>();
//        int textSize = text.length();
        for (int i = 0; i < text.length() ; i++) {
            char symbol = text.charAt(i);
            if (symbol == ' '){
                continue;
            }
            if (!map.containsKey(symbol)){
                map.put(symbol,1);
            }else{
                int num = map.get(symbol);
                num++;
                map.put(symbol,num);
            }
        }
        for (Map.Entry<Character,Integer> number:map.entrySet()
             ) {
            System.out.printf("%c -> %d%n",number.getKey(),number.getValue());
        }
    }
}
