class Person {
    int score;
    final String name;

    Person(String name) {
        this.name = name;
    }
}

public class TennisGame3 implements TennisGame {

    private Person person1, person2;

    public TennisGame3(String p1N, String p2N) {
        this.person1 = new Person(p1N);
        this.person2 = new Person(p2N);
    }

    public String getScore() {
        if (person2.score < 4 && person1.score < 4 && !(person2.score + person1.score == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            return p[person2.score] + ((person2.score == person1.score) ? "-All" : "-" + p[person1.score]);
        }
        if (person2.score == person1.score)
            return "Deuce";
        return ((Math.abs(person2.score - person1.score) == 1) ? "Advantage " : "Win for ") + (person2.score > person1.score ? person1.name : person2.name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(person1.name))
            this.person2.score += 1;
        else
            this.person1.score += 1;
    }
}
