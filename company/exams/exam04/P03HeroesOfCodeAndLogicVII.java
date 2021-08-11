package com.company.exams.exam04;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import  static  java.util.Map.Entry.comparingByKey;
public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i <n ; i++) {
            String[] input = scanner.nextLine().split(" ");
            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(input[1]));
            list.add(Integer.parseInt(input[2]));
            map.put(input[0],list);
        }
        String text = scanner.nextLine();
        while (!text.equals("End")){
            String[] text1 = text.split(" - ");
            String command = text1[0];
            switch (command){
                case "CastSpell":
                String heroName = text1[1];
                List<Integer> list = map.get(heroName);
                int mPoints = list.get(1);
                if (mPoints>=Integer.parseInt(text1[2])){
                    int diff = mPoints - Integer.parseInt(text1[2]);
                    list.remove(1);
                    list.add(diff);
                    map.put(heroName,list);
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n",heroName,text1[3],diff);
                }else{
                    System.out.printf("%s does not have enough MP to cast %s!%n",heroName,text1[3]);
                }
                    break;
                case "TakeDamage":
                    String hero = text1[1];
                    int damage = Integer.parseInt(text1[2]);
                    String attacker = text1[3];
                    List<Integer> list1 = map.get(hero);
                    int damageList = list1.get(0);
                    damageList-=damage;
                    if (damageList>0){
                        list1.remove(0);
                        list1.add(0,damageList);
                        map.put(hero,list1);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",hero,damage,attacker,damageList);
                    }else{
                        map.remove(hero);
                        System.out.printf("%s has been killed by %s!%n",hero,attacker);
                    }
                    break;
                case "Recharge":
                    String name = text1[1];
                    int amount = Integer.parseInt(text1[2]);
                    List<Integer> list2 = map.get(name);
                    int mp = list2.get(1);
                    if (mp+amount<=200){
                        mp+=amount;
                        list2.remove(1);
                        list2.add(mp);
                        map.put(name,list2);
                        System.out.printf("%s recharged for %d MP!%n",name,amount);
                    }else{
                        amount = 200-mp;
                        list2.set(1,200);
                        map.put(name,list2);
                        System.out.printf("%s recharged for %d MP!%n",name,amount);
                    }
                    break;
                case "Heal":
                    String nameHero = text1[1];
                    int almout = Integer.parseInt(text1[2]);
                    List<Integer> list3 = map.get(nameHero);
                    int hp = list3.get(0);
                    if (hp+almout<=100){
                        hp+=almout;
                        list3.set(0,hp);
                        map.put(nameHero,list3);
                        System.out.printf("%s healed for %d HP!%n",nameHero,almout);
                    }else{
                        almout = 100-hp;
                        list3.set(0,100);
                        map.put(nameHero,list3);
                        System.out.printf("%s healed for %d HP!%n",nameHero,almout);
                    }
                    break;
            }
            text = scanner.nextLine();
        }
        Map<String,List<Integer>> sortedNames = map.entrySet().stream().sorted(Collections.reverseOrder(comparingByKey())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) -> e2,TreeMap::new));
        Map<String,List<Integer>> sorted = sortedNames.entrySet().stream().sorted((a,b) -> b.getValue().get(0) - a.getValue().get(0)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        for (Map.Entry<String,List<Integer>> print:sorted.entrySet()
             ) {
            String name = print.getKey();
            List<Integer> list = print.getValue();
            int ho = list.get(0);
            int mo = list.get(1);
            System.out.println(name);
            System.out.println("  HP: " + ho);
            System.out.println("  MP: " + mo);
        }

    }
}
