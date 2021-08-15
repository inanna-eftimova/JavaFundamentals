package com.company.exams.exam01;

import java.util.*;
import java.util.stream.Collectors;
import  static  java.util.Map.Entry.comparingByValue;
public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,List<String>> map = new TreeMap<>();
        for (int i = 0; i <n ; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String key = input[2];
            List<String> list = new ArrayList<>();
            list.add(composer);
            list.add(key);
            map.put(piece,list);
        }
        String text = scanner.nextLine();
        while (!text.equals("Stop")){
            String[] text1 = text.split("\\|");
            String command = text1[0];
            switch (command){
                case "Add":
                    String piece = text1[1];
                    String composer = text1[2];
                    String key = text1[3];
                    if (!map.containsKey(piece)) {
                        List<String> list = new ArrayList<>();
                        list.add(composer);
                        list.add(key);
                        map.put(piece, list);
                        System.out.printf("%s by %s in %s added to the collection!%n",piece,composer,key);
                    }else{
                        System.out.printf("%s is already in the collection!%n",piece);
                    }
                    break;
                case "Remove":
                    String piece1 = text1[1];
                    if (map.containsKey(piece1)) {
                        map.remove(piece1);
                        System.out.printf("Successfully removed %s%n!",piece1);
                    }else{
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece1);
                    }
                    break;
                case "ChangeKey":
                    String piece2 = text1[1];
                    String newKey = text1[2];
                    if (map.containsKey(piece2)){
                        List<String> list = map.get(piece2);
                        list.set(1,newKey);
                        System.out.printf("Changed the key of %s to %s!%n",piece2,newKey);
                    }else{
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece2);
                    }
                    break;
            }
            text = scanner.nextLine();
        }
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(kvp -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1)));
    }
}
