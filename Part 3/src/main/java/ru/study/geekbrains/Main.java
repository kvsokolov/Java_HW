package ru.study.geekbrains;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        1. Создать новый список, добавить несколько строк и вывести коллекцию на экран.
        System.out.println("1. Создать новый список, добавить несколько строк и вывести коллекцию на экран.");
        ArrayList al1 = new ArrayList();
        al1.add("This");
        al1.add("is");
        al1.add("an");
        al1.add("ArrayList");
        al1.add("!");
        System.out.println(al1);

//        2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.
        System.out.println("2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.");
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Orange");
        colors.add("Yellow");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Indigo");
        colors.add("Violet");

        Iterator<String> iterator = colors.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            str += "!";
            System.out.println(str);
        }

//        3. Вставить элемент в список в первой позиции.
        System.out.println("3. Вставить элемент в список в первой позиции.");

        colors.add(0, "CYAN");

//        4. Извлечь элемент (по указанному индексу) из заданного списка.
        System.out.println("4. Извлечь элемент (по указанному индексу) из заданного списка.");

        System.out.println(colors.get(0));

//        5. Обновить определенный элемент списка по заданному индексу.
        System.out.println("5. Обновить определенный элемент списка по заданному индексу.");

        System.out.println(colors.set(1, "Updated Red"));

//        6. Удалить третий элемент из списка.
        System.out.println("6. Удалить третий элемент из списка.");

        System.out.println(colors.remove(2));

//        7. Поиска элемента в списке по строке.
        System.out.println("7. Поиска элемента в списке по строке.");

        System.out.println(colors);
        String isRainbowColor = "red";
        colors.remove(0);
        colors.add(1, "Orange");
        colors.set(0, "Red");


        iterator = colors.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.toLowerCase().contains(isRainbowColor.toLowerCase())) {
                System.out.printf("%s is a rainbow color\n", isRainbowColor.toLowerCase());
            }
        }

//        8. Создать новый список и добавить в него несколько елементов первого списка.
        System.out.println("8. Создать новый список и добавить в него несколько елементов первого списка.");

        ArrayList<String> newColors = new ArrayList<>();
        newColors.add(colors.get(3));
        newColors.add(colors.get(0));
        newColors.add(colors.get(6));
        newColors.add(colors.get(2));
        System.out.println(newColors);

//        9. Удалить из первого списка все элементы отсутствующие во втором списке.
        System.out.println("9. Удалить из первого списка все элементы отсутствующие во втором списке.");

//        colors.retainAll(newColors);
//        System.out.println(colors);

//        10. Сортировка списка.
        System.out.println("10. Сортировка списка.");
        Collections.sort(colors);
        System.out.println(colors);

        al1.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o2.toString().charAt(0) - o1.toString().charAt(0);
            }
        });

        System.out.println(al1);
    }
}