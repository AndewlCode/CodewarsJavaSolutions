package Classes.Ghost;

import java.util.Random;

public class Ghost {
    private final String color;

    public Ghost() {
        Random random = new Random();
        String[] colors = new String[]{"white", "yellow", "purple", "red"};
        this.color = colors[random.nextInt(0, colors.length)];
    }


    public String getColor() {
        return color;
    }
}
