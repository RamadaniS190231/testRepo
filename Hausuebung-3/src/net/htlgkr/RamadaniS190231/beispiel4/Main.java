package net.htlgkr.RamadaniS190231.beispiel4;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final IntPredicate isUneven = i -> i%2==1;
        final int result = IntStream.of(1,2,3,4,5,6,7,8,9,10)
                .filter(isUneven)
                .map(number -> number*number)
                .sum();
        System.out.println(result);
    }
}
