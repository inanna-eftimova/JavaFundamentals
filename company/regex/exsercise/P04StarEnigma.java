package com.company.regex.exsercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();
        List<String> planetA = new ArrayList<>();
        List<String> planetD = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int counter = 0;
            String text = scanner.nextLine();
            String newText = "";
            String[] text1 = text.split("");
            for (int j = 0; j <text1.length ; j++) {
                if (text1[j].equals("s")||text1[j].equals("S")||text1[j].equals("t")||text1[j].equals("T")||
                        text1[j].equals("a")||text1[j].equals("A")||text1[j].equals("r")||text1[j].equals("R")){
                    counter++;
                }
            }
            for (int j = 0; j < text1.length ; j++) {
                char character = text.charAt(j);
                int ascii = (int) character;
                ascii-=counter;
                newText = newText + (char) ascii;
            }
            list.add(newText);
        }
        String regex = "[^@\\-!:>]*@(?<planetName>[A-Za-z]+)[^@\\-!:>]*:(?<population>[0-9]+)[^@\\-!:>]*!(?<type>[AD])![^@\\-!:>]*->(?<soldier>[0-9]+)[^@\\-!:>]*";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < list.size(); i++) {
            String textText = list.get(i);
            Matcher matcher = pattern.matcher(textText);
            if (matcher.find()){
                String planetName = matcher.group("planetName");
                String population = matcher.group("population");
                String attact = matcher.group("type");
                String solder = matcher.group("soldier");
                if (attact.equals("A")){
                    planetA.add(planetName);
                }else{
                    planetD.add(planetName);
                }
            }
        }
        planetA.sort(Comparator.naturalOrder());
        planetD.sort(Comparator.naturalOrder());
        int sizeA = planetA.size();
        int sizeD = planetD.size();

        System.out.println("Attacked planets: " + sizeA);
        if (sizeA>0){
            for (int i = 0; i <planetA.size() ; i++) {
                System.out.println("-> " + planetA.get(i));
            }
        }
        System.out.println("Destroyed planets: " + sizeD);
        if (sizeD>0){
            for (int i = 0; i <planetD.size() ; i++) {
                System.out.println("-> " + planetD.get(i));
            }
        }
    }
}

