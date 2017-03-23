package tests;

import cards.Card;
import cards.Deck;
import cards.DeckEmptyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DeckTest {
    private Deck deck;
    @BeforeEach
    void instantiate(){
        deck = new Deck();
    }

    @Test
    void deck_instantiated_with_initial_number_of_cards() {
        Assertions.assertTrue(isDeckWhole(deck));
    }

    @Test
    void when_shuffling_deck_should_be_shuffled(){
        Assertions.assertFalse(isDeckShuffled(deck));
        deck.shuffle();
        Assertions.assertTrue(isDeckShuffled(deck));
    }

    @Test
    void when_dealing_a_card_should_return_card() throws DeckEmptyException {
        Assertions.assertTrue(isDeckWhole(deck));
        deck.dealOneCard();
        Assertions.assertTrue(deck.getNumberOfCards() == Deck.DeckSize - 1);
    }

    @Test
    void when_deck_is_empty_dealing_a_card_should_throw_exception()  throws DeckEmptyException{
        for (int i = 0; i < Deck.DeckSize; i++) {
            deck.dealOneCard();
        }

        Assertions.assertTrue(deck.getNumberOfCards() == 0);

        Assertions.expectThrows(DeckEmptyException.class, () -> deck.dealOneCard());
    }

    private boolean isDeckWhole(Deck deck) {
        return (deck.getNumberOfCards() == Deck.DeckSize);
    }

    private boolean isDeckShuffled(Deck deck) {
        Deck cmpDeck = new Deck();

        for(int i = 0; i < cmpDeck.getNumberOfCards(); i++){
            Card cmpCard = cmpDeck.getCards().get(i);
            Card card = deck.getCards().get(i);

            if(card.equals(cmpCard)){
                return false;
            }
        }

        return true;
    }
}