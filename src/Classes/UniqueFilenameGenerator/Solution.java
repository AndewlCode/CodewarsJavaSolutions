// https://www.codewars.com/kata/586a933fc66d187b6e00031a/train/java

package Classes.UniqueFilenameGenerator;

import java.util.Random;
public class Solution {
    public static String generateName(PhotoManager photoManager) {
        int filenameLength = 6;
        StringBuilder filename = new StringBuilder(filenameLength);
        Random random = new Random();

        do {
            filename.setLength(0);
            for (int i = 0; i < filenameLength; i++) {
                String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                filename.append(capitalChars.charAt(random.nextInt(capitalChars.length())));
            }
        } while (photoManager.nameExists(filename.toString()));

        return filename.toString();
    }
}