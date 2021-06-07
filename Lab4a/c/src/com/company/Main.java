package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * @serialData
 * @version
 */
public class Main {
    static String inPath = "./res/in.txt";
    static String outPath = "./res/out.txt";
    static File inFile = new File(inPath);
    static File outFile = new File(outPath);
    static Scanner in;
    static PrintWriter out;

    public static void main(String[] args){
        int PageNumber, flag;
        PhotoAlbum album = new PhotoAlbum();
        Photo point = new Photo();Photo pointNull = new Photo();
        try {
            in = new Scanner(inFile);
            in.useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            System.out.println("Файл для чтения не найден!");
        }
        try{
            out = new PrintWriter(outFile);
        } catch (FileNotFoundException e){
            System.out.println("Файл для записи не найден!");
        }
        album .setX(in.nextLine());
        album .setY(in.nextLine());
        try {
            PageNumber = in.nextInt();
            if(PageNumber < 0)
                throw new NotNegativeException();
            album .setPage(PageNumber);
            album .show();
            pointNull.setX(in.nextLine());
            point.setX(in.nextLine());
            point.setY(in.nextLine());
           flag = album .determining(point);
            if (flag == 2){
                System.out.println("Добавлены одинаковые фото! В альбоме есть копии! Всего - 4 фото. " +
                        "Новые 2 фото были добавлены на " + PageNumber + " страницу.");
                out.println("Добавлены одинаковые фото! В альбоме есть копии! Всего - 4 фото. " +
                        "Новые 2 фото были добавлены на " + PageNumber + " страницу.");
            } else if(flag == 1){
                System.out.println("Добавлены разные фото! В альбоме нет копий! Всего - 4 фото. " +
                        "Новые 2 фото были добавлены на " + PageNumber + " страницу.");
                out.println("Добавлены разные фото! В альбоме нет копий! Всего - 4 фото. " +
                        "Новые 2 фото были добавлены на " + PageNumber + " страницу.");
            }
            album .show1(point);
        } catch (NotNegativeException e){
            System.out.println("Название должно быть строкой!");
            out.println("Отсутствует значение названия фотографии в файле!");
        } catch (NoSuchElementException e){
            System.out.println("Отсутствует значение названия фотографии в файле!");
            out.println("Отсутствует значение названия фотографии в файле!");
        }
        in.close();
        out.close();
    }
}