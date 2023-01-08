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
}
