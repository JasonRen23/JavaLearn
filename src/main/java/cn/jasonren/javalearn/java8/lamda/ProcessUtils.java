package cn.jasonren.javalearn.java8.lamda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

import static java.util.Comparator.comparing;

/**
 * @author RenZhiCheng
 * @since 2019-08-24 16:58
 */
public class ProcessUtils {
    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =
                 new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

        public void test() throws Exception {
//        String oneLine = processFile((BufferedReader br) -> br.readLine());
//        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());

            Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
            List<String> listOfStrings = Arrays.asList("lambda", "in");
            List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
            listOfStrings.sort(comparing(String::length));
            listOfStrings.sort(String::compareToIgnoreCase);

            Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
            Function<String, Integer> stringToInteger1 = Integer::parseInt;

            BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
            BiPredicate<List<String>, String> contains1 = List::contains;

            Supplier<Apple> c1 = Apple::new;
            Apple a1 = c1.get();

//        Function<Integer, Apple> c2 = Apple::new;
//        Apple a2 = c2.apply(100);
//
//        List<Integer> weights = Arrays.asList(7, 3, 5, 4);
//        List<Apple> apples = map(weights, Apple::new);

            List<Integer> weights = Arrays.asList(7, 3, 5, 5);
            List<Integer> countries = Arrays.asList(1, 2, 3, 4);
            List<Apple> apples = map(weights, countries, Apple::new);
            apples.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getCountry));
    }

    private void test2() {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        System.out.println(h.apply(1));

        Function<Integer, Integer> h1 = f.compose(g);
        System.out.println(h1.apply(1));
    }

    public static void main(String[] args) throws Exception {
        Supplier<ProcessUtils> processUtilsSupplier = ProcessUtils::new;
        processUtilsSupplier.get().test2();
    }


    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

    public static <T, R, U> List<U> map(List<T> list1, List<R> list2, BiFunction<T, R, U> f) {
        List<U> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            result.add(f.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }
}
