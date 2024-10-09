package cards;


public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Cards card = deck.getCard();
        System.out.println(card.toString());
        int value = deck.getValue(card);
        System.out.printf("VALUE: %d\n",value);

        deck.shuffle();
        card = deck.getCard();
        System.out.println(card.toString());
        value = deck.getValue(card);
        System.out.printf("VALUE: %d\n",value);

        deck.shuffle();
        card = deck.getCard();
        System.out.println(card.toString());
        value = deck.getValue(card);
        System.out.printf("VALUE: %d\n",value);
        
        deck.shuffle();
        card = deck.getCard();
        System.out.println(card.toString());
        value = deck.getValue(card);
        System.out.printf("VALUE: %d\n",value);

        deck.shuffle();
        card = deck.getCard();
        System.out.println(card.toString());
        value = deck.getValue(card);
        System.out.printf("VALUE: %d\n",value);

    }
}
