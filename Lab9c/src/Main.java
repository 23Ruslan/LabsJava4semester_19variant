import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] strArray = {"World!", "Hello", "And how do you do?", "aa", "And how do you do?And how do you do?"};
        Comparator<String> byLength = Comparator.comparingInt(String::length);
        Comparator<String> byNumberOfVowels = Comparator.comparingInt(Main::countVowels);
        Comparator<String> composition = byLength.reversed().thenComparing(byNumberOfVowels);
        for(int i = 0; i < strArray.length; i++){
            for(int j = 0; j < strArray.length - 1 - i; j++){
                if(composition.compare(strArray[j], strArray[j + 1]) > 0){
                    String str = strArray[j];
                    strArray[j] = strArray[j + 1];
                    strArray[j + 1] = str;
                }
            }
        }
        for(String s : strArray){
            System.out.println(s);
        }
    }
    private static int countVowels(String string) {
        return string.replaceAll("[^aoiue]", "").length();
    }
}