import org.w3c.dom.css.Counter;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    }

    public static boolean validParentheses(String parens) {
        int count = 0;
        for (int i = 0; i < parens.length(); i++) {
            char c = parens.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    public static int stringToInt(char[] str) {
        int i = 0, number = 0;
        boolean isNegative = false;
        int len = str.length;
        if (str[0] == '-') {
            isNegative = true;
            i = 1;
        }
        while (i < len) {
            number *= 10;
            number += (str[i++] - '0');
        }
        if (isNegative)
            number = -number;
        return number;
    }


    public static boolean contains(char[] str, char[] substr) {
        if (str.length == 0 || substr.length == 0 || substr.length > str.length) {
            return false;
        } else {
            int substringIndex = 0;
            int counter = 0;
            for (int i = 0; i < str.length; i++) {
                for (int j = substringIndex; j < substr.length; j++) {
                    if (str[i] == substr[substringIndex]) {
                        counter++;
                        i++;
                        substringIndex++;
                        if (counter == substr.length) {
                            return true;
                        }
                    } else {
                        substringIndex = 0;
                        counter = 0;
                    }
                }
            }
        }
        return false;
    }
    static int stray(int[] numbers) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int num : numbers) {
            if (hashMap.containsKey(num)) {
                int currentValue = (int) hashMap.get(num);
                Integer newValue = currentValue + 1;
                hashMap.put(num, newValue);
            } else {
                hashMap.put(num, (Integer) 1);
            }
        }

        for (int num : numbers) {
            int value = (int) hashMap.get(num);
            if (value == 1) {
                return num;
            }
        }
        return 0;
    }

    public static String correct(String string) {
        return string.replaceAll("5", "S").replaceAll("0", "O").replaceAll("1", "I");
    }

    public static int findAverage(int[] nums) {
        int counter = 0;
        for (int num : nums) {
            counter += num;
        }
        return counter / nums.length;
    }

    public static int countBits(int n) {
        String str = Integer.toBinaryString(n);
        int bitsOne = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                bitsOne++;
            }
        }
        return bitsOne;
    }

    public static long numberOfDivisors(int n) {
        long counter = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static String shortcut(String input) {
        return input.replaceAll("[aeiou]", "");
    }

    public static int quarterOf(int month) {
        int[] quater = new int[]{0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        return quater[month];
    }

    public static List<Long> sumDigPow(long a, long b) {
        List<Long> list = new ArrayList<Long>();
        while (a <= b) {
            String s = String.valueOf(a);
            long numSum = 0;
            for (int i = 0; i < s.length(); i++) {
                int digit = Integer.parseInt(s.substring(i, i + 1));
                numSum += (long) Math.pow(digit, (i + 1));
            }
            if (Double.parseDouble(s) == numSum) {
                list.add(numSum);
            }
            a++;
        }
        return list;
    }

    public static boolean isPlural(float f) {
        return f == 1 ? false : true;
    }

    public static int recursiveFibonacci(int n) {
        if (n <= 2) {
            return n - 1;
        } else {
            return recursiveFibonacci((n - 1)) + recursiveFibonacci((n - 2));
        }
    }

    public static int iterFibonacci(int n) {
        int[] fibonacciArray = new int[n + 1];
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }
        return fibonacciArray[n - 1];
    }

    public static int recursiveFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * recursiveFactorial(n - 1);
        }
    }

    public static int iterFactorial(int n) {
        int multiplyResult = 1;
        for (int i = 1; i <= n; i++) {
            multiplyResult *= i;
        }
        return multiplyResult;
    }

    public static void stockBuy(int m, int[] array) {
        while (true) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (m == array[i] + array[j]) {
                        if (j < i) {
                            System.out.println(j + " " + i);
                            break;
                        }
                    }
                }
            }
            break;
        }
    }

    public static boolean perfectlyBalanced(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += array[j];
            }

            for (int j = i + 1; j < array.length; j++) {
                rightSum += array[j];
            }

            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    public static int sum1n(int a) {
        // Написать решение сюда ↓
        int sum = 0;
        if (a == 0) {
            return sum;
        } else {
            sum += a + sum1n(a - 1);
        }
        return sum;
    }

    public static int[] flattenAndSort(int[][] array) {
        int resultArrayLength = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                resultArrayLength++;
            }
        }

        int[] resultArray = new int[resultArrayLength];
        int resultArrayPosition = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                resultArray[resultArrayPosition] = array[i][j];
                resultArrayPosition++;
            }
        }

        Arrays.sort(resultArray);
        return resultArray;
    }

    public static String chromosomeCheck(String sperm) {
        return sperm.contains("Y") ? "Congratulations! You're going to have a son."
                : "Congratulations! You're going to have a daughter.";
    }

    public static int GetSum(int a, int b) {
        int[] fromTo = new int[]{a, b};
        Arrays.sort(fromTo);
        if (fromTo[0] == fromTo[1]) {
            return fromTo[0];
        } else {
            int sum = 0;
            for (int i = fromTo[0]; i <= fromTo[1]; i++) {
                sum += i;
            }
            return sum;
        }
    }

    static String encode(String word) {
        String lowerCasedWord = word.toLowerCase();

        // count letters repeats in word
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < lowerCasedWord.length(); i++) {
            char ch = lowerCasedWord.charAt(i);
            if (hashMap.containsKey(ch)) {
                Integer hashMapValue = hashMap.get(ch);
                hashMap.put(ch, hashMapValue + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }

        // create new string
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lowerCasedWord.length(); i++) {
            char ch = lowerCasedWord.charAt(i);
            Integer hashMapValue = hashMap.get(ch);
            if (hashMapValue > 1) {
                stringBuilder.append(')');
            } else {
                stringBuilder.append('(');
            }
        }

        return stringBuilder.toString();
    }

    public static boolean getXO(String str) {
        char[] ch = str.toLowerCase().toCharArray();

        int xCounter = 0;
        int oCounter = 0;
        int xoCounter = 0;

        for (char c : ch) {
            if (c == 'x') {
                xCounter++;
                xoCounter++;
            }
            if (c == 'o') {
                oCounter++;
                xoCounter++;
            }
        }

        if (xoCounter == 0) {
            return true;
        }
        if (xoCounter == str.length()) {
            if (xCounter == oCounter) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                stringBuilder.append("(");
            }
            if (i == 3) {
                stringBuilder.append(") ");
            }
            if (i == 6) {
                stringBuilder.append("-");
            }
            stringBuilder.append(numbers[i]);
        }

        return stringBuilder.toString();
    }

    public static String highAndLow(String numbers) {
        String[] stringValues = numbers.split(" ");
        Integer[] integers = new Integer[stringValues.length];
        for (int i = 0; i < stringValues.length; i++) {
            integers[i] = Integer.parseInt(stringValues[i]);
        }
        Arrays.sort(integers);
        return integers[integers.length - 1].toString() + " " + integers[0].toString();
    }

    public static String toAlternativeString(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (Character.isUpperCase(ch)) {
                stringBuilder.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                stringBuilder.append(Character.toUpperCase(ch));
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public static char getGrade(int s1, int s2, int s3) {
        double averageValue = (s1 + s2 + s3) / 3;
        if (averageValue >= 90 && averageValue <= 100) {
            return 'A';
        } else if (averageValue >= 80 && averageValue < 90) {
            return 'B';
        } else if (averageValue >= 70 && averageValue < 80) {
            return 'C';
        } else if (averageValue >= 60 && averageValue < 70) {
            return 'D';
        } else
            return 'F';
    }

    public static int[] pipeFix(int[] numbers) {
        Arrays.sort(numbers);
        int minValue = numbers[0];
        int maxValue = numbers[numbers.length - 1];
        int resultArraySize = maxValue - minValue + 1;

        int[] resultArray = new int[resultArraySize];
        for (int i = 0; i < resultArraySize; i++) {
            resultArray[i] = minValue;
            minValue++;
        }

        return resultArray;
    }

    /*
     * public static boolean isAnagram(String test, String original) {
     * if (test.length() != original.length()) {
     * return false;
     * }
     *
     * String testString = new String(test).toLowerCase();
     * String originalString = new String(original).toLowerCase();
     *
     * for (int i = 0; i < testString.length(); i++) {
     * if (!test.contains(originalString.substring(i, i + 1))) {
     * return false;
     * }
     * }
     * return true;
     * }
     */

    public static int areaOrPerimeter(int l, int w) {
        return (l == w) ? l * w : 2 * l + 2 * w;
    }

    public static int countPassengers(ArrayList<int[]> stops) {
        ArrayList<int[]> arrayList = stops;
        int counter = 0;
        for (int[] ints : arrayList) {
            int delta = ints[0] - ints[1];
            counter += delta;
        }
        return counter;
    }

    public static String hoopCount(int n) {
        return (n >= 10) ? "Great, now move on to tricks" : "Keep at it until you get it";
    }

    public static String smash(String... words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(word).append(" ");
        }
        if (stringBuilder.length() > 1) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return stringBuilder.toString();
    }

    public static double findUniq(double arr[]) {

        TreeSet<Double> treeSet = new TreeSet<>();
        for (double v : arr) {
            treeSet.add(v);
        }

        int firstCounter = 0;
        int secondCounter = 0;

        for (double v : arr) {
            if (v == treeSet.first()) {
                firstCounter++;
            } else {
                secondCounter++;
            }
        }

        if (firstCounter > secondCounter) {
            return treeSet.last();
        } else
            return treeSet.first();

    }

    public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
        int[] allPoints = new int[classPoints.length + 1];

        System.arraycopy(classPoints, 0, allPoints, 0, classPoints.length);
        allPoints[allPoints.length - 1] = yourPoints;

        int totalSum = 0;
        for (int allPoint : allPoints) {
            totalSum += allPoint;
        }

        int average = totalSum / allPoints.length;

        return yourPoints > average;
    }

    public static String order(String words) {
        if (words.length() == 0) {
            return "-1";
        } else {

            String[] wordList = words.split(" ");
            HashMap<Integer, String> hashMap = new HashMap<>();

            for (String s : wordList) {
                for (int i = 0; i < s.length(); i++) {
                    if (Character.isDigit(s.charAt(i))) {
                        Integer index = Integer.parseInt(String.valueOf(s.charAt(i)));
                        hashMap.put(index, s);
                    }
                }
            }

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 1; i <= hashMap.size(); i++) {
                stringBuilder.append(hashMap.get(i)).append(" ");
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            return stringBuilder.toString();
        }
    }

    public static int squareDigits(int n) {
        String number = Integer.toString(n);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(number.charAt(i)));
            stringBuilder.append(digit * digit);
        }
        int result = Integer.parseInt(stringBuilder.toString());
        return result;
    }

    public static String oddOrEven(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return (sum % 2 == 0) ? "even" : "odd";
        // return stream(array).sum() % 2 == 0 ? "even" : "odd";
    }

    public static int cockroachSpeed(double x) {
        double kph = 27.777777777778;
        return (int) (kph * x);
    }

    public static String high(String s) {
        String[] words = s.split(" ");
        double[] wordValues = new double[words.length];

        for (int i = 0; i < words.length; i++) {
            double charSum = 0;
            for (int j = 0; j < words[i].length(); j++) {
                char character = words[i].charAt(j);
                double ascii = (int) character;
                charSum += ascii;
            }
            wordValues[i] = charSum;
        }

        int maxValueWord = (int) wordValues[0];
        int indexOfMaxValueWord = 0;
        for (int i = 0; i < wordValues.length; i++) {
            if (maxValueWord < wordValues[i]) {
                maxValueWord = (int) wordValues[i];
                indexOfMaxValueWord = i;
            }
        }
        return words[indexOfMaxValueWord];
    }

    public static boolean isPalindrome(char[] str1) {
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] != str1[str1.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram(char[] str1, char[] str2) {
        if (str1.length == str2.length) {
            for (int j = 0; j < str1.length; j++) {
                for (int i = 0; i < str2.length; i++) {
                    if (str2[i] == str1[j]) {
                        str2[i] = ' ';
                        str1[j] = ' ';
                    }
                }
            }
            for (char c : str2) {
                if (c != ' ') {
                    return false;
                }
            }
            for (char c : str1) {
                if (c != ' ') {
                    return false;
                }
            }
        } else
            return false;
        return true;
    }

    public static char[] concat(char[] str1, char[] str2) {
        char[] result = new char[str1.length + str2.length];

        for (int i = 0; i < str1.length; i++) {
            result[i] = str1[i];
        }

        for (int i = 0; i < str2.length; i++) {
            result[i + str1.length] = str2[i];
        }

        return result;
    }

    public static void toUpperCase(char[] str) {
        for (int i = 0; i < str.length; i++) {
            str[i] = Character.toUpperCase(str[i]);
        }
    }

    public static void toLowerCase(char[] str) {
        for (int i = 0; i < str.length; i++) {
            str[i] = Character.toLowerCase(str[i]);
        }
    }

    public static int strlen(char[] word) {
        return word.length;
    }

    public static boolean isLetterOrDigit(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57);
    }

    public static boolean isLetter(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    public static boolean isUpper(char c) {
        return Character.isUpperCase(c);
    }

    public static boolean isWhitespace(char c) {
        return c == ' ' || c == '\n' || c == '\t';
    }

    public static int iterPrime(int n) {
        int countPrimeNums = n + 1;
        int[] primeNum = new int[countPrimeNums];
        int indexSecond = 2;
        primeNum[indexSecond] = 3;
        int corrInd = indexSecond;
        int corrNum = primeNum[corrInd] + 2;
        boolean isPrime;
        while (corrInd < primeNum.length - 1) {
            isPrime = true;
            for (int i = 2; i < corrInd; i++) {
                if (corrNum % primeNum[i] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                corrInd++;
                primeNum[corrInd] = corrNum;
                corrNum = primeNum[corrInd] + 2;
            } else
                corrNum += 2;
        }
        return primeNum[primeNum.length - 1];
    }

    public static void recursiveReversePrint(char[] c, int k) {
        if (k == 0) {
            return;
        } else {
            System.out.print(c[k - 1]);
            recursiveReversePrint(c, k - 1);
        }
    }

    public static boolean iterIsPrime(int n) {
        if (n <= 0) {
            return false;
        } else {
            int isPrimeCounter = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    isPrimeCounter++;
                }
            }
            return isPrimeCounter == 2;
        }
    }

    public static int recursivePow(int a, int b) {
        if (b == 0) {
            return 1;
        } else {
            return a * recursivePow(a, (b - 1));
        }
    }

    public static String removeParentheses(String str) {
        String regex = "\\(.+\\)";
        return str.replaceAll(regex, "");
    }

    public static String whoLikesIt(String... names) {
        StringBuilder stringBuilder = new StringBuilder();
        if (names.length == 0) {
            stringBuilder.append("no one likes this");
        } else if (names.length == 1) {
            stringBuilder.append(names[0]);
            stringBuilder.append(" likes this");
        } else if (names.length == 2) {
            stringBuilder.append(names[0]);
            stringBuilder.append(" and ");
            stringBuilder.append(names[1]);
            stringBuilder.append(" like this");
        } else if (names.length == 3) {
            stringBuilder.append(names[0]);
            stringBuilder.append(", ");
            stringBuilder.append(names[1]);
            stringBuilder.append(" and ");
            stringBuilder.append(names[2]);
            stringBuilder.append(" like this");
        } else {
            stringBuilder.append(names[0]);
            stringBuilder.append(", ");
            stringBuilder.append(names[1]);
            stringBuilder.append(" and ");
            stringBuilder.append(names.length - 2);
            stringBuilder.append(" others like this");
        }
        return stringBuilder.toString();
    }

    public static boolean isValid(char[] walk) {
        int northCounter = 0;
        int southCounter = 0;
        int eastCounter = 0;
        int westCounter = 0;
        for (char direction : walk) {
            if (direction == 'n') {
                northCounter++;
            }
            if (direction == 's') {
                southCounter++;
            }
            if (direction == 'e') {
                eastCounter++;
            }
            if (direction == 'w') {
                westCounter++;
            }
        }

        return ((northCounter - southCounter == 0) && (eastCounter - westCounter == 0) && walk.length == 10);
    }

    public static int[][] multiplicationTable(int n) {
        int[][] result = new int[n][n];
        // Add first row and columns values
        for (int i = 0; i < n; i++) {
            result[0][i] = i + 1;
            for (int j = 0; j < n; j++) {
                result[i][0] = i + 1;
            }
        }

        // Multiply rows and columns
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = result[0][i] * result[0][j];
            }
        }
        return result;
    }

    public static int digital_root(int n) {
        int value = n;
        if (n >= 10) {
            int result = 0;
            String number = Integer.toString(n);
            int[] digits = new int[number.length()];
            for (int i = 0; i < number.length(); i++) {
                digits[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
            }
            for (int digit : digits) {
                result += digit;
            }
            return result = digital_root(result);
        } else
            return value;
    }

    public static String abbrevName(String name) {
        String[] nameSurname = name.toUpperCase().split(" ");
        return nameSurname[0].charAt(0) + "." + nameSurname[1].charAt(0);
    }

    public static int findIt(int[] a) {
        // Add all unique numbers to HashSet
        HashSet<Integer> uniqeValues = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            uniqeValues.add(a[i]);
        }

        // Count all unique numbers in array int[a]
        HashMap<Integer, Integer> hashMap = new HashMap();
        int counter = 0;
        for (Integer uniqeValue : uniqeValues) {
            for (int i = 0; i < a.length; i++) {
                if (uniqeValue == Integer.valueOf(a[i])) {
                    counter++;
                }
            }
            hashMap.put(uniqeValue, counter);
            counter = 0;
        }

        // Which value is odd
        for (Integer uniqueValue : uniqeValues) {
            if (hashMap.get(uniqueValue) % 2 == 1) {
                return uniqueValue;
            }
        }

        return -1;
    }

    public static String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder wordBuilder = new StringBuilder();
        StringBuilder resultBuilder = new StringBuilder();

        for (String word : words) {
            if (word.length() < 5) {
                resultBuilder.append(wordBuilder.append(word).append(" "));
                wordBuilder.setLength(0);
            }
            if (word.length() >= 5) {
                resultBuilder.append(wordBuilder.append(word).reverse().append(" "));
                wordBuilder.setLength(0);
            }
        }
        resultBuilder.delete(resultBuilder.length() - 1, resultBuilder.length());

        return resultBuilder.toString();
    }

    public static String replace(final String s) {
        return s.replaceAll("[aeiouAEIOU]", "!");
    }

    public static List<String> number(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(lines.get(i));
            stringBuilder.insert(0, (i + 1) + ": ");
            lines.set(i, stringBuilder.toString());
        }
        return lines;
    }

    public static int duplicateCount(String text) {
        String normalisedText = text.toLowerCase();
        char[] chars = normalisedText.toCharArray();

        List<Character> characterList = new ArrayList<>();
        HashSet<Character> uniqueCharacterHashSet = new HashSet<>();

        for (char aChar : chars) {
            characterList.add(aChar);
            uniqueCharacterHashSet.add(aChar);
        }

        for (Character character : uniqueCharacterHashSet) {
            characterList.remove(character);
        }

        HashSet<Character> resultCharacterHashSet = new HashSet<>();
        for (Character character : characterList) {
            resultCharacterHashSet.add(character);
        }

        return resultCharacterHashSet.size();
    }

    public static double find_average(int[] array) {
        return Arrays.stream(array).mapToDouble(d -> d).average().orElse(0);
    }

    public static int solution(int number) {
        if (number > 0) {
            int sum = 0;
            for (int i = 0; i < number; i++) {
                if (i % 3 == 0 || i % 5 == 0) {
                    sum += i;
                }
            }
            return sum;
        } else {
            return -1;
        }
    }

    public static long findNextSquare(long sq) {
        long inputValueSqrt = (long) Math.sqrt(sq);
        if (Math.pow(inputValueSqrt, 2) == sq) {
            return (long) Math.pow(Math.sqrt(sq) + 1, 2);
        } else {
            return -1;
        }
    }

    public static List<Object> filterList(final List<Object> list) {
        /*
         * ArrayList<Object> arrayList = new ArrayList<Object>();
         * for (Object o : list) {
         * if (o instanceof Integer) {
         * arrayList.add(o);
         * }
         * }
         * return arrayList;
         */
        return list.stream().filter(o -> o instanceof Integer).collect(Collectors.toList());
    }

    public static int rentalCarCost(int d) {
        int dayRentCost = 40;
        int totalCost = 0;
        if (d < 3) {
            totalCost = dayRentCost * d;
        }
        if (d >= 3 && d < 7) {
            totalCost = dayRentCost * d - 20;
        }
        if (d >= 7) {
            totalCost = dayRentCost * d - 50;
        }

        return totalCost;
    }

    public static int[] countPositivesSumNegatives(int[] input) {
        // Check Array is not null
        if (input == null || input.length == 0) {
            return new int[]{};
        }

        // Check result
        int positiveCounter = 0;
        int negativeSum = 0;

        for (int i : input) {
            if (i > 0) {
                positiveCounter++;
            }
            if (i < 0) {
                negativeSum += i;
            }
        }
        return new int[]{positiveCounter, negativeSum};
    }

    public static String remove(String str) {

        return str.substring(1, str.length() - 1);
    }

    public static int nbDig(int n, int d) {
        int[] array = new int[n + 1];

        for (int i = 0; i < array.length; i++) {
            array[i] = i * i;
        }

        String str = Arrays.toString(array);
        String regex = String.valueOf(d);

        Matcher matcher = Pattern.compile(regex).matcher(str);

        int counter = 0;
        while (matcher.find()) {
            counter++;
        }

        return counter;
    }

    public static int sortDesc(final int num) {
        String number = String.valueOf(num);
        Integer[] array = new Integer[number.length()];

        for (int i = 0; i < number.length(); i++) {
            array[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
        }

        Arrays.sort(array, Collections.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();

        for (Integer integer : array) {
            stringBuilder.append(integer);
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    public static int[] reverse(int n) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = n;
            n--;
        }
        return array;
    }

    public static int[] map(int[] arr) {
        return Arrays.stream(arr).map(value -> value *= 2).toArray();
    }

    public static String fakeBin(String numberString) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberString.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(numberString.charAt(i)));
            if (digit < 5) {
                stringBuilder.append(0);
            } else {
                stringBuilder.append(1);
            }
        }
        return stringBuilder.toString();
    }

    public static String getMiddle(String word) {

        String s = String.valueOf(word.charAt(word.length() / 2));
        if (word.length() % 2 == 1) {
            return s;
        } else {
            return word.charAt(word.length() / 2 - 1) + s;
        }
    }

    public static int opposite(int number) {
        return number * -1;
    }

    public static boolean checkForFactor(int base, int factor) {
        int factor2 = base / factor;
        return factor2 * factor == base;
    }

    public static int expressionsMatter(int a, int b, int c) {
        int[] values = new int[4];
        values[0] = a + b + c;
        values[1] = a * (b + c);
        values[2] = (a + b) * c;
        values[3] = a * b * c;
        Arrays.sort(values);
        return values[values.length - 1];
    }

    public static String howMuchILoveYou(int nb_petals) {
        String[] strings = {"I love you", "a little", "a lot", "passionately", "madly", "not at all"};

        if (nb_petals <= 6) {
            return strings[nb_petals - 1];
        } else {
            int val = nb_petals % 6 - 1;
            return strings[val];
        }
    }

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        double sum = 0;
        for (int i = 0; i < binary.size(); i++) {
            if (binary.get(i) == 1) {
                sum += Math.pow(2, (binary.size() - i - 1));
            }
        }
        return (int) sum;
    }

    public static int findEvenIndex(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            int leftSum = 0;
            for (int j = 0; j < index; j++) {
                leftSum += arr[j];
            }
            int rightSum = 0;
            for (int i = index + 1; i < arr.length; i++) {
                rightSum += arr[i];
            }
            if (rightSum == leftSum) {
                return index;
            }
        }
        return -1;
    }

    public static String[] wave(String str) {
        String upperCaseString = str.toUpperCase();
        String[] resultArray = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char upperCaseChar = upperCaseString.charAt(i);
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.replace(i, i + 1, String.valueOf(upperCaseChar));
            resultArray[i] = stringBuilder.toString();
            stringBuilder.setLength(0);
        }
        return resultArray;
    }

    public static int move(int position, int roll) {
        return position + roll * 2;
    }

    public static int[] minMax(int[] arr) {
        int minValue = Arrays.stream(arr).min().getAsInt();
        int maxValue = Arrays.stream(arr).max().getAsInt();
        return new int[]{minValue, maxValue};
    }

    public static int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }

    public static String[] stringToArray(String s) {
        String[] strings = s.split(" ");
        return strings;
    }

    public static Integer find(final int[] array) {
        int startValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == startValue) {
                startValue++;
            } else
                return array[i];
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
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
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

    // public static String updateLight(String current) {
    // return switch (current) {
    // case "green" -> "yellow";
    // case "yellow" -> "red";
    // case "red" -> "green";
    // default -> throw new IllegalArgumentException();
    // };
    // }

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
        return dna.replaceAll("T", "-").replaceAll("U", "T").replaceAll("-", "U");
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

        String result = chars.toString().replace(",", "").replace("[", "").replace("]", "").replaceAll("\\s", "");

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

    // public static Integer basicMath(String op, int v1, int v2) {
    // int result = switch (op) {
    // case "+" -> v1 + v2;
    // case "-" -> v1 - v2;
    // case "*" -> v1 * v2;
    // case "/" -> v1 / v2;
    // default -> 0;
    // };
    // return result;
    // }

    public static boolean check(Object[] a, Object x) {
        boolean checkResult = false;
        for (Object checkedObject : a) {
            if (checkedObject.equals(x)) {
                checkResult = true;
                break;
            } else
                checkResult = false;
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
        } else
            return "No";
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