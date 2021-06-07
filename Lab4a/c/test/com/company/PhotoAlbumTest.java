package com.company;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.io.*;

public class PhotoAlbumTest {
    @Test(description = "show() - стандартный вывод на консоль")
    public void testShow() throws Exception {
        PrintStream save_out=System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.out.println("Hello World!1234567890");
        assertEquals("Hello World!1234567890\r\n" , out.toString());
        System.setOut(save_out);
    }
    @Test(description = "show1() - стандартный вывод на консоль")
    public void testShow1() throws Exception {
        PrintStream save_out=System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.out.println("Hello World!1234567890");
        assertEquals("Hello World!1234567890\r\n" , out.toString());
        System.setOut(save_out);
    }
    @Test(description = "determing() - проверка, есть ли равные называния среди уже существующих и добавленных фотографий одновременно")
    public void testDetermining() throws Exception {
        PhotoAlbum album = new PhotoAlbum();
        album.setX("1");
        album.setY("0");
        album.setPage(5);
        Photo point = new Photo();
        point.setX("");
        point.setY("8");
        int actual, expected;
        actual = album.determining(point);
        expected = 1;
        assertEquals(actual, expected);
    }
    }