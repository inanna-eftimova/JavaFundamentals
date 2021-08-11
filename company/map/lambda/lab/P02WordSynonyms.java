package com.company.map.lambda.lab;

import java.util.*;

public class P02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (int i = 0; i < num; i++) {
            String firstWod = scanner.nextLine();
            String secondWord = scanner.nextLine();
            if (!map.containsKey(firstWod)) {
                list = new ArrayList<>();
                list.add(secondWord);
                map.put(firstWod, list);
                continue;
            }
            list = map.get(firstWod);
            list.add(secondWord);
            map.put(firstWod, list);
        }
        for (Map.Entry<String, List<String>> wordEntry:map.entrySet()
             ) {
            String currentWord = wordEntry.getKey();
            List<String> synonim = wordEntry.getValue();
            System.out.printf("%s - %s%n",currentWord,String.join(", ", synonim));
        }

    }
}
