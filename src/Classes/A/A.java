package Classes.A;

public class A {
    public static int counter = 1;

    public static int getNumber() {
        int currentValue = A.counter;
        A.counter = A.counter * 2;
        return currentValue;
    }

}