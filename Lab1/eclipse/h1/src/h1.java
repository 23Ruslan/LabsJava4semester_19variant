import java.util.Scanner;
import java.util.Date;

public class h1 {
	public static void main(String[] args) {
		System.out.println("������� ������ � ������� Enter:");
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        scan.close();
        if(str1.equals("1290S")){
            System.out.println("������ ����������");
        }
        else
        {
            System.out.println("������ �� ����������");
        }

        System.out.println("Ruslan Baranov");
        Date d = new Date();
        System.out.println("����� ������� - " + d);
        System.out.println("��������� ������� - 22.02.2021 13:00");	
	}
}
