import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame {
    private static final List<String> SCORES = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");
    private int p1point = 0;
    private int p2point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (p1point == p2point) {
            return p1point < 3 ? SCORES.get(p1point) + "-All" : "Deuce";
        } else {
            if (p1point < 4 && p2point < 4) {
                return SCORES.get(p1point) + "-" + SCORES.get(p2point);
            } else {
                return String.format("%s %s",
                        Math.abs(p1point - p2point) >= 2 ? "Win for" : "Advantage",
                        p1point > p2point ? player1Name : player2Name);
            }
        }
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            p1point++;
        else
            p2point++;
    }
}