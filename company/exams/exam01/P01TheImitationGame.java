package com.company.exams.exam01;

import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder encrypredMessage = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Decode")) {
            String[] text = input.split("\\|");
            String command = text[0];
            switch (command) {
                case "Move":
                    int index = Integer.parseInt(text[1]);
                    for (int i = 0; i < index; i++) {
                        String chara = String.valueOf(encrypredMessage.charAt(0));
                        encrypredMessage.delete(0, 1);
                        encrypredMessage.append(chara);
                    }
                    break;
                case "Insert":
                    int indexx = Integer.parseInt(text[1]);
                    String value = text[2];
                    encrypredMessage.insert(indexx,value);
                    break;
                case "ChangeAll":
                    String substring = text[1];
                    String replacment = text[2];
                    String text1 = encrypredMessage.toString().replace(substring,replacment);
                    encrypredMessage = new StringBuilder(text1);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + encrypredMessage);
    }
}
