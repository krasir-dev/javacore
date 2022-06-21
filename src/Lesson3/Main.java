package Lesson3;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        String[] stringArray = {"123", "second_element", "new", "last"};


        printArray(stringArray);
        //Задача 1. Метод, который меняет два элемента массива местами
        ChangePosition<String> strChange = new ChangePosition<>();
        printArray(strChange.getChangePosition(stringArray,0,3));

        Apple apple = new Apple();
        Orange orange = new Orange();

        Box<Apple> boxWithApples = new Box<>(15, apple);
        Box<Orange> boxWithOranges = new Box<>(40, orange);
        Box<Apple> boxWithApples1 = new Box<>(0, apple);

        //Задача 2. Метод, который высчитывает вес коробки
        System.out.println(boxWithOranges.getWeightBox());
        System.out.println(boxWithApples.getWeightBox());

        //Задача 2. Метод, который сравнивает коробки по весу
        System.out.println(boxWithOranges.compare(boxWithApples));

        //Задача 2. Метод, который пересыпает коробки
        boxWithApples1.peresipat(boxWithApples);





    }
    public static void printArray (String[] array){
        for (int i=0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(" ");
    }
}
