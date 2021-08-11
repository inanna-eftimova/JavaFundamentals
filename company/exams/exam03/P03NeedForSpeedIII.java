package com.company.exams.exam03;

import java.util.*;
import java.util.stream.Collectors;

import static  java.util.Map.Entry.comparingByKey;
import static  java.util.Map.Entry.comparingByValue;
public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,List<Integer>> map = new TreeMap<>();
        for (int i = 0; i <n ; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String name = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            List<Integer> list = new ArrayList<>();
            list.add(mileage);
            list.add(fuel);
            map.put(name,list);
        }
        String text = scanner.nextLine();
        while (!text.equals("Stop")) {
            String[] text1 = text.split(" : ");
            String command = text1[0];
            switch (command) {
                case "Drive":
                    String car = text1[1];
                    int distance = Integer.parseInt(text1[2]);
                    int fuel = Integer.parseInt(text1[3]);
                    List<Integer> list = map.get(car);
                    int fule = list.get(1);
                    if (fuel > fule) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        fule -= fuel;
                        list.set(1, fule);
                        int d = list.get(0);
                        d += distance;
                        list.set(0, d);
                        map.put(car, list);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                        if (d >= 100000) {
                            map.remove(car);
                            System.out.printf("Time to sell the %s!%n", car);
                        }
                    }
                    break;
                case "Refuel":
                    String car1 = text1[1];
                    int flu = Integer.parseInt(text1[2]);
                    List<Integer> list1 = map.get(car1);
                    int fluu = list1.get(1);
                    if (flu+fluu>75){
                        int diff = 75-fluu;
                        flu+=diff;
                        list1.set(1,75);
                        map.put(car1,list1);
                        System.out.printf("%s refueled with %d liters%n",car1,diff);
                    }else{
                        fluu+=flu;
                        list1.set(1,fluu);
                        map.put(car1,list1);
                        System.out.printf("%s refueled with %d liters%n",car1,flu);
                    }
                    break;
                case "Revert":
                    String car2 = text1[1];
                    int kilometers = Integer.parseInt(text1[2]);
                    List<Integer> list2 = map.get(car2);
                    int m = list2.get(0);
                    if (m-kilometers<10000){
                        m=10000;
                    }else{
                        m-=kilometers;
                        System.out.printf("%s mileage decreased by %d kilometers%n",car2,kilometers);
                    }
                    list2.set(0,m);
                    map.put(car2,list2);
                    break;
            }
            text = scanner.nextLine();
        }
//        Map<String,List<Integer>> sortedNames = map.entrySet().stream().sorted(comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)-> e2,TreeMap::new));
        Map<String, List<Integer>> sortedMap = map.entrySet().stream().sorted((a,b) -> b.getValue().get(0) - a.getValue().get(0)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        for (Map.Entry<String,List<Integer>> print:sortedMap.entrySet()
             ) {
            String name = print.getKey();
            List<Integer> list = print.getValue();
            int mil = list.get(0);
            int flue = list.get(1);
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",name,mil,flue);
        }
    }
}
