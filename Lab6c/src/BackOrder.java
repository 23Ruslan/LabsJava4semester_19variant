/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.io.File;
import javax.swing.JOptionPane;
/**Класс предназначен для инвертирования строк текста.
 * Есть метод который использует путь к файлу читает строки, инвертирует их
 * и сохраняет в другом файле.
 *
 * Так же присутствует метод который в качестве формального параметра использует
 * переменную String типа.
 * И сохраняет ее в переменной реализации, которую при необходимости можно вывести
 * на экран.
 */
public class BackOrder {

    PrintWriter outputStream;
    BufferedReader inputStream;
    private String backOrderString = "";

    public static void main(String[] args) {
        BackOrder a = new BackOrder();
        File in = new File("./in.txt");
        try {
            a.backOrderTheFile(in);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.out.println("Что то не так. 22");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File empty!");
        }
    }

    public void backOrderString(String str) {
        int i = str.length();
        while (i > 0) {
            backOrderString = backOrderString + str.charAt(i - 1);
            i--;
        } backOrderString = backOrderString + "\n";
    }

    public static int countLinesOld(File filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }

    public void backOrderTheFile(File newFile) throws FileNotFoundException, IOException {
        int n = countLinesOld(newFile);

       inputStream = new BufferedReader(new FileReader(newFile));
        String str;
        int p = 0;
        while (p <= n) {
            str = inputStream.readLine();
            backOrderString(str);p++;
        }
        inputStream.close();
        File filePath = new File("Saving_Output_in_This_Folder");
        filePath.mkdir();
        outputStream = new PrintWriter(new FileOutputStream(filePath+"\\out.txt", true));
        PrintWriter writer = new PrintWriter(filePath+"\\out.txt"); //clearFile
        writer.print("");
        writer.close();
        outputStream.println(backOrderString);
        outputStream.close();
    }
}