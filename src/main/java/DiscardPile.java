import java.util.ArrayList;

/**
 * The {@code DiscardPile} class represents a pile of discarded playing cards.
 * This serves as a modifiable pile to store cards that the player has discarded.
 * @author: Elliot Chan
 * @version: 1.0.0
 */
public class DiscardPile {

    private ArrayList<Card> discardPile;

    /**
     * Constructs a {@code DiscardPile} with an initial array of cards.
     *
     * @param discardPile - an array of Card objects used to initialize an internal ArrayList of cards, the discard pile
     */
    public DiscardPile(Card[] discardPile) {
        this.discardPile = new ArrayList<Card>();
        for (Card card : discardPile)
            this.discardPile.add(card);
    }

    /**
     * Returns all cards in the discard pile as an array.
     *
     * @return an array of {@code Card} objects currently in the discard pile
     */
    public Card[] getDiscardPile() {
        return this.discardPile.toArray(new Card[0]);
    }

    /**
     * Returns the number of cards in the discard pile.
     *
     * @return the size of the discard pile
     */
    public int size() {
        return discardPile.size();
    }

    /**
     * Adds a card to the discard pile.
     *
     * @param card the {@code Card} to be added
     */
    public void addCard(Card card) {
        if (card != null) {
            discardPile.add(card);
        }
    }

    /**
     * Removes a specific card from the discard pile.
     *
     * @param card the {@code Card} to be removed
     * @return the removed card, or {@code null} if the card was not found
     */
    public Card removeCard(Card card) {
         boolean isFound = false;
        for(int index = 0; index < size(); index++) {
            if(discardPile.get(index).equals(card))
                isFound = true;
        }
        if(!isFound)
            return null;

        discardPile.remove(card);
        return card;
    }

    /**
     * Removes all cards from the discard pile.
     *
     * @return an array of all cards that were in the discard pile
     */
    public Card[] removeAll() {
        if (size() <= 0)
            return new Card[]{};

        Card[] cards = getDiscardPile();
        discardPile.clear();

        return cards;
    }

    
    /**
     * Returns the discard pile as a single string.
     * Each card is listed in the format "Name of Suit".
     * Example: "Queen of Hearts, Jack of Spades, 5 of Clubs."
     *
     * @return a string listing all cards in the discard pile
     */
    public String toString() {
        if (size() <= 0)
            return "";

        String st = "";
        for (Card card : getDiscardPile()) {
            st += card.getName() + " of " + card.getSuit() + ", ";
        }
        st = st.substring(0, st.length() - 2) + ".";
        return st;
    }
}