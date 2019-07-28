class TennisGame1(player1Name: String, player2Name: String) : TennisGame {
    companion object {
        val SCORES = arrayOf("Love", "Fifteen", "Thirty", "Forty")
    }

    data class Player(val name: String, var score: Int = 0)

    private val players = arrayOf(Player(player1Name), Player(player2Name))

    override fun wonPoint(playerName: String) {
        players.find { it.name == playerName }!!.score++
    }

    override fun getScore(): String =
        if (players[0].score == players[1].score) {
            if (players[0].score < 3) "${SCORES[players[0].score]}-All" else "Deuce"
        } else if (players[0].score >= 4 || players[1].score >= 4) {
            val difference = players[0].score - players[1].score
            "${if (Math.abs(difference) == 1) "Advantage" else "Win for"} ${if (difference > 0) players[0].name else players[1].name}"
        } else {
            "${SCORES[players[0].score]}-${SCORES[players[1].score]}"
        }
}
