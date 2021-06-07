import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Date;
public class PhoneOperator {
    public static void main(String[] args) {
        Operator telecom = new Operator("Kyiv Star");
        telecom.addCustomer(new Customer("Курочкин","Иван","Петрович","Киев, Крещатик.",
                74305720455314L,345.45,456736.60,5353,3456));
        telecom.addCustomer(new Customer("Ципочкин","Федор","Николаевич","Одесса, Деребасовсксая.",
                6275849503679L,23276.50,23.66,1345,664546));
        telecom.addCustomer(new Customer("Гусятников","Иван","Федорович","Донецк, Ленина.",
                23571056402749L,113355.37,4346.34,42225,0));
        telecom.addCustomer(new Customer("Перепелкин","Константин","Владимирович","Умань, Героев.",
                56304829561048L,226794.35,234850.35,1154656,34535));
        telecom.addCustomer(new Customer("Тетеров","Максим","Егорович","Львов, Площа.",
                57205637402739L,336.98,2544645.75,8389,0));
        telecom.addCustomer(new Customer("Уткин","Геннадий","Евдотович","Харьков, Майдан.",
                56203657208632L,5.03,253666.43,458,855672));
        telecom.addCustomer(new Customer("Воробьев","Александр","Никодимович","Киев, Оболонь.",
                72275930573902L,2432568.11,2546746.54,245267,0));
        System.out.println("Customers sorted by name:");
        ArrayList<Customer> listName = telecom.getCustomerListByAlphabet();
        for (Customer cust : listName) {
            System.out.println(cust);
        }
        System.out.println("\n\nCustomers with Local time more then 10000ms:");
        ArrayList<Customer> listLocal = telecom.getCustomerListWithLocal(10000);
        for (Customer cust : listLocal) {
            System.out.println(cust);
        }
        System.out.println("\n\nCustomers who has International calls:");
        ArrayList<Customer> listInternational = telecom.getCustomerListWithInternational(0);
        for (Customer cust : listInternational) {
            System.out.println(cust);
        } System.out.println("Ruslan Baranov");
        Date d = new Date();
        System.out.println("Сдача задания - " + d);
        System.out.println("Получение задания - 22.02.2021 13:00");
    }
}
class Operator {
    private String operatorName;
    private ArrayList<Customer> customerList = new ArrayList<>();
    Operator(String operatorName){
        this.operatorName = operatorName;
    }
    void addCustomer(Customer customer){
        customerList.add(customer);
    }
    public String getOperatorName(){
        return operatorName;
    }
    public ArrayList<Customer> getCustomerListByAlphabet(){
        ArrayList<Customer> custlist = new ArrayList<>(customerList);
        Collections.sort(custlist, new Comparator<Customer>() {
            @Override
            public int compare(Customer cust1, Customer cust2) {
                return cust1.getName().compareToIgnoreCase(cust2.getName());
            }
        });
        return custlist;
    }
    public ArrayList<Customer> getCustomerListWithInternational(long timeInternational){
        ArrayList<Customer> custlist = new ArrayList<>();
        for (Customer cust : customerList){
            if (cust.getTimeInternational() > timeInternational){
                custlist.add(cust);
            }
        }
        return custlist;
    }
    public  ArrayList<Customer> getCustomerListWithLocal(long timeLocal){
        ArrayList<Customer> custlist = new ArrayList<>();
        for (Customer cust : customerList){
            if (cust.getTimeLocal() > timeLocal){
                custlist.add(cust);
            }
        }
        return custlist;
    }
}
class Customer {
    private static int totalCustomers = 0;
    private int id = totalCustomers++;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private long cardNumber;
    private double debit;
    private double credit;
    private long timeLocal;
    private long timeInternational;
    Customer(String surname, String name, String patronymic, String address,
             long cardNumber, double debit, double credit,
             long timeLocal, long timeInternational){
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.cardNumber = cardNumber;
        this.debit = debit;
        this.credit = credit;
        this.timeLocal = timeLocal;
        this.timeInternational = timeInternational;
    }
    public void setTimeLocal(long timeLocal){
        this.timeLocal = timeLocal;
    }
    public void setTimeInternational(long timeInternational){
        this.timeInternational = timeInternational;
    }
    public int getId(){
        return id;
    }
    public String getSurname(){
        return surname;
    }
    public String getName(){
        return name;
    }
    public String getPatronymic(){
        return  patronymic;
    }
    public String getAddress(){
        return address;
    }
    public long getCardNumber(){
        return cardNumber;
    }
    public double getDebit(){
        return debit;
    }
    public double getCredit(){
        return credit;
    }
    public long getTimeLocal(){
        return timeLocal;
    }
    public long getTimeInternational(){
        return timeInternational;
    }
    public String toString(){
        return String.format("ID: %d\t Name: %s %s %s", id, name, surname, patronymic) + "\n" +
                String.format("\t\t\tCardNumber: %d\t Debit: %10.2f\t  Credit: %10.2f.", cardNumber, debit, credit) + "\n" +
                "\t\t\tLocal time: " + timeLocal + "ms,\t International time: " + timeInternational + "ms.";
    }
}