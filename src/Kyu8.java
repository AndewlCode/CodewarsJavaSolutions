import java.util.Arrays;

public class Kyu8 {
    public static void main(String[] args) {
        Player player1 = new Player("one");
        Player player2 = new Player("two");
        Player player3 = new Player("three");
        Player player4 = new Player("four");
        Player[] players = new Player[]{player1, player2, player3, player4};

        for (Player player : players) {
            System.out.println(player.name);
        }

        System.out.println(duckDuckGoose(players, 12));
    }

    public static String duckDuckGoose(Player[] players, int goose) {
        // Note: Player objects have a String field called 'name'.
        if (players.length > goose - 1 && goose > 0) {
            return players[goose - 1].name;
        } else {
            int rounds = (goose - 1) / players.length;
            int index = goose - rounds * players.length - 1;
            return players[index].name;
        }
    }

    public static String printArray(Object[] array) {
        return String.join(",", Arrays.stream(array).map(Object::toString).toArray(String[]::new));
    }

    public static String sayHello(String[] name, String city, String state) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello, ");
        for (String s : name) {
            stringBuilder.append(s).append(" ");
        }
        return stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length())
                .append("! Welcome to ")
                .append(city)
                .append(", ")
                .append(state)
                .append("!")
                .toString();
    }
}

class Player {
    public Player(String name) {
        this.name = name;
    }

    public String name;
}