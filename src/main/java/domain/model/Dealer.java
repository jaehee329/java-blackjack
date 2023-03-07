package domain.model;

import java.util.HashSet;

public class Dealer extends Player {

    private static final int MIN_SCORE_THRESHOLD = 16;
    private static final String DEALER_NAME = "딜러";

    public Dealer(final Cards cards) {
        super(cards, DEALER_NAME);
    }

    public Dealer()  {
        super(new Cards(new HashSet<>()), DEALER_NAME);
    }

    @Override
    public boolean canReceiveCard() {
        return super.getScore().getValue() <= MIN_SCORE_THRESHOLD;
    }
}
