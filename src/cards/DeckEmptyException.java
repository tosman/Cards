package cards;

/**
 * Created by tarekosman on 3/22/17.
 */
public class DeckEmptyException extends Exception {
    public DeckEmptyException() {}

    public DeckEmptyException(String message)
    {
        super(message);
    }
}
