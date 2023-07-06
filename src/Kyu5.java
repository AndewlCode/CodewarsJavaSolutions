import java.awt.*;
import java.util.HashSet;

public class Kyu5 {
    public static void main(String[] args) {
        System.out.println(scramble("katas", "steak"));
        System.out.println(scramble("cat", "tac"));
    }

    public static boolean scramble(String str1, String str2) {
        int maxChar = 256;

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();

        if (charArr1.length < charArr2.length)
            return false;

        int[] count = new int[maxChar];
        for (char c : charArr1)
            count[c]++;

        for (char c : charArr2) {
            if (count[c] == 0)
                return false;
            count[c]--;
        }

        return true;



//        Slow solution
//        List<Character> str1Chars = str1.chars()
//                .mapToObj(e -> (char) e).collect(Collectors.toList());
//
//        for (int i = 0; i < str2.length(); i++) {
//            if (str1Chars.contains(Character.valueOf(str2.charAt(i)))) {
//                str1Chars.remove(Character.valueOf(str2.charAt(i)));
//            } else {
//                return false;
//            }
//        }
//        return true;
    }


    public static String rgb(int r, int g, int b) {
        // Check too big values
        if (r > 255) {
            r = 255;
        }
        if (g > 255) {
            g = 255;
        }
        if (b > 255) {
            b = 255;
        }

        // Check too small values
        if (r < 0) {
            r = 0;
        }
        if (g < 0) {
            g = 0;
        }
        if (b < 0) {
            b = 0;
        }

        // Calculate color and generate text String
        Color color = new Color(r, g, b);
        return Integer.toHexString(color.getRGB()).substring(2).toUpperCase();
    }
}
