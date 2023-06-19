package Classes.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {

    }

    public static int[] monkeyCount(final int n) {
        return IntStream.rangeClosed(1, n)
                .sorted()
                .toArray();
    }


    public static int findSmallestInt(int[] args) {
        return IntStream.of(args)
                .min()
                .getAsInt();
    }

    public static long numberOfDivisors(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> n % i == 0)
                .count();
    }

    public static int sum(int[] arr) {
        return Arrays.stream(arr)
                .filter(x -> x > 0)
                .sum();
    }

}
