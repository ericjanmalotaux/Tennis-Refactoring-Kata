import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Player {
    final String name;
    int score = 0;

    Player(String name) {
        this.name = name;
    }

    void wonPoint() {
        score++;
    }
}

public class TennisGame1 implements TennisGame {
    private static final String[] SCORES = {"Love", "Fifteen", "Thirty", "Forty"};
    private final List<Player> players;

    TennisGame1(String player1Name, String player2Name) {
        players = Arrays.asList(new Player(player1Name), new Player(player2Name));
    }

    public void wonPoint(String playerName) {
        players.stream().filter(player -> playerName.equals(player.name)).forEach(Player::wonPoint);
    }

    public String getScore() {
        List<Integer> scores = players.stream().map(player -> player.score).distinct().collect(Collectors.toList());
        if (scores.size() == 1) {
            return players.get(0).score < 3 ? SCORES[players.get(0).score] + "-All" : "Deuce";
        }
        if (players.stream().anyMatch(player -> player.score >= 4)) {
            return (Math.abs(players.stream().map(player -> player.score).reduce((a, b) -> a - b).get()) == 1
                    ? "Advantage " : "Win for ") + players.stream().reduce((a1, b1) -> a1.score < b1.score ? b1 : a1).get().name;
        }
        return players.stream().map(player -> player.score).map(s -> SCORES[s]).collect(Collectors.joining("-"));
    }
}
