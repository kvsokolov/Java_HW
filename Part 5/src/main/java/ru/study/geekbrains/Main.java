package ru.study.geekbrains;

import javax.swing.*;
import java.util.*;
import java.util.random.*;

public class Main {
    public static void main(String[] args) {

//        1. Создать словарь HashMap. Обобщение <Integer, String>.
        System.out.println("1. Создать словарь HashMap. Обобщение <Integer, String>.");

        Map<Integer, String> map = new HashMap<>();

//        2. Заполнить тремя ключами (индекс, цвет), добавить ключь, если не было!)
        System.out.println("2. Заполнить тремя ключами (индекс, цвет), добавить ключь, если не было!)");

        map.putIfAbsent(0, "Red");
        map.putIfAbsent(1, "Green");
        map.putIfAbsent(2, "Blue");

//        3. Изменить значения дописав восклицательные знаки.
        System.out.println("3. Изменить значения дописав восклицательные знаки.");

        map.compute(0, (k, v) -> v += "!");
        map.compute(1, (k, v) -> v += "!");
        map.compute(2, (k, v) -> v += "!");

//        4. *Создать TreeMap, заполнить аналогично.
        System.out.println("4. *Создать TreeMap, заполнить аналогично.");

        Map<Integer, String> treeMap = new TreeMap<>();

        treeMap.putIfAbsent(0, "Red");
        treeMap.putIfAbsent(1, "Green");
        treeMap.putIfAbsent(2, "Blue");
        treeMap.compute(0, (k, v) -> v += "!");
        treeMap.compute(1, (k, v) -> v += "!");
        treeMap.compute(2, (k, v) -> v += "!");

//        5. *Увеличить количество элементов до 1000 случайными ключами и общей строкой.
        System.out.println("5. *Увеличить количество элементов до 1000 случайными ключами и общей строкой.");

        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            map.putIfAbsent(random.nextInt(), "Value");
            treeMap.putIfAbsent(random.nextInt(), "Value");
        }

//        6. **Сравнить время последовательного и случайного перебора тысячи элементов словарей.
        System.out.println("6. **Сравнить время последовательного и случайного перебора тысячи элементов словарей.");
        Iterator<Integer> iterator = treeMap.keySet().iterator();

        long start = System.currentTimeMillis();
        Integer i = 0;
        while (iterator.hasNext()) {
            System.out.print(treeMap.get(iterator.next()));
        }
        long stop = System.currentTimeMillis();

        System.out.printf("\n%d ms\n", stop - start);

        start = System.currentTimeMillis();
        System.out.println(treeMap);
        stop = System.currentTimeMillis();
        System.out.printf("%d ms\n", stop - start);

    }
}