import java.lang.Math.abs

class TennisGame1(player1Name: String, player2Name: String) : TennisGame {

    companion object {
        val SCORES = arrayOf("Love", "Fifteen", "Thirty", "Forty")
    }
    data class Player(val name: String) {
        var score = 0
    }
    val player1 = Player(player1Name)
    val player2 = Player(player2Name)

    private var m_score1: Int = 0
    private var m_score2: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName == player1.name)
            m_score1 += 1
        else
            m_score2 += 1
    }

    override fun getScore(): String =
        if (m_score1 == m_score2) {
            if (m_score1 < 3) "${SCORES[m_score1]}-All" else "Deuce"
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            val minusResult = m_score1 - m_score2
            "${if (abs(minusResult) == 1) "Advantage" else "Win for"} ${if (minusResult > 0) player1.name else player2.name}"
        } else {
            "${SCORES[m_score1]}-${SCORES[m_score2]}"
        }
}
