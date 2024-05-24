package cards.wheels;

public class Deck {
    public List<Card> cards;
    
    private static final DEFAULT_ORDER = new TaitiOrder();
    
    public Deck(List<Card> cards) {
        this.cards = cards;
    }
    
    public static Deck makeNew(int numJokers) {
        List<Card> cards = new LinkedList<>();
        
        for (int i = 1; i <= numJokers; i++) {
            cards.add(new Joker(i));
        }
        
        for (Suite suite : Suite.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suite));
            }
        }

        // 2 Diamonds (bottom) -> A Spades (top)
        return Deck(cards);
    }
    
    // Getters
    public int size() {
        return this.cards.size();
    }
    
    public int isEmpty() {
        return this.cards.isEmpty();
    }
    
    public Card topCard() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException(this);
        }
        return this.cards.get(0);
    }
    
    public Card draw() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException(this);
        }
        return this.cards.remove(0);
    }
    
    public void putAtBottom(List<Card> newCards) {
        this.cards.addAll(newCards);
    }
    
    // Setters
    public void shuffle() {
        Collections.shuffle(this.cards);
    }
    
    public void returnAndShuffle(List<Card> newCards) {
        putAtBottom(newCards);
        shuffle();
    }
    
    public void sort(Comparator<Card> comp) {
        Collections.sort(this.cards, comp);
    }
    
    public void sort() {
        sort(DEFAULT_ORDER);
    }
}
