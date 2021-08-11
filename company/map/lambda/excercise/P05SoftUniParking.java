package com.company.map.lambda.excercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String name = input[1];
            switch (command) {
                case "register":
                    String number = input[2];
                    if (map.containsKey(name)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", number);
                    } else {
                        map.put(name,number);
                        System.out.printf("%s registered %s successfully%n", name, number);
                    }
                    break;
                case "unregister":
                    if (!map.containsKey(name)) {
                        System.out.printf("ERROR: user %s not found%n", name);
                    }else{
                        map.remove(name);
                        System.out.printf("%s unregistered successfully%n", name);
                    }
                    break;
            }
        }
        for (Map.Entry<String,String> names: map.entrySet()
             ) {
           String name = names.getKey();
           String num = names.getValue();
            System.out.println(name +" => " + num);
        }
    }
}
