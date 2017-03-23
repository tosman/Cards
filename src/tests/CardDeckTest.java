package tests;

import cards.Card;
import cards.CardDeck;
import cards.CardDeckEmptyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CardDeckTest {
    private CardDeck cardDeck;

    @BeforeEach
    void instantiate() {
        cardDeck = new CardDeck();
    }

    @Test
    void deck_instantiated_with_initial_number_of_cards() {
        Assertions.assertTrue(isDeckWhole(cardDeck));
    }

    @Test
    void when_shuffling_deck_should_be_shuffled() {
        Assertions.assertFalse(isDeckShuffled(cardDeck));
        cardDeck.shuffle();
        Assertions.assertTrue(isDeckShuffled(cardDeck));
    }

    @Test
    void when_dealing_a_card_should_return_card() throws CardDeckEmptyException {
        Assertions.assertTrue(isDeckWhole(cardDeck));
        cardDeck.dealOneCard();
        Assertions.assertTrue(cardDeck.getNumberOfCards() == CardDeck.DeckSize - 1);
    }

    @Test
    void when_deck_is_empty_dealing_a_card_should_throw_exception() throws CardDeckEmptyException {
        for (int i = 0; i < CardDeck.DeckSize; i++) {
            cardDeck.dealOneCard();
        }

        Assertions.assertTrue(cardDeck.getNumberOfCards() == 0);

        Assertions.assertThrows(CardDeckEmptyException.class, () -> cardDeck.dealOneCard());
    }

    private boolean isDeckWhole(CardDeck cardDeck) {
        return (cardDeck.getNumberOfCards() == CardDeck.DeckSize);
    }

    private boolean isDeckShuffled(CardDeck cardDeck) {
        CardDeck cmpDeck = new CardDeck();

        for (int i = 0; i < cmpDeck.getNumberOfCards(); i++) {
            Card cmpCard = cmpDeck.getCards().get(i);
            Card card = cardDeck.getCards().get(i);

            if (card.equals(cmpCard)) {
                return false;
            }
        }

        return true;
    }
}