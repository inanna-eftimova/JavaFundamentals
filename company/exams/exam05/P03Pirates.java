package com.company.exams.exam05;

import javax.print.attribute.IntegerSyntax;
import java.util.*;
import java.util.stream.Collectors;

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<Integer>> map = new TreeMap<>();
        while (!input.equals("Sail")) {
            String[] text = input.split("\\|\\|");
            String townName= text[0];
            int population = Integer.parseInt(text[1]);
            int gold = Integer.parseInt(text[2]);
            if (!map.containsKey(townName)){
                List<Integer> list = new ArrayList<>();
                list.add(population);
                list.add(gold);
                map.put(townName,list);
            }else{
                List<Integer> list = map.get(townName);
                int p =list.get(0);
                p+=population;
                int g = list.get(1);
                g+=gold;
                list.set(0,p);
                list.set(1,g);
            }
            input = scanner.nextLine();
        }
        String newText = scanner.nextLine();
        while (!newText.equals("End")){
            String[] textNew = newText.split("=>");
            String type = textNew[0];
            switch (type){
                case "Plunder":
                    String town = textNew[1];
                    int people = Integer.parseInt(textNew[2]);
                    int gold = Integer.parseInt(textNew[3]);
                    List<Integer> list = map.get(town);
                    int person = list.get(0);
                    person-=people;
                    int golden = list.get(1);
                    golden-=gold;
                    if (person<=0 || golden<=0){
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",town,gold,people);
                        map.remove(town);
                        System.out.printf("%s has been wiped off the map!%n",town);
                    }else{
                        List<Integer> newList = new ArrayList<>();
                        newList.add(person);
                        newList.add(golden);
                        map.put(town,newList);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",town,gold,people);
                    }
                    break;
                case "Prosper":
                    String townTek = textNew[1];
                    int goldTek = Integer.parseInt(textNew[2]);
                    if (goldTek<=0){
                      System.out.println("Gold added cannot be a negative number!");
                    }else{
                        List<Integer> list1 = map.get(townTek);
                        int goldenTek = list1.get(1);
                        goldenTek+=goldTek;
                        list1.set(1,goldenTek);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",goldTek,townTek,goldenTek);
                    }
                    break;
            }
            newText = scanner.nextLine();
        }
        int size = map.size();
        if (size==0){
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }else{
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",size);
            Map<String, List<Integer>> sortedMap = map.entrySet().stream().sorted((a,b) -> b.getValue().get(1) - a.getValue().get(1)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
            for (Map.Entry<String,List<Integer>> print: sortedMap.entrySet()
                 ) {
                String name = print.getKey();
                List<Integer> list = print.getValue();
                int population = list.get(0);
                int gold = list.get(1);
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",name,population,gold);
            }
        }
    }
}


