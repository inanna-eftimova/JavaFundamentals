package com.company.map.lambda.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> num = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).sorted((n1,n2) -> n2.compareTo(n1)).collect(Collectors.toList());
        int lenght = num.size();
        int counter = 0;
        if (lenght<3){
            for (Integer number:num
                 ) {
                System.out.print(number + " ");
            }
        }else{
            for (Integer number:num
                 ) {
                counter++;
                if (counter>3){
                    break;
                }
                System.out.print(number + " ");
            }
        }
    }
}
