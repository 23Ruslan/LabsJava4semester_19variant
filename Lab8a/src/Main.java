import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
public class Main {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        String a = null;
        String b = "";
        String c = "Stroka";
        System.out.println("Результирующая функция будет для нулевых ссылок на String возвращать 0," +
                " а для ненулевых ссылок возвращать длину строки.");
        System.out.println("Для "+a+": "+safeStringLength.apply(a));
        System.out.println("Для "+b+": "+safeStringLength.apply(b));
        System.out.println("Для "+c+": "+safeStringLength.apply(c));
    }
}/*Предикаты
Предикаты — это функции, принимающие один аргумент, и возвращающие значение типа boolean.

Интерфейс содержит различные методы по умолчанию, позволяющие строить сложные условия (and, or, negate).

Predicate<String> predicate = (s) -> s.length() > 0;

predicate.test("foo");              // true
predicate.negate().test("foo");     // false

Predicate<Boolean> nonNull = Objects::nonNull;
Predicate<Boolean> isNull = Objects::isNull;

Predicate<String> isEmpty = String::isEmpty;
Predicate<String> isNotEmpty = isEmpty.negate();*/

/*описание задачи в комментах https://stepik.org/lesson/12777/step/8 */

/* https://www.youtube.com/watch?v=oUvx2Up-PkA */

/*документация по Objects::isNull - https://docs.oracle.com/javase/8/docs/api/java/util/Objects.html */

/*лямбда https://www.youtube.com/watch?v=Wc4CIUlfpWg*/
