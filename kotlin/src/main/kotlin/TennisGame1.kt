data class Player(val name: String, var score: Int = 0)
class TennisGame1(player1Name: String, player2Name: String) : TennisGame {
    companion object {
        val SCORES = arrayOf("Love", "Fifteen", "Thirty", "Forty")
    }

    private val players = arrayOf(Player(player1Name), Player(player2Name))

    override fun wonPoint(playerName: String) {
        players.find { it.name == playerName }!!.score++
    }

    override fun getScore(): String {
        val scores = players.map { it.score }.distinct()
        return if (scores.size == 1) {
            if (scores.single() < 3) "${SCORES[scores.single()]}-All" else "Deuce"
        } else if (scores.any { it >= 4 }) {
            val difference = scores[0] - scores[1]
            "${if (Math.abs(difference) == 1) "Advantage" else "Win for"} ${if (difference > 0) players[0].name else players[1].name}"
        } else {
            "${SCORES[scores[0]]}-${SCORES[scores[1]]}"
        }
    }
}
