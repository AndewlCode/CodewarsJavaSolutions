public class Kyu7 {


    public static void main(String[] args) {
        int seconds = 15;
        double[] x = new double[]{0.0, 0.19, 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0, 2.25};
        System.out.println(gps(seconds, x));
    }

    public static int gps(int s, double[] x) {
        double deltaDistance;
        double speed;
        double maximumSpeed = 0.0;
        for (int i = 1; i < x.length; i++) {
            deltaDistance = x[i] - x[i - 1];
            speed = (3600 * deltaDistance / s);
            maximumSpeed = maximumSpeed > speed ? maximumSpeed : speed;
        }
        return (int) (maximumSpeed);
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
        int minValue = numbers[0];
        int minValueIndex = 0;

        // get minimum value and minimum value index.
        for (int i = 0; i < numbers.length; i++) {
            if (minValue > numbers[i]) {
                minValue = numbers[i];
                minValueIndex = i;
            }
        }
        // copy given array to new array without minimum value.
        System.arraycopy(numbers, 0, result, 0, minValueIndex);
        System.arraycopy(numbers, minValueIndex + 1, result, minValueIndex, result.length - minValueIndex);
        return result;
    }

}
