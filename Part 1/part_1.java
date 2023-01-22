// Part 1 01/22/2023
// Konstantin Sokolov

import java.util.Random;

public class part_1 {

    public static void main(String[] args) {
        
        System.out.println("1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i:");
        int i = new Random().nextInt(2001);
        System.out.printf("Случайное целое число = %d.\n\n", i);

        // ==================================================================================================
        // ==================================================================================================

        System.out.println("2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа:");
        int n = Integer.highestOneBit(i);
        System.out.printf("Номер старшего значащего бита выпавшего числа - %d.\n\n", n);

        // ==================================================================================================
        // ==================================================================================================

        System.out.println("3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1:");
        // System.out.print("Все кратные n числа в диапазоне от i до Short.MAX_VALUE: ");
        int count = 0;
        for(int j = i; j <= Short.MAX_VALUE; j++) {
            if(j % n == 0) {
                count++;
            }
        }
        int[] m1 = new int[count];
        count = 0;
        for(int j = i; j <= Short.MAX_VALUE; j++) {
            if(j % n == 0) {
                m1[count] = j;
                count++;
                // System.out.printf("%d, ", j);
            }
        }
        // System.out.println("\b\b.\n");
        System.out.printf("Размер массива m1 = %d\n\n", m1.length);

        // ==================================================================================================
        // ==================================================================================================

        System.out.println("4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2:");
        count = 0;
        for(int j = Short.MIN_VALUE; j <= i; j++) {
            if(j % n != 0) {
                count++;
            }
        }
        int[] m2 = new int[count];
        count = 0;
        for(int j = Short.MIN_VALUE; j <= i; j++) {
            if(j % n != 0) {
                m2[count] = j;
                count++;
                // System.out.printf("%d, ", j);
            }
        }
        // System.out.println("\b\b.\n");
        System.out.printf("Размер массива m2 = %d\n", m2.length);
    }
    
}
