package net.htlgkr.RamadaniS190231.beispiel3;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        final Predicate<Integer> isEven = i -> i%2 == 0;
        final Predicate<Integer> isPositive2 = i -> i>0;
        final IntPredicate isPositive = i -> i>0;
        final Predicate<String> isShortWord = word -> word.length() <= 4;

        System.out.println(isEven.test(10));
        System.out.println(isEven.test(9));
        System.out.println();

        System.out.println(isPositive.test(2));
        System.out.println(isPositive.test(-6));
        System.out.println();

        System.out.println(isShortWord.test("Hey"));
        System.out.println(isShortWord.test("Hello"));
        System.out.println();

        System.out.println(isEven.and(isPositive2).test(6));
        System.out.println(isEven.and(isPositive2).test(-6));
        System.out.println();

        System.out.println(isEven.negate().and(isPositive2).test(6));
        System.out.println(isEven.negate().and(isPositive2.negate()).test(-6));
        System.out.println();

    }
}
