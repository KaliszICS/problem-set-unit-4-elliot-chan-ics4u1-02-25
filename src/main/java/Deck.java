import java.util.Random;
import java.util.ArrayList;

/**
 * The {@code Deck} class represents a standard deck of 52 playing cards.
 * It allows drawing, shuffling, and managing the cards in the deck.
 * @author: Elliot Chan
 * @version: 1.0.0
 */
public class Deck {

    public ArrayList<Card> deck;

    /**
     * Constructs a deck using a predefined array of cards.
     * @param deck an array of {@code Card} objects to initialize the deck's internal ArrayList with
     */
    public Deck(Card[] deck) {
        this.deck = new ArrayList<Card>();
        for (Card card : deck)
            this.deck.add(card);
    }

    /**
     * Default constructor that generates a standard unshuffled 52-card deck.
     */
    public Deck() {
        this.deck = generateUnshuffledDeck();
    }

    /**
     * Generates an unshuffled standard 52-card deck with 4 suits and 13 ranks each.
     * From Spades to Diamonds
     * From Ace to King
     *
     * @return an {@code ArrayList} containing 52 {@code Card} objects
     */
    private ArrayList<Card> generateUnshuffledDeck() {
        ArrayList<Card> deck = new ArrayList<Card>();

        // Initialize the deck with nulls to set by index
        for (int i = 0; i < 52; i++) {
            deck.add(null);
        }

        for (int suit = 0; suit < 4; suit++) {
            for (int cardType = 1; cardType <= 13; cardType++) {
                String SUIT = "", NAME = "";
                int VALUE = cardType;

                switch (suit) {
                    case 0: 
                        SUIT = "Spades";
                        break;
                    case 1: 
                        SUIT = "Hearts"; 
                        break;
                    case 2: 
                        SUIT = "Clubs"; 
                        break;
                    case 3: 
                        SUIT = "Diamonds"; 
                        break;
                }

                if (cardType >= 2 && cardType <= 10) {
                    NAME = Integer.toString(cardType);
                } else {
                    switch (cardType) {
                        case 1: 
                            NAME = "Ace"; 
                            break;
                        case 11:
                            NAME = "Jack";
                            break;
                        case 12: 
                            NAME = "Queen";
                            break;
                        case 13: 
                            NAME = "King"; 
                            break;
                    }
                }

                Card card = new Card(NAME, SUIT, VALUE);
                deck.set(VALUE + suit * 13 - 1, card); // Set card in correct position, using its value and suit.
            }
        }

        return deck;
    }

    /**
     * Returns the current number of cards in the deck.
     *
     * @return the size of the deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * Draws (removes and returns) the top card from the deck.
     *
     * @return the drawn {@code Card}, or {@code null} if the deck is empty
     */
    public Card draw() {
        if (size() <= 0) {
            return null;
        }
        Card drawnCard = deck.get(size() - 1);
        deck.remove(size() - 1);
        return drawnCard;
    }

    /**
     * Shuffles the deck using the Fisher-Yates algorithm.
     */
    public void shuffle() {
        int n = size();
        Random random = new Random();

        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card tempCard = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, tempCard);
        }
    }

    /**
     * Adds a card to the bottom of the deck.
     *
     * @param card the {@code Card} to be added
     */
    public void addCard(Card card) {
        if (card != null) {
            deck.add(card);
        }
    }

    /**
     * Adds multiple cards to the deck and reshuffles it.
     *
     * @param cards an array of {@code Card} objects to be added before reshuffling.
     */
    public void reshuffle(Card[] cards) {
        for (Card card : cards) {
            addCard(card);
        }
        shuffle();
    }
}