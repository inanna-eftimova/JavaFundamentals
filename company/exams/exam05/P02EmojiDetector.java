package com.company.exams.exam05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<type>\\:{2}|\\*{2})[A-Z][a-z]{2,}\\1";
        String regexNum = "[0-9]";
        int counter = 0;
        Pattern pattern = Pattern.compile(regexNum);
        Matcher matcher = pattern.matcher(input);
        List<String> list = new ArrayList<>();
        int sum = 1;
        while (matcher.find()){
            sum*=Integer.parseInt(matcher.group());
        }
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);
        while (matcher.find()){
            String text1 = matcher.group();
            String text = text1;
            int sumPerText = 0;
            text = text.replace("::","");
            text = text.replace("**","");
            for (int i = 0; i < text.length() ; i++) {
                sumPerText+=(int) text.charAt(i);
            }
            if (sumPerText>=sum){
                list.add(text1);
            }else{
                counter++;
            }
        }
        System.out.printf("Cool threshold: %d%n",sum);
        counter+= list.size();
        System.out.printf("%d emojis found in the text. The cool ones are:%n",counter);
        list.forEach(e -> System.out.println(e));


    }
}
