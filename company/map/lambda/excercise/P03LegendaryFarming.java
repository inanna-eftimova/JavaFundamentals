package com.company.map.lambda.excercise;


import java.util.*;

public class P03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        Map<String, Integer> mapNum = new LinkedHashMap<>();
        Map<String, Integer> map = new TreeMap<>();
        boolean isFind = false;
        for (int i = 1; i < input.length; i += 2) {
            String text = input[i].toLowerCase(Locale.ROOT);
            if (text.equals("shards") || text.equals("fragments") || text.equals("motes")) {
                if (!mapNum.containsKey(text)) {
                    mapNum.put(text, Integer.parseInt(input[i - 1]));
                } else {
                    int tek = mapNum.get(text);
                    tek += Integer.parseInt(input[i - 1]);
                    mapNum.put(text, tek);
                }

            } else {
                if (!map.containsKey(text)) {
                    map.put(text, Integer.parseInt(input[i - 1]));
                } else {
                    int tek = map.get(text);
                    tek += Integer.parseInt(input[i - 1]);
                    map.put(text, tek);
                }
            }
            if (isFind){
                break;
            }
        }
    }
}
