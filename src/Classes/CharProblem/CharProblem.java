package Classes.CharProblem;

public class CharProblem {
    public static int howOld(final String herOld) {
        String[] words = herOld.split("\\s");
        return Integer.parseInt(words[0]);
    }
}