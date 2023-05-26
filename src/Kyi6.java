import java.util.*;

public class Kyi6 {
    public static void main(String[] args) {

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
            stringBuilder.append("(")
                    .append(lastNames[i])
                    .append(", ")
                    .append(friendMap.get(lastNames[i]))
                    .append(")");
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

        return (goodScope > evilScope) ? "Battle Result: Good triumphs over Evil" :
                (goodScope == evilScope) ? "Battle Result: No victor on this battle field" :
                        "Battle Result: Evil eradicates all trace of Good";
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
}
