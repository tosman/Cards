package cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a 52 playing card deck
 */
public class CardDeck {
    /**
     * The number of cards each deck starts with.
     */
    public static final int DeckSize = 52;
    private List<Card> cards;

    /**
     * Instantiates a deck with 52 cards
     */
    public CardDeck() {
        cards = new ArrayList(DeckSize);
        for (CardSuite suite : CardSuite.values()) {
            for (CardValue value : CardValue.values()) {
                cards.add(new Card(suite, value));
            }
        }
    }

    /**
     * Gets the current number of cards available in the deck
     *
     * @return number of cards remaining
     */
    public int getNumberOfCards() {
        return cards.size();
    }

    /**
     * Shuffles the deck of cards in place. Uses 'java.util.Random'
     * for randomness. Ensures that each card will be moved from its initial
     * position
     */
    public void shuffle() {
        Random random = new Random();
        int size = cards.size();

        for (int i = size - 1; i > 1; i--) {
            int j = random.nextInt(i);

            cards.set(i, cards.set(j, cards.get(i)));
        }
    }

    /**
     * Get list of cards in the deck
     *
     * @return Current Cards in the deck
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Deal a card. Mutates the deck by removing the last card.
     *
     * @return Removed Card
     * @throws CardDeckEmptyException when no cards remain in the deck
     */
    public Card dealOneCard() throws CardDeckEmptyException {
        if (cards.size() == 0) {
            throw new CardDeckEmptyException();
        }

        return cards.remove(this.cards.size() - 1);

    }
}

