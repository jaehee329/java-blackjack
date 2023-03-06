package domain.model;

import static org.junit.jupiter.api.Assertions.*;

import domain.type.Letter;
import domain.type.Suit;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("21 이하의 점수에서의 bust 테스트")
    public void testScore21NotBust() {
        //given
        Set<Card> cardSet = new HashSet<>();
        cardSet.add(new Card(Suit.SPADE, Letter.NINE));
        cardSet.add(new Card(Suit.DIAMOND, Letter.NINE));
        Cards cards = new Cards(cardSet);
        Player player = new Player(cards, "player");

        //when
        player.addCard(new Card(Suit.SPADE, Letter.THREE));

        //then
        assertFalse(player.isBust());
    }

    @Test
    @DisplayName("22 이상의 점수에서의 bust 테스트")
    public void testScore22Bust() {
        //given
        Set<Card> cardSet = new HashSet<>();
        cardSet.add(new Card(Suit.SPADE, Letter.TEN));
        cardSet.add(new Card(Suit.DIAMOND, Letter.TEN));
        Cards cards = new Cards(cardSet);
        Player player = new Player(cards, "player");

        //when
        player.addCard(new Card(Suit.SPADE, Letter.TWO));

        //then
        assertTrue(player.isBust());
    }
}
