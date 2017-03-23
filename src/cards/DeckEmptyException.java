package cards;

/**
 * Exception when a Card Deck is empty.
 */
public class DeckEmptyException extends Exception {
    public DeckEmptyException() {}

    public DeckEmptyException(String message)
    {
        super(message);
    }
}
