// https://www.codewars.com/kata/5bc7bb444be9774f100000c3/train/java

package Classes.Undone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VersionManager {
    private int[] currentVersion = new int[]{0, 0, 1}; // [0] - major, [1] - minor, [2] - patch
    private final ArrayList<int[]> previousVersions = new ArrayList<>();

    public VersionManager(String s) {
        List<String> parts = List.of(s.split("\\."));

        //"Error occured while parsing version!"
    }

    public void major() {
        previousVersions.add(currentVersion);
        this.currentVersion[0] = this.currentVersion[0] + 1;
        this.currentVersion[1] = 0;
        this.currentVersion[2] = 0;
    }

    public void minor() {
        previousVersions.add(currentVersion);
        this.currentVersion[1] = this.currentVersion[1] + 1;
        this.currentVersion[2] = 0;
    }

    public void patch() {
        previousVersions.add(currentVersion);
        this.currentVersion[2] = this.currentVersion[2] + 1;
    }

    public void rollback() throws Exception {
        if (previousVersions.size() == 0) {
            throw new Exception("Cannot rollback!");
        } else {
            this.currentVersion = Arrays.copyOf(previousVersions.get(0), 3);
        }
    }

    public String release() {
        return currentVersion[0] + "." + currentVersion[1] + "." + currentVersion[2];
    }
}

