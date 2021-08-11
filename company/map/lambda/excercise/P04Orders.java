package com.company.map.lambda.excercise;


import java.sql.Array;
import java.util.*;

public class P04Orders {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     String input = scanner.nextLine();
     Map<String, List<Double>> map = new LinkedHashMap<>();
     while (!input.equals("buy")){
         String[] text = input.split(" ");
         if (!map.containsKey(text[0])){
             List<Double> newL = new ArrayList<>();
             newL.add(Double.parseDouble(text[1]));
             newL.add(Double.parseDouble(text[2]));
             map.put(text[0],newL);
         }else{
             List<Double> newL = map.get(text[0]);
             newL.remove(0);
             newL.add(0,Double.parseDouble(text[1]));
             double sum = newL.get(1);
             sum+=Double.parseDouble(text[2]);
             newL.remove(1);
             newL.add(1,sum);
             map.put(text[0],newL);
         }
         input = scanner.nextLine();
     }
        for (Map.Entry<String,List<Double>> name:map.entrySet()
             ) {
            List<Double> list = name.getValue();
            String product = name.getKey();
            double price = list.get(0);
            double quality = list.get(1);
            double sum = price*quality;
            System.out.printf("%s -> %.2f%n",product,sum);
        }
    }
}
