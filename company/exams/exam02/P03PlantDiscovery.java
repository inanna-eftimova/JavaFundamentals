package com.company.exams.exam02;

import java.util.*;
import java.util.stream.Collectors;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("<->");
            List<Double> list = new ArrayList<>();
            list.add(Double.parseDouble(input[1]));
            String text = scanner.nextLine();
            while (!text.equals("Exhibition")){
                String[] text1 = text.split(" ");
                String command = text1[0];
                switch (command){
                    case "Rate:":
                        String rateName = text1[1];
                        double rateRating = Double.parseDouble(text1[3]);
                        List<Double> rateList = map.get(rateName);
                        rateList.add(rateRating);
                        map.put(rateName,rateList);
                        break;
                    case "Update:":
                        String updateName = text1[1];
                        double newRarity = Double.parseDouble(text1[3]);
                        List<Double> updateList = map.get(updateName);
                        updateList.set(0,newRarity);
                        map.put(updateName,updateList);
                        break;
                    case "Reset:":
                        String removeName = text1[1];
                        List<Double> resetList = map.get(removeName);
                        for (int j = 1; j <resetList.size() ; j++) {
                            resetList.remove(1);
                        }
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
                text = scanner.nextLine();
            }
        }
        for (Map.Entry<String,List<Double>> sorted: map.entrySet()
             ) {
            int counter = 0;
            int sum = 0;
            List<Double> list = sorted.getValue();
            for (int i = 1; i < list.size() ; i++) {
                sum+= list.get(1);
                counter++;
                list.remove(1);
            }
            double average = 1.00*sum/counter;
            list.add(1,average);
        }
        Map<String, List<Double>> sortedMap = map.entrySet().stream().sorted((a,b) -> b.getValue().stream().mapToDouble(Double::doubleValue). - (Double)a.getValue().get(1)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

    }
}
