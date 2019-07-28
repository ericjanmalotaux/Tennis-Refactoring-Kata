
public class TennisGame3 implements TennisGame {

    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            return p[p1] + ((p1 == p2) ? "-All" : "-" + p[p2]);
        }
        if (p1 == p2)
            return "Deuce";
        return ((Math.abs(p1 - p2) == 1) ? "Advantage " : "Win for ") + (p1 > p2 ? p1N : p2N);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(p1N))
            this.p1 += 1;
        else
            this.p2 += 1;
    }
}
