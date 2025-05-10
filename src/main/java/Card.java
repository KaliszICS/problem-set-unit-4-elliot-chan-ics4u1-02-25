/**
 * The {@code Card} class represents a standard playing card with a name (e.g., "Ace"),
 * a suit (e.g., "Hearts"), and its value, a numeric value.
 * @author: Elliot Chan
 * @version: 1.0.0
 */
public class Card {
    private String name, suit;
    private int value;

    /**
     * Constructs a {@code Card} object with the specified name, suit, and value.
     *
     * @param name  the name of the card (e.g., "Queen", "10")
     * @param suit  the suit of the card (e.g., "Clubs", "Diamonds")
     * @param value the numerical value of the card
     */
    public Card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    /**
     * Returns the name of the card.
     *
     * @return the name of the card
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the suit of the card.
     *
     * @return the suit of the card
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * Returns the numerical value of the card.
     *
     * @return the value of the card
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Returns a string representation of the card in the format "{name} of {suit}".
     *
     * @return a string representing the card
     */
    @Override
    public String toString() {
        return getName() + " of " + getSuit();
    }

    /**
     * Compares this card with another card for equality based on name, suit, and value.
     *
     * @param cardToCompare the card to compare with this card
     * @return {@code true} if the cards have the same name, suit, and value; {@code false} otherwise
     */
    public boolean equals(Card cardToCompare) {
        if(cardToCompare != null)
             return getName().equals(cardToCompare.getName())
            && getSuit().equals(cardToCompare.getSuit())
            && getValue() == cardToCompare.getValue();
        return false;
    }
}