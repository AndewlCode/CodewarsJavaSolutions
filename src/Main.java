import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }
    public static String[] stringToArray(String s) {
        String [] strings = s.split(" ");
        return strings;
    }

    public static Integer find(final int[] array) {
        int startValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == startValue) {
                startValue++;
            } else return array[i];
        }
        return null;
    }

    public static int strCount(String str, char letter) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == letter) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean setAlarm(boolean employed, boolean vacation) {
        return !(!employed || vacation);
    }

    public static int min(int[] list) {
        int minValue = list[0];
        for (int i : list) {
            if (i < minValue) {
                minValue = i;
            }
        }
        return minValue;
    }

    public static int max(int[] list) {
        int maxValue = list[0];
        for (int i : list) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    public static String countingSheep(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            stringBuilder.append(i).append(" sheep...");
        }
        return stringBuilder.toString();
    }


    public static int summation(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static String camelCase(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                stringBuilder.append(" ").append(input.charAt(i));
            } else {
                stringBuilder.append(input.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static int liters(double time) {
        return (int) (time * 0.5);
    }

    public static String noSpace(final String x) {
        return x.replaceAll("\s", "");
    }

    public static String accum(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.toUpperCase().charAt(i));
            int innerCounter = 1;

            for (innerCounter = 1; innerCounter < i + 1; innerCounter++) {
                stringBuilder.append(s.toLowerCase().charAt(i));
            }
            stringBuilder.append("-");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public static String greet(String name) {
        return "Hello, " + name + " how are you doing today?";
    }

    public static boolean isIsogram(String str) {
        HashSet hashSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            hashSet.add(str.toLowerCase().charAt(i));
        }
        return hashSet.size() == str.length();
    }

    public static int getCount(String str) {
        int vowelsCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                vowelsCounter++;
            }
        }
        return vowelsCounter;
    }

    public static String even_or_odd(int number) {
        return (number % 2 == 0) ? "Even" : "Odd";
    }

    public static int persistence(long n) {
        String number = String.valueOf(Long.valueOf(n));
        int counter = 0;
        while (number.length() > 1) {
            int[] digits = new int[number.length()];
            for (int i = 0; i < digits.length; i++) {
                digits[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
            }
            int multiplication = 1;
            for (int i = 0; i < digits.length; i++) {
                multiplication *= digits[i];
            }
            number = String.valueOf(multiplication);
            counter++;
        }
        return counter;
    }

    public static String reverseWords(final String original) {

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder resultStringBuilder = new StringBuilder();

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != ' ') {
                stringBuilder.append(original.charAt(i));
            } else {
                resultStringBuilder.append(stringBuilder.reverse());
                resultStringBuilder.append(" ");
                stringBuilder.setLength(0);
            }
        }
        resultStringBuilder.append(stringBuilder.reverse());

        return resultStringBuilder.toString();
    }

    public static int[] invert(int[] array) {
        if (array.length == 0) {
            return new int[0];
        } else {
            int[] reversedArray = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                reversedArray[i] = array[i] * (-1);
            }
            return reversedArray;
        }
    }

    public static String updateLight(String current) {
        return switch (current) {
            case "green" -> "yellow";
            case "yellow" -> "red";
            case "red" -> "green";
            default -> throw new IllegalArgumentException();
        };
    }

    public static int simpleMultiplication(int n) {
        return (n % 2 == 0) ? n * 8 : n * 9;
    }

    public class MixedSum {
        /*
         * Assume input will be only of Integer o String type
         */
        public int sum(List<?> mixed) {
            int sum = 0;
            for (Object o : mixed) {
                sum += Integer.parseInt(o.toString());
            }
            return sum;
        }
    }

    public static String areYouPlayingBanjo(String name) {
        if (name.toLowerCase().startsWith("r")) {
            return name + " plays banjo";
        } else {
            return name + " does not play banjo";
        }
    }

    public static int grow(int[] x) {
        int mult = 1;
        for (int i : x) {
            mult *= i;
        }
        return mult;
    }

    public static String removeExclamationMarks(String s) {
        return s.replaceAll("!", "");
    }


    public static boolean isTriangle(int a, int b, int c) {
        return ((c < a + b) && (b < a + c) && (a < b + c)) == true ? true : false;
    }

    public static boolean isSquare(int n) {
        return (Math.sqrt(n) % 1 == 0) ? true : false;
    }

    static String greet(String name, String owner) {
        return (name.equals(owner)) ? "Hello boss" : "Hello guest";
    }

    public static int paperWork(int n, int m) {
        return (n < 0 || m < 0) ? 0 : m * n;
    }

    public static int findSmallestInt(int[] args) {
        int minValue = args[0];

        for (int arg : args) {
            if (minValue > arg) {
                minValue = arg;
            }
        }
        return minValue;
    }

    public static String dnaToRna(String dna) {
        return dna.replaceAll("T", "-").
                replaceAll("U", "T").
                replaceAll("-", "U");
    }

    public static boolean isLove(final int flower1, final int flower2) {
        if (flower1 % 2 == 0 && flower2 % 2 == 1) {
            return true;
        } else if (flower1 % 2 == 1 && flower2 % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int findShort(String s) {
        String[] words = s.split("\s");
        int minWordLength = words[0].length();

        for (String word : words) {
            if (word.length() < minWordLength) {
                minWordLength = word.length();
            }
        }
        return minWordLength;
    }

    public static String binaryAddition(int a, int b) {
        return Integer.toBinaryString(a + b);
    }

    public static String bmi(double weight, double height) {
        double bmi = weight / (height * height);
        String result = "";
        if (bmi <= 18.5) {
            result = "Underweight";
        } else if (bmi <= 25.0) {
            result = "Normal";
        } else if (bmi <= 30.0) {
            result = "Overweight";
        } else if (bmi > 30) {
            result = "Obese";
        }
        return result;
    }

    public static int sum(int[] numbers) {

        if (numbers == null || numbers.length < 3) {
            return 0;
        }

        // minValue
        var minValue = numbers[0];
        for (int number : numbers) {
            if (number > minValue) {
                minValue = number;
            }
        }

        // maxValue
        var maxValue = numbers[0];
        for (int number : numbers) {
            if (number < maxValue) {
                maxValue = number;
            }
        }

        // totalSum
        var totalSum = 0;
        for (int number : numbers) {
            totalSum += number;
        }

        // resultSum
        return totalSum - minValue - maxValue;
    }

    public static int sum2(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            if (i >= 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int makeNegative(final int x) {
        return (x < 0 ? x : x * -1);
    }

    public static String longest(String s1, String s2) {
        String str = s1 + s2;

        TreeSet<Character> chars = new TreeSet<>();
        for (char c : str.toCharArray()) {
            chars.add(c);
        }

        String result = chars.toString().
                replace(",", "").
                replace("[", "").
                replace("]", "").
                replaceAll("\\s", "");

        return result;
    }

    public static boolean validatePin(String pin) {
        boolean value = false;
        if (pin.length() == 4 || pin.length() == 6) {
            char[] array = pin.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (!Character.isDigit(array[i])) {
                    value = false;
                    break;
                } else {
                    value = true;
                }
            }
        }
        return value;
    }

    public static int[] digitize(long n) {
        String longNumber = new String(Long.toString(n));
        StringBuilder stringBuilder = new StringBuilder(longNumber);
        String reverseNumber = String.valueOf(stringBuilder.reverse());
        char[] charArray = reverseNumber.toCharArray();
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(String.valueOf(charArray[i]));
        }
        return intArray;
    }

    public static String makeComplement(String dna) {

        char[] chars = dna.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A') {
                chars[i] = 'T';
            } else if (chars[i] == 'T') {
                chars[i] = 'A';
            } else if (chars[i] == 'C') {
                chars[i] = 'G';
            } else if (chars[i] == 'G') {
                chars[i] = 'C';
            }
        }

        return new String(chars);
    }

    public static int countSheeps(Boolean[] arrayOfSheeps) {
        int sheepCounter = 0;
        for (Boolean arrayOfSheep : arrayOfSheeps) {
            if (arrayOfSheep != null) {
                if (arrayOfSheep) {
                    sheepCounter++;
                }
            }
        }
        return sheepCounter;
    }

    public static String disemvowel(String str) {
    /*    return str.replace("a","").replace("A","")
                .replace("e", "").replace("E", "")
                .replace("i", "").replace("I", "")
                .replace("o","").replace("O","")
                .replace("u","").replace("U","");*/
        return str.replaceAll("[aAeEiIoOuU]", "");
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int sum(int value1, int value2, int value3) {
        return value1 + value2 + value3;
    }

    public static String rps(String p1, String p2) {
        String result = "";
        if (p1.equals("scissors")) {
            if (p2.equals("paper")) {
                result = "Player 1 won!";
            } else if (p2.equals("rock")) {
                result = "Player 2 won!";
            } else {
                result = "Draw!";
            }
        } else if (p1.equals("paper")) {
            if (p2.equals("rock")) {
                result = "Player 1 won!";
            } else if (p2.equals("scissors")) {
                result = "Player 2 won!";
            } else {
                result = "Draw!";
            }
        } else if (p1.equals("rock")) {
            if (p2.equals("scissors")) {
                result = "Player 1 won!";
            } else if (p2.equals("paper")) {
                result = "Player 2 won!";
            } else {
                result = "Draw!";
            }
        }
        return result;
    }

    public static int[] countBy(int a, int b) {
        int[] array = new int[b];
        int startValue = a;
        int stopValue = b;
        for (int i = 0; i < stopValue; i++) {
            array[i] = startValue;
            startValue = startValue + a;
        }
        return array;
    }

    public static Integer basicMath(String op, int v1, int v2) {
        int result = switch (op) {
            case "+" -> v1 + v2;
            case "-" -> v1 - v2;
            case "*" -> v1 * v2;
            case "/" -> v1 / v2;
            default -> 0;
        };
        return result;
    }

    public static boolean check(Object[] a, Object x) {
        boolean checkResult = false;
        for (Object checkedObject : a) {
            if (checkedObject.equals(x)) {
                checkResult = true;
                break;
            } else checkResult = false;
        }
        return checkResult;
    }

    public static int squareSum(int[] n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i] * n[i];
        }
        return sum;
    }

    public static String boolToWord(boolean b) {
        if (b) {
            return "Yes";
        } else return "No";
    }

    public static int Past(int h, int m, int s) {
        int hours = h * 60 * 60 * 1000;
        int minutes = m * 60 * 1000;
        int seconds = s * 1000;
        return hours + minutes + seconds;
    }

    public static boolean feast(String beast, String dish) {
        return beast.charAt(0) == dish.charAt(0) && beast.charAt(beast.length() - 1) == dish.charAt(dish.length() - 1);
    }

    public static double sum(double[] numbers) {
        if (numbers.length == 0) {
            return 0;
        } else {
            double arraySum = 0.0;
            for (double number : numbers) {
                arraySum += number;
            }
            return arraySum;
        }
    }

    public static String findNeedle(Object[] haystack) {
        return "found the needle at position " + Arrays.asList(haystack).indexOf("needle");
        /*String resultString = "";
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] != null) {
                if (haystack[i].equals("needle")) {
                    resultString = "found the needle at position " + i;
                }
            }
        }*/
    }

    public static String doubleChar(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i)).append(s.charAt(i));
        }
        return builder.toString();
    }

    public static boolean zeroFuel(double distanceToPump, double mpg, double fuelLeft) {
        return !(distanceToPump / mpg > fuelLeft);
    }

    public static int points(String[] games) {

        int score = 0;

        for (String game : games) {
            int firstTeamScore = Integer.parseInt(String.valueOf(game.charAt(0)));
            int secondTeamScore = Integer.parseInt(String.valueOf(game.charAt(2)));
            if (firstTeamScore > secondTeamScore) {
                score += 3;
            } else if (firstTeamScore < secondTeamScore) {
                score += 0;
            } else if (firstTeamScore == secondTeamScore) {
                score += 1;
            }
        }
        return score;
    }
}