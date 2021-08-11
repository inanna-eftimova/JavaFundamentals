package com.company.map.lambda.excercise;

import java.util.*;
import java.util.stream.Collectors;

import  static java.util.Map.Entry.comparingByValue;

public class P07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> map =new LinkedHashMap<>();
        Map<String,Double> newMap = new LinkedHashMap<>();
        for (int i = 0; i < num ; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if (!map.containsKey(name)){
                List<Double> list = new ArrayList<>();
                list.add(grade);
                map.put(name,list);
            }else{
                List<Double> list = map.get(name);
                list.add(grade);
                map.put(name,list);
            }
        }
        for (Map.Entry<String,List<Double>> average: map.entrySet()
             ) {
            List<Double> list = average.getValue();
            double sum = 0;
            int counter = 0;
            for (int i = 0; i < list.size() ; i++) {
                sum+= list.get(i);
                counter++;
            }
            double averageSum = sum/counter;
            list.clear();
            list.add(averageSum);
            newMap.put(average.getKey(),averageSum);
        }
        Map<String,Double> finalMap = newMap.entrySet().stream().filter(x -> x.getValue() >=4.5).sorted(Collections.reverseOrder(comparingByValue())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (e1,e2) -> e2, LinkedHashMap::new));
        for (Map.Entry<String,Double> print: finalMap.entrySet()
             ) {
            String name = print.getKey();
            double draduate = print.getValue();
            System.out.printf("%s -> %.2f%n",name,draduate);
        }
    }
}
