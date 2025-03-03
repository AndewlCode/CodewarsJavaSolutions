import java.util.HashMap;
import java.util.List;

public class Kyu7 {


    public static void main(String[] args) {
        System.out.println(sortMyString("CodeWars"));

    }

    public static String sortMyString(String s) {
        StringBuilder evenStringBoulder = new StringBuilder();
        StringBuilder oddStringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                evenStringBoulder.append(s.charAt(i));
            } else {
                oddStringBuilder.append(s.charAt(i));
            }
        }
        evenStringBoulder.append(" ").append(oddStringBuilder);
        return evenStringBoulder.toString();
    }

    public static List<String> friend(List<String> x) {
        return x.stream()
                .filter(str -> str.length() == 4)
                .toList();
    }

    public static long filterString(final String value) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars;
        long result;
        chars = value.toCharArray();
        for (char everyChar : chars) {
            if (Character.isDigit(everyChar)) {
                stringBuilder.append(everyChar);
            }
        }
        if (stringBuilder.isEmpty()) {
            result = -1;
        } else result = Long.parseLong(stringBuilder.toString());
        return result;
    }

    public static String alphabetWar(String fight) {
        char[] allChars = fight.toCharArray();
        HashMap<Character, Integer> leftSideLetters = new HashMap<>();
        HashMap<Character, Integer> rightSideLetters = new HashMap<>();

        // Left side initialization
        leftSideLetters.put('w', 4);
        leftSideLetters.put('p', 3);
        leftSideLetters.put('b', 2);
        leftSideLetters.put('s', 1);

        // Right side initialization
        rightSideLetters.put('m', 4);
        rightSideLetters.put('q', 3);
        rightSideLetters.put('d', 2);
        rightSideLetters.put('z', 1);

        Integer leftSideScore = 0;
        Integer rightSideScore = 0;

        for (char anyChar : allChars) {
            leftSideScore += leftSideLetters.getOrDefault(anyChar, 0);
            rightSideScore += rightSideLetters.getOrDefault(anyChar, 0);
        }
        if (leftSideScore.equals(rightSideScore)) {
            return "Let's fight again!";
        } else if (leftSideScore > rightSideScore) {
            return "Left side wins!";
        } else return "Right side wins!";
    }

    public static int gps(int s, double[] x) {
        double deltaDistance;
        double speed;
        double maximumSpeed = 0.0;
        for (int i = 1; i < x.length; i++) {
            deltaDistance = x[i] - x[i - 1];
            speed = (3600 * deltaDistance / s);
            maximumSpeed = Math.max(maximumSpeed, speed);
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
