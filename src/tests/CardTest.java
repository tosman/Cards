package tests;

import cards.Card;
import cards.CardSuite;
import cards.CardValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardTest {

    private Card card;

    @BeforeEach
    void initialize() {
        card = new Card(CardSuite.SPADES, CardValue.ACE);
    }

    @Test
    void card_instantiated_with_correct_suite() {
        Assertions.assertTrue(card.getSuite() == CardSuite.SPADES);
    }

    @Test
    void card_instantiated_with_correct_value() {
        Assertions.assertTrue(card.getValue() == CardValue.ACE);
    }

    @Test
    void cards_only_equal_if_suite_and_value_are_same() {
        Card cmpCard = new Card(CardSuite.SPADES, CardValue.ACE);

        Assertions.assertTrue(cmpCard.equals(card));

        cmpCard = new Card(CardSuite.SPADES, CardValue.NINE);

        Assertions.assertFalse(cmpCard.equals(card));

        cmpCard = new Card(CardSuite.CLUBS, CardValue.ACE);

        Assertions.assertFalse(cmpCard.equals(card));
    }
}
