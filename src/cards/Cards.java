package cards;

public class Cards {
    private final String suit;
    private final String name;
    
    public Cards(String suit, String name) {
        this.suit = suit;
        this.name = name;
    } 

    public String getSuit() {
        return suit;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString(){
        return String.format("SUIT: %s\nNAME: %s",suit,name);
    }
}
