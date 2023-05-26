package Classes.Factorial;

public class Factorial {
    public int factorial(int n) throws IllegalArgumentException {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException();
        } else {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    }
}
