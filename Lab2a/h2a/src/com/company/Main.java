package com.company;
import java.util.Scanner;
import java.util.Date;
/**
 * @author Ruslan
 * @version 1
 * This is Main class
 */
public class Main {
    /**
     * This method will show matrix
     * @param k is some size of the matrix
     */
    public static void showArray(int k)
    { if (Math.sqrt(k) % 1 == 0) {
        int n = (int) Math.sqrt(k);
        /**
         * There is double field for store array
         */
        int[][] array1 = new int[n][n];
        int a = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a++;
                array1[i][j] = a;
                System.out.print(array1[i][j] + " ");
            }
            System.out.println();
        }
    } else{System.out.println("Ошибка! Введённое число должно быть квадратом натурального числа для составления квадратной матрицы!");}
    }
    /**
     * Here start point of the program
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();
        System.out.printf("Your number: %d \n", num);
        in.close();
        showArray(num);

        System.out.println("Ruslan Baranov");
        Date d = new Date();
        System.out.println("Сдача задания - " + d);
        System.out.println("Получение задания - 22.02.2021 13:00");
    }
}