package com.company.text.exercise;

import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int modul = 0;
        String[] text2 = text.split("");
        for (int i = 0; i < text2.length ; i++) {
            if (text2[i].equals(">")){
                int num = Integer.parseInt(text2[i+1]);
                for (int j = 0; j < num+modul ; j++) {
                    if (text2[i+1+j].equals(">")){
                        modul+=num-j;
                        break;
                    }else {
                        text2[i +1 + j] = "";
                    }
                }
            }
        }
        for (String n:text2
             ) {
            if (!n.equals("")) {
                System.out.print(n);
            }
        }
    }
}
