class FilmAction {
    private final static int BASE_RATING = 10;
    public double rate(float criticMark, float popularMark) {
        return (criticMark + popularMark + BASE_RATING) / 3;
    }
}
class Film {
   public class CommonInfo {
        public int length;
        public String genre;
        public int []directors;
       void show() { System.out.println("");
           System.out.print(length+" "+genre+" ");System.out.println("");
           for (int i = 0; i < directors.length; i++) {
               System.out.print(directors[i]+" ");System.out.println("");
           }
       }
   }
        /*public void CommonInfo(int length, String genre,String []directors) {
        this.length=length; this.genre = genre;
            for (int i = 0; i < directors.length; i++) {
                this.directors[i] = directors[i];
            }
        }*/


    CommonInfo inform = new CommonInfo();
    FilmAction rateAction = new FilmAction() {
        float base = 5;
        @Override
        public double rate(float criticMark, float popularMark) {
            float value;
            if (criticMark <= base || popularMark <= base) {
                value = base;
            } else {
                value = (criticMark + popularMark) / 2;
            }
            return value;
        }
    };
}
public class Main {
    public static void main(String[] args) {
        int[] Dir = {1233123, 123123, 3642626};
        Film D = new Film();
        D.inform.length = 60;
        D.inform.genre = "comedy";
        D.inform.directors = Dir;
        D.inform.show();
        System.out.println("rate = "+D.rateAction.rate(20,40));
    }
}