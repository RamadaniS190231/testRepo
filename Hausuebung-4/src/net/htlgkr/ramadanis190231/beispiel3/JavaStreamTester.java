package net.htlgkr.ramadanis190231.beispiel3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamTester {

    public static void main(String[] args) {
        List<String> arrStr1 = Arrays.asList("abc", "", "bc", "Hallo", "", "", "jkl");
        List<Integer> arrStr2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> arrStr3 = Arrays.asList(-12, -6, 0, 5, 13);
        List<Integer> arrStr4 = Arrays.asList(2, 3, 4, 5, 6);

        System.out.println(getCountEmptyString(arrStr1));
        System.out.println(getCountLength3(arrStr1));
        System.out.println(deleteEmptyStrings(arrStr1));
        System.out.println(getMergedString(arrStr1, ":"));
        System.out.println(getSquares(arrStr2));
        System.out.println(getMax(arrStr3));
        System.out.println(getMin(arrStr3));
        System.out.println(getSum(arrStr4));
        System.out.println(getAverage(arrStr4));


    }

    private static int getCountEmptyString(List<String> strings) {
        long emptyStrings = strings
                .stream()
                .filter(x -> x.isEmpty())
                .count();
        return (int) emptyStrings;
    }

    private static int getCountLength3(List<String> strings) {
        long lengthString = strings
                .stream()
                .filter(x -> x.length() == 3)
                .count();
        return (int) lengthString;
    }

    private static List<String> deleteEmptyStrings(List<String> strings) {
        List<String> list = strings
                .stream()
                .filter(x -> !x.equals(""))
                .collect(Collectors.toList());
        return list;
    }

    private static String getMergedString(List<String> strings, String seperator) {
        String s = strings
                .stream()
                .collect(Collectors.joining(seperator));
        return s;
    }

    private static List<Integer> getSquares(List<Integer> numbers) {
        List<Integer> list = numbers
                .stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        return list;
    }

    private static int getMax(List<Integer> numbers) {

        int max = numbers
                .stream()
                .max(Integer::compareTo)
                .get();
        return max;
    }

    private static int getMin(List<Integer> numbers) {

        int min = numbers
                .stream()
                .min(Integer::compareTo)
                .get();
        return min;
    }

    private static int getSum(List<Integer> numbers) {
        int sumResult = numbers.stream().mapToInt(n -> n).sum();
        return sumResult;
    }

    private static int getAverage(List<Integer> numbers) {
        double avrg = numbers.stream().mapToInt(n -> n).average().getAsDouble();
        return (int) avrg;
    }
}
