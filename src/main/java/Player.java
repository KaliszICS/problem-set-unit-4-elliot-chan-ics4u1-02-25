import java.util.ArrayList;

/**
 * The {@code Player} class represents a player in a card game.
 * Each player has a name, age, and a hand of cards.
 * @author: Elliot Chan
 * @version: 1.0.0
 */
public class Player {

    private String name;
    private int age;
    private ArrayList<Card> hand;

    /**
     * Constructs a player with a name, age, and an initial hand of cards.
     *
     * @param name the player's name
     * @param age the player's age
     * @param hand an array of cards to initialize the player's hand
     */
    public Player(String name, int age, Card[] hand) {
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<Card>();
        for (Card card : hand)
            this.hand.add(card);
    }

    /**
     * Constructs a player with a name and age, starting with an empty hand.
     *
     * @param name the player's name
     * @param age the player's age
     */
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<Card>();
    }

    /**
     * Returns the name of the player.
     *
     * @return the player's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the age of the player.
     *
     * @return the player's age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Returns the cards currently in the player's hand.
     *
     * @return an array of cards in the player's hand
     */
    public Card[] getHand() {
        return this.hand.toArray(new Card[0]);
    }

    /**
     * Returns the number of cards in the player's hand.
     *
     * @return the size of the hand
     */
    public int size() {
        return hand.size();
    }

    /**
     * Draws one card from the given deck and adds it to the player's hand.
     *
     * @param deck the deck from which to draw a card
     */
    public void draw(Deck deck) {
        Card drawnCard = deck.draw();
        if(drawnCard != null)
            hand.add(drawnCard);
    }

    /**
     * Discards a specific card from the player's hand into the discard pile.
     *
     * @param card the card to discard
     * @param discardPile the discard pile to place the card into
     * @return {@code true} if the card was in the hand and successfully discarded, {@code false} otherwise
     */
    public boolean discardCard(Card card, DiscardPile discardPile) {
        int indexOfCard = -1;
        for(int index = 0; index < size(); index++) {
            if(hand.get(index).equals(card))
                indexOfCard = index;
        }
        if(indexOfCard == -1)
            return false;

        discardPile.addCard(card);
        hand.remove(indexOfCard);
        return true;
    }

    /**
     * Returns a specific card from the player's hand back into the deck.
     *
     * @param card the card to return
     * @param deck the deck to return the card to
     * @return {@code true} if the card was in the hand and returned to the deck, {@code false} otherwise
     */
    public boolean returnCard(Card card, Deck deck) {
        int indexOfCard = -1;
        for(int index = 0; index < size(); index++) {
            if(hand.get(index).equals(card))
                indexOfCard = index;
        }
        if(indexOfCard == -1)
            return false;
    
        hand.remove(indexOfCard);
        deck.addCard(card);
        return true;
    }

    /**
     * Returns a string representation of the player's hand.
     * Each card is formatted as "Name of Suit".
     *
     * @return a string listing all cards in the hand
     */
    public String toString() {
        if (size() <= 0)
            return "";

        String st = "";
        for (Card card : hand) {
            st += card.getName() + " of " + card.getSuit() + ", ";
        }
        st = st.substring(0, st.length() - 2) + ".";
        return st;
    }
}