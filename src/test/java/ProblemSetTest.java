import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ProblemSetTest {
  // Card Class Tests
    @Test
    public void testCardConstructor() {
        Card card = new Card("Ace", "Spades", 1);
        assertEquals("Ace", card.getName());
        assertEquals("Spades", card.getSuit());
        assertEquals(1, card.getValue());
    }

    @Test
    public void testCardConstructorEdgeCase() {
        Card card = new Card("", "", 0);
        assertEquals("", card.getName());
        assertEquals("", card.getSuit());
        assertEquals(0, card.getValue());
    }

    @Test
    public void testCardEquals() {
        Card card1 = new Card("Ace", "Spades", 1);
        Card card2 = new Card("Ace", "Spades", 1);
        assertTrue(card1.equals(card2));
    }

    @Test
    public void testCardEqualsNull() {
        Card card1 = new Card("Ace", "Spades", 1);
        assertFalse(card1.equals(null));
    }

    @Test
    public void testCardEqualsDifferentType() {
        Card card1 = new Card("Ace", "Spades", 1);
        String notACard = "Not a Card";
        assertFalse(card1.equals(notACard));
    }

    @Test
    public void testDeckConstructor() {
        Card[] cards = new Card[] {
            new Card("Ace", "Spades", 1),
            new Card("2", "Spades", 2)
        };
        Deck deck = new Deck(cards);
        assertEquals(2, deck.size());
    }

    @Test
    public void testDeckDraw() {
        Card[] cards = new Card[] {
            new Card("Ace", "Spades", 1),
            new Card("2", "Spades", 2)
        };
        Deck deck = new Deck(cards);
        assertNotNull(deck.draw());
    }

    @Test
    public void testDeckDrawEmpty() {
        Card[] cards = new Card[] {};
        Deck deck = new Deck(cards);
        assertNull(deck.draw());
    }

    @Test
    public void testDeckShuffle() {
        Card[] cards = new Card[] {
            new Card("Ace", "Spades", 1),
            new Card("2", "Spades", 2)
        };
        Deck deck = new Deck(cards);
        deck.shuffle();
        assertEquals(2, deck.size());
    }


    @Test
    public void testDeckShuffleEmpty() {
        Card[] cards = new Card[] {};
        Deck deck = new Deck(cards);
        deck.shuffle();
        assertEquals(0, deck.size());
    }
  // ----- DiscardPile Tests -----
    @Test
    public void testDiscardPileConstructor() {
        Card[] cards = new Card[] {
            new Card("Ace", "Spades", 1),
            new Card("2", "Hearts", 2)
        };
        DiscardPile discardPile = new DiscardPile(cards);
        assertEquals(2, discardPile.size());
    }

    @Test
    public void testDiscardPileConstructorEmpty() {
        DiscardPile discardPile = new DiscardPile(new Card[] {});
        assertEquals(0, discardPile.size());
    }

    @Test
    public void testDiscardPileRemoveCardNotInPile() {
        DiscardPile discardPile = new DiscardPile(new Card[] {});
        Card cardNotInPile = new Card("Queen", "Clubs", 12);
        assertNull(discardPile.removeCard(cardNotInPile));
    }
 @Test
    public void testPlayerConstructor() {
        Card[] hand = new Card[] { new Card("Ace", "Spades", 1) };
        Player player = new Player("Alice", 25, hand);
        assertEquals("Alice", player.getName());
        assertEquals(25, player.getAge());
        assertEquals(1, player.size());
    }

    @Test
    public void testPlayerConstructorNullHand() {
        assertThrows(NullPointerException.class, () -> {
            new Player("Alice", 25, null);
        });
    }

    @Test
    public void testPlayerDraw() {
        Card[] hand = new Card[] {};
        Deck deck = new Deck(new Card[] { new Card("Ace", "Spades", 1) });
        Player player = new Player("Alice", 25, hand);
        player.draw(deck);
        assertEquals(1, player.size());
    }

   

    @Test
    public void testPlayerDiscardCard() {
        Card[] hand = new Card[] { new Card("Ace", "Spades", 1) };
        DiscardPile discardPile = new DiscardPile(new Card[] {});
        Player player = new Player("Alice", 25, hand);
        assertTrue(player.discardCard(new Card("Ace", "Spades", 1), discardPile));
        assertEquals(0, player.size());
        assertEquals(1, discardPile.size());
    }

    @Test
    public void testPlayerReturnCard() {
        Card[] hand = new Card[] { new Card("Ace", "Spades", 1) };
        Deck deck = new Deck(new Card[] {});
        Player player = new Player("Alice", 25, hand);
        assertTrue(player.returnCard(new Card("Ace", "Spades", 1), deck));
    }

    @Test
    public void testPlayerReturnCardNotInHand() {
        Card[] hand = new Card[] { new Card("Ace", "Spades", 1) };
        Deck deck = new Deck(new Card[] {});
        Player player = new Player("Alice", 25, hand);
        assertFalse(player.returnCard(new Card("King", "Diamonds", 13), deck));
    }

    @Test
    public void testPlayerDrawMultipleCards() {
        Card[] hand = new Card[] {};
        Deck deck = new Deck(new Card[] { new Card("Ace", "Spades", 1), new Card("King", "Diamonds", 13) });
        Player player = new Player("Alice", 25, hand);
        player.draw(deck);  // Draw Ace
        player.draw(deck);  // Draw King
        assertEquals(2, player.size());
    }
}
