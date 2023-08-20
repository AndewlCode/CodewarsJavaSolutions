// https://www.codewars.com/kata/5bc7bb444be9774f100000c3/train/java

package Classes.VersionManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VersionManager {
    private int[] currentVersion = new int[]{0, 0, 1}; // [0] - major, [1] - minor, [2] - patch
    private final ArrayList<int[]> previousVersions = new ArrayList<>();

    public VersionManager(String s) throws Exception {
        List<String> parts = List.of(s.split("\\."));
        if (!s.isEmpty() && parts.size() >= 3) {
            try {
                this.currentVersion[0] = Integer.parseInt(parts.get(0));
                this.currentVersion[1] = Integer.parseInt(parts.get(1));
                this.currentVersion[2] = Integer.parseInt(parts.get(2));
            } catch (Exception e) {
                throw new Exception("Error occured while parsing version!");
            }
        } else if (!s.isEmpty() && parts.size() == 2) {
            try {
                this.currentVersion[0] = Integer.parseInt(parts.get(0));
                this.currentVersion[1] = Integer.parseInt(parts.get(1));
                this.currentVersion[2] = 0;
            } catch (Exception e) {
                throw new Exception("Error occured while parsing version!");
            }
        } else if (!s.isEmpty() && parts.size() == 1) {
            try {
                this.currentVersion[0] = Integer.parseInt(parts.get(0));
                this.currentVersion[1] = 0;
                this.currentVersion[2] = 0;
            } catch (Exception e) {
                throw new Exception("Error occured while parsing version!");
            }
        } else if (s.isEmpty()) {
            this.currentVersion[0] = 0;
            this.currentVersion[1] = 0;
            this.currentVersion[2] = 1;
        }
    }

    public VersionManager() {

    }

    public VersionManager major() {
        this.previousVersions.add(Arrays.copyOf(this.currentVersion, 3));
        this.currentVersion[0] = this.currentVersion[0] + 1;
        this.currentVersion[1] = 0;
        this.currentVersion[2] = 0;
        return this;
    }

    public VersionManager minor() {
        this.previousVersions.add(Arrays.copyOf(this.currentVersion, 3));
        this.currentVersion[1] = this.currentVersion[1] + 1;
        this.currentVersion[2] = 0;
        return this;
    }

    public VersionManager patch() {
        this.previousVersions.add(Arrays.copyOf(this.currentVersion, 3));
        this.currentVersion[2] = this.currentVersion[2] + 1;
        return this;
    }

    public VersionManager rollback() throws Exception {
        if (this.previousVersions.size() == 0) {
            throw new Exception("Cannot rollback!");
        } else {
            this.currentVersion = Arrays.copyOf(this.previousVersions.get(previousVersions.size() - 1), 3);
            this.previousVersions.remove(previousVersions.size() - 1);
            return this;
        }
    }

    public String release() {
        return currentVersion[0] + "." + currentVersion[1] + "." + currentVersion[2];
    }

    @Override
    public String toString() {
        return "VersionManager{" +
                "currentVersion=" + Arrays.toString(currentVersion) +
                ", previousVersions=" + previousVersions +
                '}';
    }
}

