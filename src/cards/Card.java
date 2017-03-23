package cards;

/**
 * Created by tarekosman on 3/22/17.
 */
public class Card {
    private CardSuite suite;
    private CardValue value;

    public Card(CardSuite suite, CardValue value){
        this.suite = suite;
        this.value = value;
    }

    public CardSuite getSuite(){
        return this.suite;
    }

    public CardValue getValue(){
        return this.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suite != card.suite) return false;
        return value == card.value;
    }

    @Override
    public int hashCode() {
        int result = suite != null ? suite.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
