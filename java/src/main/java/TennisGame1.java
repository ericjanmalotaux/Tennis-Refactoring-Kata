import java.util.stream.Collectors;
import java.util.stream.Stream;

class Score implements Comparable<Score> {
    private final static String[] SCORES = {"Love", "Fifteen", "Thirty", "Forty"};
    int score = 0;

    String name() {
        if (score < SCORES.length) {
            return SCORES[score];
        } else {
            return "Advantage";
        }
    }

    void scorePoint() {
        score++;
    }

    boolean won(Score other) {
        return winnable() && this.score - other.score >= 2;
    }

    public boolean winnable() {
        return this.score > 3;
    }

    @Override
    public int hashCode() {
        return score;
    }

    @Override
    public boolean equals(Object obj) {
        return score == ((Score) obj).score;
    }

    @Override
    public int compareTo(Score o) {
        return score - o.score;
    }
}

class Player {
    Score score = new Score();
    final String name;

    Player(String name) {
        this.name = name;
    }

    Player winning(Player player2) {
        return this.score.won(player2.score) ? this : player2.score.won(this.score) ? player2 : null;
    }

    Player advantage(Player player2) {
        if (score.winnable() || player2.score.winnable()) {
            int diff = this.score.compareTo(player2.score);
            return diff > 0 ? this : diff < 0 ? player2 : null;
        }
        return null;
    }
}

public class TennisGame1 implements TennisGame {


    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.name))
            player1.score.scorePoint();
        else
            player2.score.scorePoint();
    }

    public String getScore() {
        String score = "";
        if (player1.score.equals(player2.score)) {
            if (player1.score.score < 3) {
                score = player1.score.name() + "-All";
            } else {
                score = "Deuce";
            }
        } else {
            Player winning = player1.winning(player2);
            Player advantage = player1.advantage(player2);
            if (winning != null) {
                score = "Win for " + winning.name;
            } else if (advantage != null) {
                score = "Advantage " + advantage.name;
            } else {
                score = Stream.of(player1.score, player2.score).map(Score::name).collect(Collectors.joining("-"));
            }
        }
        return score;
    }
}
