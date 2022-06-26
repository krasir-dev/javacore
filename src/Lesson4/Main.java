package Lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //Задача 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        ArrayList<String> newArrayList = new ArrayList<>();
        newArrayList.add("love");
        newArrayList.add("the");
        newArrayList.add("life");
        newArrayList.add("you");
        newArrayList.add("live");
        newArrayList.add("and");
        newArrayList.add("live");
        newArrayList.add("the");
        newArrayList.add("life");
        newArrayList.add("you");
        newArrayList.add("love");

        System.out.println(newArrayList);

        //Задача 1. Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        HashSet<String> newSet = new HashSet<>();
        newSet.addAll(newArrayList);
        System.out.println(newSet);

        //Задача 1. Посчитать, сколько раз встречается каждое слово.

        HashMap<String, Integer> newHashMap = new HashMap<>();
        int count;

        for (String str : newSet) {
            count = 0;
            for (String arrList : newArrayList) {
                if (arrList.equals(str)) {
                    count++;
                }
            }
            newHashMap.put(str, count);

        }
        System.out.println(newHashMap);

        //Задача 2. Телефонный справочник

        Phonebook newPhonebook = new Phonebook();
        newPhonebook.add("9021760000", "Petrov");
        newPhonebook.add("9021760001", "Sidorov");
        newPhonebook.add("9021760002", "Petrov");
        newPhonebook.add("9021760003", "Ivanov");
        newPhonebook.get("Petrov");
    }
}
