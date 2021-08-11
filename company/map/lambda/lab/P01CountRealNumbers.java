package com.company.map.lambda.lab;

import java.util.*;
import java.util.stream.Collectors;

public class P01CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> num = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        Map<Double,Integer> numbers = new TreeMap<>();
        for (double number:num
             ) {
            if (!numbers.containsKey(number)){
                numbers.put(number,1);
                continue;
            }
            int counters = numbers.get(number);
            counters++;
            numbers.put(number,counters);
        }
        for (Map.Entry<Double,Integer> n:numbers.entrySet()
             ) {
            System.out.printf("%.0f -> %d%n",n.getKey(),n.getValue());
        }

    }
}
