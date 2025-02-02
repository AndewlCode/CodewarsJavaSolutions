public class Kyu7 {


    public static void main(String[] args) {
        int seconds = 15;
        double[] x = new double[]{0.0, 0.19, 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0, 2.25};
        System.out.println(gps(seconds, x));
    }

    public static int gps(int s, double[] x) {
        double delta_distance = 0;
        double speed = 0.0;
        double maximum_speed = 0.0;
        for (int i = 1; i < x.length; i++) {
            delta_distance = x[i] - x[i - 1];
            speed = (3600 * delta_distance / s);
            maximum_speed = maximum_speed > speed ? maximum_speed : speed;
        }
        return (int) (maximum_speed);
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
