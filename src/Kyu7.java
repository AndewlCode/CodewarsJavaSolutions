import java.util.Arrays;

public class Kyu7 {


    public static void main(String[] args) {
    }

    public static String switcheroo(String x) {
        return x.replaceAll("a","_").replaceAll("b","a").replaceAll("_","b");
    }
}
