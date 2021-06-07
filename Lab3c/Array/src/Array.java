import java.util.Arrays;
import java.util.Date;
import java.util.Random;
public class Array {
    static final int n = 10;
public int a[] = new int[n];
    public Array(int a[]) {

        for (int i = 0; i < n; i++) {
            this.a[i] = a[i];
        }
    }
    void show() { System.out.println("");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        } System.out.println("");
    }
    public static void selectionSort(int[] a){ //сортировка пузырьком
    /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        for (int i = 0; i < a.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = a[i];
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i+1; j < a.length; j++) {
                //Если находим, запоминаем его индекс
                if (a[j] < min) {
                    min = a[j];
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                int tmp = a[i];
                a[i] = a[min_i];
                a[min_i] = tmp;
            }
        }
    }

    public static void bubbleSort(int[] a){ //сортировка выбором
    /*Внешний цикл каждый раз сокращает фрагмент массива,
      так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
        for(int i = a.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            /*Сравниваем элементы попарно,
              если они имеют неправильный порядок,
              то меняем местами*/
                if( a[j] > a[j+1] ){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }

    public static void shakerSort(int a[]) { //обменная сортировка «Шейкер-сортировка»
        int buff;
        int left = 0;
        int right = a.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (a[i] > a[i + 1]) {
                    buff = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (a[i] < a[i - 1]) {
                    buff = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    public static void shellSort(int a[]) { //сортировка Шелла (сортировка с убывающим шагом)
        // Высчитываем промежуток между проверяемыми элементами
        int gap = a.length / 2;
// Пока разница между элементами есть
        while (gap >= 1) {
            for (int right = 0; right < a.length; right++) {
                // Смещаем правый указатель, пока не сможем найти такой, что
                // между ним и элементом до него не будет нужного промежутка
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (a[c] > a[c + gap]) {
                        swap( a, c, c + gap);
                    }
                }
            }
            // Пересчитываем разрыв
            gap = gap / 2;
        }
    }

    public static void SortUnsorted(int[] a, int lo, int hi) {

        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        SortUnsorted(a, lo, mid);
        SortUnsorted(a, mid + 1, hi);

        int[] buf = Arrays.copyOf(a, a.length);

        for (int k = lo; k <= hi; k++)
            buf[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > hi) {
                a[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
    }

    public static void insertionSort(int[] a){ //сортировка вставками (метод простых вставок)
        for (int left = 0; left < a.length; left++) {
            // Вытаскиваем значение элемента
            int value = a[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < a[i]) {
                    a[i + 1] = a[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            a[i + 1] = value;
        }
    }

    public static void main(String[] args) {
        int a1[] = {1,1,2,3,47,5,6,71,8,9};
        int a2[] = {11,110,23,43,447,5,6,701,8,9};
        int a3[] = {155,10,52,3,471,5,56,71,8,9};
        int a4[] = {1,101,2,3,747,5,6,71,8,9};
        int a5[] = {23,72,6,2,33,53,7,1,14,11};
        int a6[] = {1,10,25,70,47,57,6,715,8,9};
        Array a = new Array(a1); Array b = new Array(a2); Array c = new Array(a3);
        Array d = new Array(a4); Array e = new Array(a5); Array f = new Array(a6);
        bubbleSort(a.a);
        a.show();
        selectionSort(b.a);
        b.show();
        shakerSort(c.a);
        c.show();
        shellSort(d.a);
        d.show();
        SortUnsorted(e.a,0,e.a.length-1);
        e.show();
        insertionSort(f.a);
        f.show();

        HashSort hs = new HashSort();
        hs.randomize();
        hs.startTime = (new Date()).getTime();
        hs.sort();
        hs.finishTime = (new Date()).getTime();
        hs.startTimeQuick = (new Date()).getTime();
        Arrays.sort(hs.quick);
        hs.finishTimeQuick = (new Date()).getTime();
        System.out.println(hs.toString());
    }
}
class HashSort {//Сама формула здесь называется хеш-функцией, а вспомогательный массив для приблизительного распределения — хеш-таблицей
    // Размер массива исходных данных
    static int SOURCELEN = 10;
    int source[] = new int[SOURCELEN];
    // Копия исходных данных для сравнения с быстрой сортировкой
    int quick[] = new int[SOURCELEN];
    // Размер блока для хэширующей сортировки
    static int SORTBLOCK = 500;
    static int k = 3;
    // Временный массив
    static int TMPLEN = (SOURCELEN < SORTBLOCK * k) ? SORTBLOCK * k : SOURCELEN;
    int tmp[] = new int[TMPLEN];
    // Диапазон значений исходных данных
    static int MIN_VAL = 10;
    static int MAX_VAL = 1000000;
    int minValue = 0;
    int maxValue = 0;
    double hashKoef = 0;
    long finishTime = 0;
    long startTime = 0;
    long finishTimeQuick = 0;
    long startTimeQuick = 0;
    // Заполнение массива исходных данных случайными значениями
    public void randomize() {
        int i;
        Random rnd = new Random();
        for(i=0; i<SOURCELEN; i++) {
            int rndValue = MIN_VAL + ((int)(rnd.nextDouble()*((double)MAX_VAL-MIN_VAL)));
            source[i] = rndValue;
        } System.out.println("");System.out.print("Исходный массив (из случайных чисел) для хэширующей сортировки: ");
        for (int j = 0; j < source.length; j++) {
            System.out.print(source[j]+" ");
        } System.out.println("");
    }
    // Поиск минимального и максимального значений плюс вычисление коэффициента для хэш-функции
    public void findMinMax(int startIndex, int endIndex) {
        int i;
        minValue = source[startIndex];
        maxValue = source[startIndex];
        for(i=startIndex+1; i<=endIndex; i++) {
            if( source[i] > maxValue) {
                maxValue = source[i];
            }
            if( source[i] < minValue) {
                minValue = source[i];
            }
        }
        hashKoef = ((double)(k-1)*0.9)*((double)(endIndex-startIndex)/((double)maxValue-(double)minValue));
    }
    // Склеивание двух смежных отсортированных частей массива
    public void stickParts(int startIndex, int mediana, int endIndex) {
        int i=startIndex;
        int j=mediana+1;
        int k=0;
        while(i<=mediana && j<=endIndex) {
            if(source[i]<source[j]) {
                tmp[k] = source[i];
                i++;
            } else {
                tmp[k] = source[j];
                j++;
            }
            k++;
        }
        if( i>mediana ) {
            while(j<=endIndex) {
                tmp[k] = source[j];
                j++;
                k++;
            }
        }
        if(j>endIndex) {
            while(i<=mediana) {
                tmp[k] = source[i];
                i++;
                k++;
            }
        }
        System.arraycopy(tmp, 0, source, startIndex, endIndex-startIndex+1);
    }
    // Сдвиг вправо во временном массиве для разрешения коллизий
    boolean shiftRight(int index) {
        int endpos = index;
        while( tmp[endpos] != 0) {
            endpos++;
            if(endpos == TMPLEN) return false;
        }
        while(endpos != index ) {
            tmp[endpos] = tmp[endpos-1];
            endpos--;
        }
        tmp[endpos] = 0;
        return true;
    }
    // хэш-функция для хэширующей сортировки
    public int hash(int value) {
        return (int)(((double)value - (double)minValue)*hashKoef);
    }
    // вставка значений во временный массив с разрешением коллизий
    public void insertValue(int index, int value) {
        int _index = index;
        while(tmp[_index] != 0 && tmp[_index] <= value) { _index++; }
        if( tmp[_index] != 0) {
            shiftRight(_index);
        }
        tmp[_index] = value;
    }
    // копирование отсортированных данных из временного массива в исходный
    public void extract(int startIndex, int endIndex) {
        int j=startIndex;
        for(int i=0; i<(SORTBLOCK*k); i++) {
            if(tmp[i] != 0) {
                source[j] = tmp[i];
                j++;
            }
        }
    }
    public void clearTMP() {
        if( tmp.length < SORTBLOCK*k) {
            Arrays.fill(tmp, 0);
        } else {
            Arrays.fill(tmp, 0, SORTBLOCK*k, 0);
        }
    }
    // Хэширующая сортировка
    public void hashingSort(int startIndex, int endIndex) {
        // 1. Поиск минимального и максимального значения с вычислением хэширующего коэффициента
        findMinMax(startIndex, endIndex);
        // 2. Очистка временного массива
        clearTMP();
        // 3. Вставка во временный массив с использованием хэш-функции
        for(int i=startIndex; i<=endIndex; i++) {
            insertValue(hash(source[i]), source[i]);
        }
        // 4. Перемещение отсортированных данных из временного массива в исходный
        extract(startIndex, endIndex);
    }
    // Рекурсивный спуск с дихотомией до уровня блока хэширующей сортировки
    public void sortPart(int startIndex, int endIndex) {
        if( (endIndex - startIndex) <= SORTBLOCK ) {
            hashingSort(startIndex, endIndex);
            return;
        }
        int mediana = startIndex + (endIndex - startIndex) / 2;
        sortPart(startIndex, mediana);
        sortPart(mediana+1, endIndex);
        stickParts(startIndex, mediana, endIndex);
    }
    public void sort() {
        sortPart(0, SOURCELEN-1);
    }
    // Отображение результатов
    public String toString() {
        int i;
        String res = "";
        res += "Отсортированный массив:";
        if( SOURCELEN < 300) {
            for(i=0; i<SOURCELEN; i++) {
                res += " " + source[i];
            }
        }
        res += "\n";
        res += "len: " + SOURCELEN + "\n";
        res += "hashing&merge sort time: " + (finishTime - startTime) + "\n";
        res += "quick sort time: " + (finishTimeQuick - startTimeQuick) + "\n";
        return res;
    }
}