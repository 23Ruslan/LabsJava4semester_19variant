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
    {
        /**
     * There is double field for store array
     */
        double[][] array1 = new double[k][k];
        for (int i = 0; i < k; i++)
        {
            for (int j = 0; j < k; j++) {
                array1[i][j] = ( Math.random() * (k - (-k)) ) + (-k);
                System.out.print(array1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int n = 0; n < k; n++)
        {
            int row = 0, col = 0;
            double max = -k*1.0000000;
            for (int i = 0; i < k; i++)
                for (int j = 0; j < k; j++)
                {
                    if (i != j || i > n)
                        if (array1[i][j]>max)
                    {
                        max = array1[i][j];
                        row = i; col = j;
                    }
                }
            double temp = array1[n][n];
            array1[n][n] = array1[row][col];
            array1[row][col] = temp;
        }
        for (int i = 0; i < k; i++)
        {
            for (int j = 0; j < k; j++) {
                System.out.print(array1[i][j] + " ");
            }
            System.out.println();
        }
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