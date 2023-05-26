package Classes.Undone;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class Undone {
    public static String walk(String path) {
        char[] commands = new char[path.length()];
        if (commands.length == 0) {
            return "Paused";
        } else {

            for (int i = 0; i < commands.length; i++) {
                commands[i] = path.charAt(i);
            }

            StringBuilder stringBuilder = new StringBuilder();
            String direction = "";
            for (int i = 1; i < commands.length; i++) {
                int stepCounter = 1;

                if (commands[i - 1] != commands[i]) {
                    if (commands[i - 1] == '<') {
                        direction = "left\n";
                    }
                    if (commands[i - 1] == '>') {
                        direction = "right\n";
                    }
                    if (commands[i - 1] == 'v') {
                        direction = "down";
                    }
                    if (commands[i - 1] == '^') {
                        direction = "up";
                    }
                }

                stringBuilder.append("Take ").append(stepCounter).append(" steps ").append(direction).append("\n");
            }
            return stringBuilder.toString();
        }
    }

    public static String passwordCracker(String hash) {
        String sha1 = "";
        StringBuilder stringBuilder = new StringBuilder();

        //Generate 5-letter words
        for (int i = 97; i < 122; i++) {
            for (int j = 97; j < 122; j++) {
                for (int k = 97; k < 122; k++) {
                    for (int l = 97; l < 122; l++) {
                        for (int m = 97; m < 122; m++) {
                            stringBuilder.append((char) i).append((char) j).append((char) k).append((char) l).append((char) m);
                            String bruteWord = stringBuilder.toString();

                            try {
                                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                                digest.reset();
                                digest.update(bruteWord.getBytes("utf8"));
                                sha1 = String.format("%040x", new BigInteger(1, digest.digest()));

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            if (sha1.equalsIgnoreCase(hash)) {
                                return bruteWord;
                            } else {
                                stringBuilder.setLength(0);
                            }
                        }
                    }
                }
            }
        }
        return "Time is up";
    }

    public static char[] moreZeros(String s) {
        char[] inputArray = s.toCharArray();
        List<Character> characterArrayList = new ArrayList<>();
        for (char c : inputArray) {
            int numericValue = Integer.parseInt(Integer.toBinaryString(c));
            String text = String.valueOf(numericValue);

            int ones = 0;
            int zeroes = 0;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '0'){
                    zeroes++;
                }
                if (text.charAt(i) == '1'){
                    ones++;
                }
            }

            if (zeroes > ones){
                characterArrayList.add((char) c);
            }
        }

        char [] result = new char[characterArrayList.size()-1];

        for (int i = 0; i < characterArrayList.size()-1; i++) {
            result[i] = characterArrayList.get(i);
        }

        return result;
    }

    }