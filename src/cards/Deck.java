package cards;

import cards.Cards;
import java.security.SecureRandom;
import java.util.Random;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Deck {
    protected ArrayList<Cards> cards;
    protected Map<String,Integer> deck;

    public static final String[] SUIT = {
        "Diamond" , "Spade" ,"Heart" , "Clubs"
    };

    public static final String[] NAME ={
        "Ace", "Two", "Three","Four", 
        "Five","Six","Seven","Eight","Nine",
        "Ten","Jack","Queen","King"
    };

    public static final int[] VALUE = {
        1, 2, 3, 4, 
        5, 6, 7, 8, 9, 
        10, 10, 10, 10
    };

 
    public Deck(){
        int idx = 0;
        cards = new ArrayList<Cards>();
        deck = new HashMap<String,Integer>();

        for (String suit : SUIT){
            for(int i = 0 ; i < NAME.length; i++){
                String name = NAME[i];
                int value = VALUE[i];
                Cards card = new Cards(suit, name);
                deck.put(name,value);
                cards.add(card);
                idx++;
                //System.out.println("IN THE LOOP:");
                //System.out.printf("INDEX: %d Suit: %s Name: %s\n", idx,cards[idx-1].getSuit(),cards[idx-1].getName());

            }
        }
    }

    public Cards getCard(){
        return this.cards.get(0);
    }

    public int getValue(Cards card){
        return this.deck.get(card.getName());
    }

    public Cards getCard(int i){
        return this.cards.get(i);
    }

    public void shuffle() {
        Random rand = new SecureRandom();
        for (int idx = cards.size() - 1; idx > 0; idx--) {
            
            int pos = rand.nextInt(idx + 1);
            Cards temp = cards.get(idx);
            cards.set(idx,cards.get(pos));
            cards.set(pos,temp);
        }
        System.out.println("DECK SHUFFLED\n");    
    }
}
