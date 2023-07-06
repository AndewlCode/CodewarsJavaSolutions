

public class Kyu4 {
    public static void main(String[] args) {

    }

    public static String add(String a, String b) {
        if (a.startsWith("0")) {
            a = a.substring(1, a.length());
        }
        if (b.startsWith("0")) {
            b = b.substring(1, b.length());
        }
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digitA = i >= 0 ? Character.getNumericValue(a.charAt(i)) : 0;
            int digitB = j >= 0 ? Character.getNumericValue(b.charAt(j)) : 0;
            int sum = digitA + digitB + carry;
            carry = sum / 10;
            int digit = sum % 10;
            stringBuilder.insert(0, digit);
            i--;
            j--;
        }

        return stringBuilder.toString();
    }
}