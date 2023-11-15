import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kyu6 {
    public static void main(String[] args) {

    }

    public static int[] DataReverse(int[] data) {
        // Create storage for bytes
        ArrayList<int[]> bytes = new ArrayList<>();

        // Put all bits from data to bytes storage
        int totalBytes = data.length / 8;
        for (int i = 0; i < totalBytes; i++) {
            bytes.add(Arrays.copyOfRange(data, i * 8, i * 8 + 8));
        }

        // Create output data with source data size
        int[] result = new int[0];

        // Put all bits from storage to result
        for (int i = 0; i < totalBytes; i++) {
            int[] tmp = Arrays.copyOfRange(bytes.get(bytes.size() - 1), 0, 8);
            System.arraycopy(tmp, 0, result, 0, 8);
            bytes.remove(bytes.size() - 1);
        }

        System.out.println(Arrays.toString(result));

        return result;
    }

    public static long digPow(int n, int p) {
        String str = String.valueOf(n);

        long sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int digit = Character.getNumericValue(str.charAt(i));
            sum += Math.pow(digit, p);
            p++;
        }

        double result = (double) sum / n;
        return (result == (long) result) ? (long) result : -1;
    }

    public static String high(String s) {
        String[] words = s.split(" ");
        HashMap<Integer, String> hashMap = new HashMap<>();

        for (String word : words) {
            // Calculate each word value
            int charSum = 0;
            for (int i = 0; i < word.length(); i++) {
                charSum += word.charAt(i) - 96;
            }
            // Put word value to HashMap if not exists
            if (!hashMap.containsKey(charSum)) {
                hashMap.put(charSum, word);
            }
        }
        // Return result
        return hashMap.get(Collections.max(hashMap.keySet()));
    }

    public static String encryptThis(String text) {
        String[] words = text.split("\\s");
        StringBuilder stringBuilder = new StringBuilder();
        if (words.length == 0) {
            return "";
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1) {
                int firstLetter = words[i].charAt(0);
                stringBuilder.append(firstLetter);
            } else if (words[i].length() == 2) {
                int firstLetter = words[i].charAt(0);
                char lastLetter = words[i].charAt(1);
                stringBuilder.append(firstLetter).append(lastLetter);
            } else if (words[i].length() > 2) {
                int firstLetter = words[i].charAt(0);
                char secondLetter = words[i].charAt(words[i].length() - 1);
                char lastLetter = words[i].charAt(1);
                String middleSubstring = words[i].substring(2, words[i].length() - 1);
                stringBuilder.append(firstLetter).append(secondLetter).append(middleSubstring).append(lastLetter);
            }
            words[i] = stringBuilder.toString();
            stringBuilder.setLength(0);
        }

        for (String s : words) {
            stringBuilder.append(s).append(" ");
        }

        return stringBuilder.toString().trim();
    }

    public static boolean validate(String n) {
        // Replace all spaces in string
        n = n.replaceAll("\\s", "");

        // Array for digits storage
        int[] digits = new int[n.length()];

        // Check String contains only numeric values
        for (int i = digits.length - 1; i >= 0; i--) {
            if (Character.isDigit(n.charAt(i))) {
                digits[i] = Integer.parseInt(String.valueOf(n.charAt(i)));
            } else {
                return false;
            }
        }

        // Calculate values
        for (int i = digits.length - 2; i >= 0; i -= 2) {
            int tmp = digits[i] * 2;
            if (tmp > 9) {
                tmp = tmp - 9;
            }
            digits[i] = tmp;
        }

        // Calculate array total sum;
        int totalSum = Arrays.stream(digits).sum();

        // Return result
        return totalSum % 10 == 0;
    }

    public static String[] rotate(String text) {
        String[] result = new String[text.length()];
        StringBuilder stringBuilder = new StringBuilder(text);
        for (int i = 0; i < text.length(); i++) {
            stringBuilder.append(stringBuilder.charAt(0))
                    .delete(0, 1);
            result[i] = stringBuilder.toString();
        }
        return result;
    }

    public static int[] sumParts(int[] ls) {
        int totalSum = Arrays.stream(ls).sum();
        int[] result = new int[ls.length + 1];
        int minuser = 0;
        for (int i = 0; i < ls.length; i++) {
            result[i] = totalSum - minuser;
            minuser += ls[i];
        }
        return result;
    }

    public static String cleanString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stringBuilder.append(s.charAt(i));
            } else {
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : lstOfArt) {
            String[] arr = s.split(" ");
            String key = arr[0];
            int value = Integer.parseInt(arr[1]);
            hashMap.put(key, value);
        }

        if (hashMap.size() == 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();

        String[] hashmapKeys = hashMap.keySet().toArray(new String[0]);
        for (String s : lstOf1stLetter) {
            int value = 0;
            for (String hashmapKey : hashmapKeys) {
                if (hashmapKey.startsWith(s)) {
                    value += hashMap.get(hashmapKey);
                }
            }
            stringBuilder.append("(").append(s).append(" : ").append(value).append(") - ");
        }

        if (stringBuilder.length() > 3) {
            stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
        }

        return stringBuilder.toString();
    }

    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        List<Integer> objectsLengths = new ArrayList<>();
        for (Object[] arrayOfArray : arrayOfArrays) {
            objectsLengths.add(arrayOfArray.length);
        }
        Collections.sort(objectsLengths);
        for (int i = 0; i < objectsLengths.size() - 1; i++) {
            if (objectsLengths.get(i + 1) - objectsLengths.get(i) > 1) {
                return objectsLengths.get(i) + 1;
            }
        }
        return 0;
    }

    public static String dashatize(int num) {
        int value = Math.abs(num);
        String strNumber = Integer.toString(value);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strNumber.length(); i++) {
            int currentDigit = Integer.parseInt(String.valueOf(strNumber.charAt(i)));
            if (currentDigit % 2 != 0) {
                stringBuilder.append("-").append(currentDigit).append("-");
            } else {
                stringBuilder.append(currentDigit);
            }
        }

        if (stringBuilder.charAt(0) == '-') {
            stringBuilder.deleteCharAt(0);
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1) == '-') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return stringBuilder.toString().replaceAll("--", "-");
    }

    public static boolean validPhoneNumber(String phoneNumber) {
        String regex = "[(]\\d{3}[)]\\s\\d{3}[-]\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static int findMissing(int[] numbers) {
        for (int i = 1; i < numbers.length - 1; i++) {
            int firstDelta = numbers[i] - numbers[i - 1];
            int secondDelta = numbers[i + 1] - numbers[i];
            if (firstDelta != secondDelta) {
                return (numbers[i + 1] + numbers[i - 1] - numbers[i]);
            }
        }
        return numbers[0];
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] sortArray(int[] array) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (int i : array) {
            if (i % 2 != 0) {
                oddNumbers.add(i);
            }
        }
        Collections.sort(oddNumbers);

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                array[i] = oddNumbers.get(0);
                oddNumbers.remove(0);
            }
        }
        return array;
    }

    public static String meeting(String s) {
        Map<String, String> friendMap = new HashMap<>();
        String[] parts = s.toUpperCase().split(";");

        for (String part : parts) {
            String[] stuData = part.split(":");
            String firstName = stuData[0].trim();
            String lastName = stuData[1].trim();
            friendMap.put(firstName, lastName);
        }

        String[] lastNames = new String[friendMap.size()];
        int startIndex = 0;
        for (String firstname : friendMap.keySet()) {
            lastNames[startIndex] = friendMap.get(firstname);
            startIndex++;
        }

        Arrays.sort(lastNames);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lastNames.length; i++) {
            stringBuilder.append("(").append(lastNames[i]).append(", ").append(friendMap.get(lastNames[i])).append(")");
            friendMap.remove(lastNames[i]);
        }

        return stringBuilder.toString();
    }

    public static String battle(String goodAmounts, String evilAmounts) {
        int[] goodPower = new int[]{1, 2, 3, 3, 4, 10};
        int[] evilPower = new int[]{1, 2, 2, 2, 3, 5, 10};
        int[] goodArmy = Arrays.stream(goodAmounts.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] evilArmy = Arrays.stream(evilAmounts.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int goodScope = 0;
        int evilScope = 0;
        for (int i = 0; i < goodPower.length; i++) {
            goodScope += goodPower[i] * goodArmy[i];
        }

        for (int i = 0; i < evilPower.length; i++) {
            evilScope += evilPower[i] * evilArmy[i];
        }

        return (goodScope > evilScope) ? "Battle Result: Good triumphs over Evil"
                : (goodScope == evilScope) ? "Battle Result: No victor on this battle field"
                : "Battle Result: Evil eradicates all trace of Good";
    }

    public static int[] parse(String data) {
        int value = 0; // start value
        char[] commands = data.toCharArray();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (char symbol : commands) {
            if (symbol == 'i') {
                value++;
            } else if (symbol == 'd') {
                value--;
            } else if (symbol == 's') {
                value *= value;
            } else if (symbol == 'o') {
                arrayList.add(value);
            }
        }
        return arrayList.stream().mapToInt(i -> i).toArray();
    }

    public static String camelCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = str.trim().split("\\s+");
        if (str.equals("")) {
            return str;
        } else {
            for (String word : words) {
                stringBuilder.append(word.toUpperCase().charAt(0)).append(word.substring(1));
            }
            return stringBuilder.toString();
        }
    }

    public static boolean isPrime(int num) {
        int dividers = 1;
        if (num <= 0) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    dividers++;
                    if (dividers > 2) {
                        return false;
                    }
                }
            }
        }
        return dividers == 2;
    }

    public static Map<Character, Integer> count(String str) {
        Map<Character, Integer> resultMap = new HashMap<>();
        char[] charArray = str.toCharArray();
        for (char symbol : charArray) {
            if (!resultMap.containsKey(symbol)) {
                resultMap.put(symbol, 1);
            } else {
                resultMap.put(symbol, resultMap.get(symbol) + 1);
            }
        }
        return resultMap;
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if (maxOccurrences == 0) {
            return new int[]{};
        } else {
            ArrayList<Integer> resultArrayList = new ArrayList<>();
            int resultArrayListIndex = 0;
            HashMap<Integer, Integer> elementCounter = new HashMap<>();
            for (int element : elements) {
                if (!elementCounter.containsKey(element)) {
                    elementCounter.put(element, 1);
                    resultArrayList.add(resultArrayListIndex, element);
                    resultArrayListIndex++;
                } else {
                    if (elementCounter.get(element) < maxOccurrences) {
                        resultArrayList.add(resultArrayListIndex, element);
                        elementCounter.put(element, elementCounter.get(element) + 1);
                        resultArrayListIndex++;
                    }
                }
            }
            return resultArrayList.stream().mapToInt(i -> i).toArray();
        }
    }

    public static boolean check(String sentence) {
        sentence = sentence.replaceAll(" ", "").toLowerCase();
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) > 64) {
                hashSet.add(sentence.charAt(i));
            }
        }
        return hashSet.size() == 26;
    }

    public static String[] solution(String s) {
        int chunkSize = 2;
        String[] result = s.split("(?<=\\G.{" + chunkSize + "})");
        if (result[result.length - 1].length() == 1) {
            result[result.length - 1] = result[result.length - 1] + "_";
        }
        return result;
    }

    public static class Kyu5 {
    }
}
