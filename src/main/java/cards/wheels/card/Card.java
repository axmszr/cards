package cards.wheels.card;

public class Card {
    public static Rank rank;
    public static Suit suit;
    
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public String toString() {
        return String.format("%s of %s", this.rank, this.suit);
    }
}
