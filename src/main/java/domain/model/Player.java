package domain.model;

import java.util.HashSet;
import java.util.Set;

public class Player {

    private final Cards cards;
    private final String name;
    private Score score;

    public Player(final Cards cards, final String name) {
        this.cards = cards;
        this.name = name;
        this.score = makeScore(cards);
    }

    private Score makeScore(final Cards cards) {
        return Score.of(cards);
    }

    public static Player from(final String name) {
        return new Player(new Cards(new HashSet<>()), name);
    }

    public void addCard(final Card card) {
        cards.add(card);
        score = makeScore(cards);
    }

    public boolean isBust() {
        return score.isBust();
    }

    public Cards getCards() {
        return new Cards(Set.copyOf(cards.getCards()));
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }
}
