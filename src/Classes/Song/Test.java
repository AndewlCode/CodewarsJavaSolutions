package Classes.Song;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Song song = new Song("Mount Moose", "The Snazzy Moose");
        System.out.println(song.howMany(new ArrayList<String>(Arrays.asList("John", "Fred", "BOb", "carl", "RyAn"))));
        System.out.println(song.howMany(new ArrayList<String>(Arrays.asList("JoHn", "Luke", "AmAndA"))));
    }
}
