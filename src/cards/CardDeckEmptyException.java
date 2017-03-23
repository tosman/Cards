package cards;

/**
 * Exception when a Card Deck is empty.
 */
public class CardDeckEmptyException extends Exception {
    public CardDeckEmptyException() {
    }

    public CardDeckEmptyException(String message)
    {
        super(message);
    }
}
