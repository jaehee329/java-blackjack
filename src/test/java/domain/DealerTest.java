package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import domain.card.Card;
import domain.card.Cards;
import domain.card.Denomination;
import domain.card.Suit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DealerTest {

    @Test
    @DisplayName("21 이하일 경우 카드 추가를 테스트")
    public void testAddCardWhenUnder21() {
        //given
        Cards cards = Cards.of(new Card(Suit.SPADE, Denomination.NINE));
        Dealer dealer = new Dealer(cards);

        //when
        dealer.addCard(new Card(Suit.DIAMOND, Denomination.NINE));
        dealer.addCard(new Card(Suit.SPADE, Denomination.THREE));

        //then
        assertThat(dealer.getScore().getValue()).isEqualTo(21);
    }

    @Test
    @DisplayName("21 초과일 경우 카드 추가를 테스트")
    public void testAddCardWhenOver21() {
        //given
        Cards cards = Cards.of(new Card(Suit.SPADE, Denomination.TEN));
        Dealer dealer = new Dealer(cards);

        //when
        dealer.addCard(new Card(Suit.SPADE, Denomination.TEN));
        dealer.addCard(new Card(Suit.SPADE, Denomination.ACE));

        //then
        assertThat(dealer.getScore().getValue()).isEqualTo(21);
    }

    @Test
    @DisplayName("카드를 더 받을 수 있는지 테스트")
    public void testCanReceiveCard() {
        //given
        Cards cardsScore16 = Cards.of(
            new Card(Suit.SPADE, Denomination.TEN),
            new Card(Suit.SPADE, Denomination.SIX));
        Dealer dealer = new Dealer(cardsScore16);

        //when
        boolean result = dealer.canReceiveCard();

        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("카드를 더 받을 수 없는지 테스트")
    public void testCanNotReceiveCard() {
        //given
        Cards cardsScore17 = Cards.of(
            new Card(Suit.SPADE, Denomination.TEN),
            new Card(Suit.SPADE, Denomination.SEVEN));
        Dealer dealer = new Dealer(cardsScore17);

        //when
        boolean result = dealer.canReceiveCard();

        //then
        assertFalse(result);
    }
}