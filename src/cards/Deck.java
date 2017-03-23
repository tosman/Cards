package cards;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a 52 playing card deck
 */
public class Deck {
    /**
     * The number of cards each deck starts with.
     */
    public static final int DeckSize = 52;
    private ArrayList<Card> cards;

    /**
     * Instantiates a deck with 52 cards
     */
    public Deck(){
        cards = new ArrayList(DeckSize);
        for (CardSuite suite: CardSuite.values()) {
            for (CardValue value: CardValue.values())  {
                cards.add(new Card(suite, value));
            }
        }
    }

    /**
     * Gets the current number of cards available in the deck
     * @return number of cards remaining
     */
    public int getNumberOfCards(){
        return cards.size();
    }

    /**
     * Shuffles the Deck of cards in place. Uses 'java.util.Random'
     * for randomness.
     */
    public void shuffle(){
        Random random = new Random();
        int size = cards.size();

        for (int i = size - 1; i > 1; i--) {
            int j = random.nextInt(i);

            cards.set(i, cards.set(j, cards.get(i)));
        }
    }

    /**
     * Get list of cards in the deck
     * @return Current Cards in the deck
     */
    public ArrayList<Card> getCards(){
        return cards;
    }

    /**
     * Deal a card. Mutates the deck by removing the last card.
     * @return Removed Card
     * @throws DeckEmptyException when no cards remain in the deck
     */
    public Card dealOneCard() throws DeckEmptyException{
        if(this.cards.size() == 0){
            throw new DeckEmptyException("Deck Empty!");
        }

        return this.cards.remove(this.cards.size() - 1);

    }
}

