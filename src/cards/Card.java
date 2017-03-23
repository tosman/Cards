package cards;

/**
 * Represents a playing card. Each card has a Suite and a Value.
 */
public class Card {
    private CardSuite suite;
    private CardValue value;

    /**
     * @param suite suite of the card
     * @param value face value of the card
     */
    public Card(CardSuite suite, CardValue value){
        this.suite = suite;
        this.value = value;
    }

    /**
     * @return the cards suite
     */
    public CardSuite getSuite(){
        return this.suite;
    }

    /**
     * @return the cards value
     */
    public CardValue getValue(){
        return this.value;
    }

    /**
     * Compares two cards based on their suite and value
     *
     * @param o Object to compare
     * @return true if cards have same suite and value, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return suite == card.suite && value == card.value;
    }

    /**
     * Creates a hashcode based on the cards suite and value
     *
     * @return hashcode based on the cards suite and value
     */
    @Override
    public int hashCode() {
        int result = suite != null ? suite.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
