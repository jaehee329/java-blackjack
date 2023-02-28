package domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    @DisplayName("동등성 검사 테스트")
    public void testEquals() {
        //given
        Card card1 = new Card("card1");
        Card card2 = new Card("card1");

        //when
        boolean result = card1.equals(card2);

        //then
        assertTrue(result);
    }
}