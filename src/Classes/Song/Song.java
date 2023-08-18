// https://www.codewars.com/kata/6089c7992df556001253ba7d/solutions/java
package Classes.Song;

import java.util.ArrayList;
import java.util.HashSet;

public class Song {
    private final String songTitle;
    private final String songArtist;
    private final HashSet<String> listenersHashSet;

    public Song(String songTitle, String songArtist) {
        this.songTitle = songTitle;
        this.songArtist = songArtist;
        this.listenersHashSet = new HashSet<>();
    }

    public String getTitle() {
        return this.songTitle;
    }

    public String getArtist() {
        return this.songArtist;
    }

    public int howMany(ArrayList<String> listenersList) {
        int previousListenersSize = this.listenersHashSet.size();
        for (String s : listenersList) {
            this.listenersHashSet.add(s.toLowerCase());
        }
        int currentListenersSize = this.listenersHashSet.size();
        return currentListenersSize - previousListenersSize;
    }
}
