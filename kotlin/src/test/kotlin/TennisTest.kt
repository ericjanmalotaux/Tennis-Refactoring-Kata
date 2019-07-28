import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import java.util.*

@RunWith(Parameterized::class)
class TennisTest(
    private val player1Name: String,
    private val player2Name: String,
    private val player1Score: Int,
    private val player2Score: Int,
    private val expectedScore: String
) {

    companion object {

        val allScores: Collection<Array<Any>>
            @JvmStatic
            @Parameters
            get() =
                Arrays.asList(
                    arrayOf("player1", "player2", 0, 0, "Love-All"),
                    arrayOf("player1", "player2", 1, 1, "Fifteen-All"),
                    arrayOf("player1", "player2", 2, 2, "Thirty-All"),
                    arrayOf("player1", "player2", 3, 3, "Deuce"),
                    arrayOf("player1", "player2", 4, 4, "Deuce"),
                    arrayOf("player1", "player2", 1, 0, "Fifteen-Love"),
                    arrayOf("player1", "player2", 0, 1, "Love-Fifteen"),
                    arrayOf("player1", "player2", 2, 0, "Thirty-Love"),
                    arrayOf("player1", "player2", 0, 2, "Love-Thirty"),
                    arrayOf("player1", "player2", 3, 0, "Forty-Love"),
                    arrayOf("player1", "player2", 0, 3, "Love-Forty"),
                    arrayOf("player1", "player2", 4, 0, "Win for player1"),
                    arrayOf("player1", "player2", 0, 4, "Win for player2"),
                    arrayOf("player1", "player2", 2, 1, "Thirty-Fifteen"),
                    arrayOf("player1", "player2", 1, 2, "Fifteen-Thirty"),
                    arrayOf("player1", "player2", 3, 1, "Forty-Fifteen"),
                    arrayOf("player1", "player2", 1, 3, "Fifteen-Forty"),
                    arrayOf("player1", "player2", 4, 1, "Win for player1"),
                    arrayOf("player1", "player2", 1, 4, "Win for player2"),
                    arrayOf("player1", "player2", 3, 2, "Forty-Thirty"),
                    arrayOf("player1", "player2", 2, 3, "Thirty-Forty"),
                    arrayOf("player1", "player2", 4, 2, "Win for player1"),
                    arrayOf("player1", "player2", 2, 4, "Win for player2"),
                    arrayOf("player1", "player2", 4, 3, "Advantage player1"),
                    arrayOf("player1", "player2", 3, 4, "Advantage player2"),
                    arrayOf("player1", "player2", 5, 4, "Advantage player1"),
                    arrayOf("player1", "player2", 4, 5, "Advantage player2"),
                    arrayOf("player1", "player2", 15, 14, "Advantage player1"),
                    arrayOf("player1", "player2", 14, 15, "Advantage player2"),
                    arrayOf("player1", "player2", 6, 4, "Win for player1"),
                    arrayOf("player1", "player2", 4, 6, "Win for player2"),
                    arrayOf("player1", "player2", 16, 14, "Win for player1"),
                    arrayOf("player1", "player2", 14, 16, "Win for player2")
                )
    }

    fun checkAllScores(game: TennisGame) {
        val highestScore = Math.max(this.player1Score, this.player2Score)
        for (i in 0 until highestScore) {
            if (i < this.player1Score)
                game.wonPoint("player1")
            if (i < this.player2Score)
                game.wonPoint("player2")
        }
        assertEquals(this.expectedScore, game.getScore())
    }

    @Test
    fun checkAllScoresTennisGame1() {
        val game = TennisGame1(player1Name, player2Name)
        checkAllScores(game)
    }

    @Test
    fun checkAllScoresTennisGame2() {
        val game = TennisGame2(player1Name, player2Name)
        checkAllScores(game)
    }

    @Test
    fun checkAllScoresTennisGame3() {
        val game = TennisGame3(player1Name, player2Name)
        checkAllScores(game)
    }
}
