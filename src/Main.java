import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

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