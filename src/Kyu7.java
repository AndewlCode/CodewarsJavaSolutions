import java.util.Arrays;

public class Kyu7 {


    public static void main(String[] args) {
        int[] test_arr = new int[]{1, 1, 1, 1};
        System.out.println(Arrays.toString(removeSmallest(test_arr)));
    }

    public static String switcheroo(String x) {
        return x.replaceAll("a", "_").replaceAll("b", "a").replaceAll("_", "b");
    }

    public static int[] removeSmallest(int[] numbers) {
        // check input values
        if (numbers == null || numbers.length <= 1) {
            return new int[0];
        }

        int[] result = new int[numbers.length - 1];
        int min_value = numbers[0];
        int min_value_index = 0;

        // get minimum value and minimum value index.
        for (int i = 0; i < numbers.length; i++) {
            if (min_value > numbers[i]) {
                min_value = numbers[i];
                min_value_index = i;
            }
        }
        // copy given array to new array without minimum value.
        System.arraycopy(numbers, 0, result, 0, min_value_index);
        System.arraycopy(numbers, min_value_index + 1, result, min_value_index, result.length - min_value_index);
        return result;
    }

}
