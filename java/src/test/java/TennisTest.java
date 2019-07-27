import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TennisTest {

    private String player1;
    private String player2;
    private int player1Score;
    private int player2Score;
    private String expectedScore;

    public TennisTest(String player1, String player2, int player1Score, int player2Score, String expectedScore) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.expectedScore = expectedScore;
    }

    @Parameters
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][]{
                {"Eric", "Trudie", 0, 0, "Love-All"},
                {"Jiska", "Milka", 1, 1, "Fifteen-All"},
                {"Berend Jan", "Choi Wan", 2, 2, "Thirty-All"},
                {"Emma", "Lisa", 3, 3, "Deuce"},
                {"Bastiaan", "Marijn", 4, 4, "Deuce"},

                {"Eric", "Trudie", 1, 0, "Fifteen-Love"},
                {"Eric", "Trudie", 0, 1, "Love-Fifteen"},
                {"Eric", "Trudie", 2, 0, "Thirty-Love"},
                {"Eric", "Trudie", 0, 2, "Love-Thirty"},
                {"Eric", "Trudie", 3, 0, "Forty-Love"},
                {"Eric", "Trudie", 0, 3, "Love-Forty"},
                {"Eric", "Trudie", 4, 0, "Win for Eric"},
                {"Eric", "Trudie", 0, 4, "Win for Trudie"},

                {"Eric", "Trudie", 2, 1, "Thirty-Fifteen"},
                {"Eric", "Trudie", 1, 2, "Fifteen-Thirty"},
                {"Eric", "Trudie", 3, 1, "Forty-Fifteen"},
                {"Eric", "Trudie", 1, 3, "Fifteen-Forty"},
                {"Eric", "Trudie", 4, 1, "Win for Eric"},
                {"Eric", "Trudie", 1, 4, "Win for Trudie"},

                {"Eric", "Trudie", 3, 2, "Forty-Thirty"},
                {"Eric", "Trudie", 2, 3, "Thirty-Forty"},
                {"Eric", "Trudie", 4, 2, "Win for Eric"},
                {"Eric", "Trudie", 2, 4, "Win for Trudie"},

                {"Bastiaan", "Berend Jan", 4, 3, "Advantage Bastiaan"},
                {"Eric", "Trudie", 3, 4, "Advantage Trudie"},
                {"Eric", "Trudie", 5, 4, "Advantage Eric"},
                {"Eric", "Trudie", 4, 5, "Advantage Trudie"},
                {"Eric", "Trudie", 15, 14, "Advantage Eric"},
                {"Eric", "Trudie", 14, 15, "Advantage Trudie"},

                {"Eric", "Trudie", 6, 4, "Win for Eric"},
                {"Eric", "Trudie", 4, 6, "Win for Trudie"},
                {"Eric", "Trudie", 16, 14, "Win for Eric"},
                {"Eric", "Trudie", 14, 16, "Win for Trudie"},
        });
    }

    public void checkAllScores(TennisGame game) {
        int highestScore = Math.max(this.player1Score, this.player2Score);
        for (int i = 0; i < highestScore; i++) {
            if (i < this.player1Score)
                game.wonPoint(player1);
            if (i < this.player2Score)
                game.wonPoint(player2);
        }
        assertEquals(this.expectedScore, game.getScore());
    }

    @Test
    public void checkAllScoresTennisGame1() {
        TennisGame1 game = new TennisGame1(player1, player2);
        checkAllScores(game);
    }

    @Test
    public void checkAllScoresTennisGame2() {
        TennisGame2 game = new TennisGame2(player1, player2);
        checkAllScores(game);
    }

    @Test
    public void checkAllScoresTennisGame3() {
        TennisGame3 game = new TennisGame3(player1, player2);
        checkAllScores(game);
    }

}
