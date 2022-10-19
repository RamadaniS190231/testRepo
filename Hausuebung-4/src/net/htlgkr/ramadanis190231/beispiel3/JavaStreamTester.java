package net.htlgkr.ramadanis190231.beispiel3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamTester {

    public static void main(String[] args) {
        List<String> arrStr1 = Arrays.asList("abc", "", "bc", "Hallo", "", "", "jkl");
        List<Integer> arrStr2 = Arrays.asList(1,2,3,4,5,6);
        System.out.println(getCountEmptyString(arrStr1));
        System.out.println(getCountLength3(arrStr1));
        System.out.println(deleteEmptyStrings(arrStr1));
        System.out.println(getMergedString(arrStr1, ":"));
        System.out.println(getSquares(arrStr2));
    }

    private static int getCountEmptyString(List<String> strings){
        long emptyStrings = strings
                .stream()
                .filter(x -> x.isEmpty())
                .count();
        return (int) emptyStrings;
    }

    private static int getCountLength3(List<String> strings){
        long lengthString = strings
                .stream()
                .filter(x -> x.length() == 3)
                .count();
        return (int) lengthString;
    }

    private static List<String> deleteEmptyStrings(List<String> strings){
        List<String> list = strings
                .stream()
                .filter(x -> !x.equals(""))
                .collect(Collectors.toList());
        return list;
    }

    private static String getMergedString(List<String> strings, String seperator){
        String s = strings
                .stream()
                .collect(Collectors.joining(seperator));
        return s;
    }

    private static List<Integer> getSquares(List<Integer> numbers){
        List<Integer> list = numbers
                .stream()
                .map(n -> n*n)
                .collect(Collectors.toList());
        return list;
    }

    private static int getMax(List<Integer> numbers){
        return 0;
    }

    private static int getMin(List<Integer> numbers){
        return 0;
    }

    private static int getSum(List<Integer> numbers){
        return 0;
    }

    private static int getAverage(List<Integer> numbers){
        return 0;
    }
}
