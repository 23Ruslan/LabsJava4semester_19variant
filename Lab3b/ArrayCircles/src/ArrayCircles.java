import java.util.Arrays;
public class ArrayCircles {
    public static class Circle {
        public double x;
        public double y;
        public double r;
        public double l;
        public double s;
        public double k;

        public Circle (int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.l = 2*3.142*r;
            this.s = 3.142*r*r;
            this.k = (double)y/x;
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "x =" + x +
                    ", y =" + y +
                    ", r =" + r +
                    ", l = " + l +
                    ", s = " + s +
                    '}';
        }
    }
    public static void main(String[] args) {
        Circle[] DIM = new Circle[16];
        DIM[0] = new Circle(15, 1, 1);
        DIM[1] = new Circle(2, 2, 2);
        DIM[2] = new Circle(6, 1, 3);
        DIM[3] = new Circle(12, 1, 1);
        DIM[4] = new Circle(1, 2, 1);
        DIM[5] = new Circle(2, 2, 3);
        DIM[6] = new Circle(9, 3, 1);
        DIM[7] = new Circle(12, 6, 4);
        DIM[8] = new Circle(1, 6, 4);
        DIM[9] = new Circle(2, 8, 7);
        DIM[10] = new Circle(6, 6, 6);
        DIM[11] = new Circle(12, 5, 5);
        DIM[12] = new Circle(1, 7, 7);
        DIM[13] = new Circle(4, 2, 9);
        DIM[14] = new Circle(2, 1, 10);
        DIM[15] = new Circle(8, 9, 12);

        System.out.println( DIM[3].x);
        for (int i = 0; i <= 15; i++) {
            System.out.println("Окружность: " +
                    "x =" + DIM[i].x +
                    ", y =" + DIM[i].y +
                    ", r =" + DIM[i].r +
                    ", l = " + DIM[i].l +
                    ", s = " + DIM[i].s +
                    ", k = " + DIM[i].k);
        }System.out.println("");
        int maxInd = 0; int minInd = 0;
        double max = DIM[0].s;
        double min = DIM[0].s;
        for (int i = 0; i <= 15; i++) {
            if (DIM[i].s > max) {
                max = DIM[i].s;
            }
            if (DIM[i].s < min) {
                min = DIM[i].s;
            }
        }
        for (int i = 0; i <= 15; i++) {
            if (DIM[i].s == max) {
                maxInd = i;
            }
            if (DIM[i].s == min) {
                maxInd = i;
            }
        }
        System.out.println("Наибольшая площадь = "+ max + " у окружности (объекта) под номером "+maxInd+
                ";\n Наименьшая площадь = " + min + " у окружности (объекта) под номером "+minInd); System.out.println("");

        double maxl = DIM[0].l;
        double minl = DIM[0].l;
        for (int i = 0; i <= 15; i++) {
            if (DIM[i].l > maxl) {
                maxl = DIM[i].l;
            }
            if (DIM[i].l < minl) {
                minl = DIM[i].l;
            }
        }
        for (int i = 0; i <= 15; i++) {
            if (DIM[i].l == maxl) {
                maxInd = i;
            }
            if (DIM[i].l == minl) {
                maxInd = i;
            }
        }
        System.out.println("Наибольший периметр = "+ maxl + " у окружности (объекта) под номером "+maxInd+
                ";\n Наименьший периметр = " + minl + " у окружности (объекта) под номером "+minInd);
int[][] Arrays1 = new int[16][16];
for (int i = 0; i <= 15; i++) {
    for (int j = 0; j <= 15; j++) {
        if (DIM[i].k == DIM[j].k) {
            Arrays1[i][j] = 1;
        }
    }
}
System.out.println("");
        for (int i = 0; i <= 15; i++) {
            for (int j = 0; j <= 15; j++) {
                System.out.print(Arrays1[i][j] + " ");
            }  System.out.println("");
        }

        System.out.println("");System.out.println("Группы окружностей, лежащих на одной прямой:");
        for (int i = 0; i <= 15; i++) {
            int h = 0; int h1 =0;
            for (int j = 0; j <= 15; j++) {
                if (Arrays1[i][j] == 1 &&  i!=j) {
                    h=1;
                }
            }
            if (h==1 &&  i!=0) {
                for (int n = 0; n < i; n++) {
                    if(Arrays.equals(Arrays1[i], Arrays1[n])){
                        h1=1;break;
                    }
                }
            }
                if (h==1 &&  h1==0)   {
                for (int j = 0; j <= 15; j++){
                    if (Arrays1[i][j] == 1){
                        System.out.print(j+" ");
                    }
                }
                System.out.println("");
            }
            }

        }
    /*     for (int n = 0; n < i; n++) {
            if (DIM[i].k == DIM[n].k) {
                if (i != 0) {
                    break;
                }
            }
            for (int j = i + 1; j < 15; i++) {
                if (DIM[i].k == DIM[j + 1].k) Arrays1[j][j + 1] = 1;
            }
        }*/

        }