package ru.study.geekbrains;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static String[] splittedByNewLine;
    public static void main(String[] args) {

//        1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
        System.out.println("1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя " +
                "классы FileWriter и FileReader");

        try {
            FileWriter writer = new FileWriter("task1.txt");
            writer.append("Hello, FileWriter!");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            String text = "";
            FileReader reader = new FileReader("task1.txt");
            while(reader.ready()) {
                text += (char) reader.read();
            }
            System.out.println(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//        2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам
//        и вывести в консоль в формате "Иванов И.И. 32 М"
        System.out.println("2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. " +
                "Разбить по строкам и вывести в консоль в формате \"Иванов И.И. 32 М\"");
        try {
            String text = "";
            FileReader reader = new FileReader("task2.txt");
            while (reader.ready()) {
                text += (char) reader.read();
            }
            splittedByNewLine = text.split("\n");

            for (int i = 0; i < splittedByNewLine.length; i++) {
                String[] splittedBySpace = splittedByNewLine[i].split(" ");
                System.out.printf("%s %s.%s. %d %s\n", splittedBySpace[0], splittedBySpace[1].charAt(0), splittedBySpace[2].charAt(0),
                        Integer.parseInt(splittedBySpace[3]), splittedBySpace[4].toUpperCase().charAt(0));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//        3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
        System.out.println("\n3. Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.");

        ArrayList<String> surname = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> longName = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> sex = new ArrayList<>();

        for (int i = 0; i < splittedByNewLine.length; i++) {
            String[] tmp = splittedByNewLine[i].split(" ");
            surname.add(tmp[0]);
            name.add(tmp[1]);
            longName.add(tmp[2]);
            age.add(Integer.parseInt(tmp[3]));
            sex.add(tmp[4].toLowerCase().contains("м")?true:false);
        }
        System.out.println(surname);
        System.out.println(name);
        System.out.println(longName);
        System.out.println(age);
        System.out.println(sex);

//        4. Отсортировать по возрасту используя дополнительный список индексов.
        System.out.println("\n4. Отсортировать по возрасту используя дополнительный список индексов.");

        ArrayList<Integer> addIndexList = makeAddIndList(arrayListToIntArray(age), age);
        ArrayList<String> sortedArraySurname = sortAscByAge(surname, addIndexList);
        ArrayList<String> sortedArrayName = sortAscByAge(name, addIndexList);
        ArrayList<String> sortedArrayLongName = sortAscByAge(longName, addIndexList);
        ArrayList<Integer> sortedArrayAge = sortAscByAge(age, addIndexList);
        ArrayList<Boolean> sortedArraySex = sortAscByAge(sex, addIndexList);
        System.out.println(sortedArraySurname);
        System.out.println(sortedArrayName);
        System.out.println(sortedArrayLongName);
        System.out.println(sortedArrayAge);
        System.out.println(sortedArraySex);

    }

    static ArrayList makeAddIndList (Integer[] arr, ArrayList tmp) {
        ArrayList<Integer> index = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j + 1] < arr[j]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            index.add(tmp.indexOf(arr[i]));
        }
        return index;
    }

    static ArrayList sortAscByAge (ArrayList arr, ArrayList<Integer> index) {
        ArrayList tmp = new ArrayList<>();
        for (int i = 0; i < index.size(); i++) {
            tmp.add(arr.get(index.get(i)));
        }
        return tmp;
    }

    static Integer[] arrayListToIntArray (ArrayList al) {
        Integer[] result = new Integer[al.size()];
        for (int i = 0; i < al.size(); i++) {
            result[i] = (Integer) al.get(i);
        }
        return result;
    }
}