package cards.wheels.card;

public class Joker extends Card {
    public static int id;
    
    public Joker(int id) {
        super(null, null);
        this.id = id;
    }
    
    @Override
    public String toString() {
        return String.format("Joker #%d", this.id);
    }
}
