package ru.study.geekbrains;

public class Main {

    private static boolean checkForRotation (String str1, String str2) {
        return (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != -1);
    }

    private static String stringReversion(String str) {
        if (str.isEmpty() || str.length() < 2) {
            return str;
        } else {
            return stringReversion(str.substring(1)) + str.charAt(0);
        }
    }

    public static void main(String[] args) {

//        1. Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
        System.out.println("1. Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).");
        if ("ABACD".contains("ABA")) {
            System.out.println("Содержит!");
        } else {
            System.out.println("Не содержит!");
        }

//        2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).

//        !!!   ЗДЕСЬ, ЧЕСТНО ПРИЗНАТЬСЯ, Я НЕ СОВСЕМ ПОНЯЛ СУЬТ ЗАДАЧИ  !!!

        System.out.println("\n2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).");

        // ROTATION
        System.out.print("Строки: ABACD и DABAC");
        if (checkForRotation("ABACD", "DABAC")) {
            System.out.println(" являются вращением друг друга!");
        } else {
            System.out.println(" не являются вращением друг друга!");
        }

        // REVERSION
        System.out.print("Строка ABCDEF");
        if ("ABCDEF".contains(stringReversion("FEDC"))) {
            System.out.print(" содержит");
        } else {
            System.out.print(" не содержит");
        }
        System.out.println(" обратное вхождение FEDC!");

//        3. Напишите программу, чтобы перевернуть строку с помощью рекурсии.
        System.out.println("\n3. Напишите программу, чтобы перевернуть строку с помощью рекурсии.");
        System.out.println(stringReversion("ABCDEF"));

//        4. Дано два числа, например 3 и 56, необходимо составить следующие строки:
//        3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
        System.out.println("4. Дано два числа, например 3 и 56, необходимо составить следующие строки: " +
                "3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().");
        StringBuilder strSB3 = new StringBuilder();

        strSB3.append(3).append(" + ").append(56).append(" = ").append(3 + 56).append("\n");
        strSB3.append(3).append(" - ").append(56).append(" = ").append(3 - 56).append("\n");
        strSB3.append(3).append(" * ").append(56).append(" = ").append(3 * 56);

        System.out.println(strSB3.toString());

//        5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        System.out.println("5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().");
        StringBuilder strSB4 = new StringBuilder();
        strSB4.append(3).append(" * ").append(56).append(" = ").append(3 * 56);

        strSB4.deleteCharAt(7);
        strSB4.insert(7, "равно");
        System.out.println(strSB4);

//        6. *Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
        System.out.println("6. *Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().");
        StringBuilder strSB5 = new StringBuilder();

        strSB5.append(3).append(" + ").append(56).append(" = ").append(3 + 56);

        strSB5.replace(7, 8, "равно");

        System.out.println(strSB5);

//        7. Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
        System.out.println("7. Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов \"=\" средствами String и StringBuilder.");
        Long strTime;

        String str7 = "";

        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10001; i++) {
            str7 += "=";
        }
        Long stop = System.currentTimeMillis();

        strTime = stop - start;

        StringBuilder strSB7 = new StringBuilder();

        start = System.currentTimeMillis();
        for (int i = 0; i < 10001; i++) {
            strSB7.append("=");
        }
        stop = System.currentTimeMillis();

        System.out.printf("Время выполнения средством String: %d мс, методом StringBuilder: %d мс, " +
                "что меньше на %d мс!\n", strTime, stop - start, strTime - (stop - start));



    }
}