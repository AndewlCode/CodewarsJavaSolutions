package Classes.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        System.out.println(countingSheep(5));
    }

    public static String countingSheep(int num) {
        return IntStream.rangeClosed(1, num)
                .mapToObj(x -> Integer.parseInt(String.valueOf(x)) + " sheep...")
                .collect(Collectors.joining());
    }

    public static int arrayPlusArray(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1).sum() + Arrays.stream(arr2).sum();
    }


    public static String abbrevName(String name) {
        return Arrays.stream(name.toUpperCase().split(" "))
                .map(s -> String.valueOf(s.charAt(0)))
                .collect(Collectors.joining("."));
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
