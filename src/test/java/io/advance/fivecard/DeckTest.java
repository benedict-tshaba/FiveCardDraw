package io.advance.fivecard;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for the Card class
 */
public class DeckTest {
  private Deck deck;

  /**
   * Create the global test deck
   */
  @BeforeEach
  public void createTestDeck() {
    deck = new Deck();
  }

  /**
   * Implicitly unlink the deck instance to free up time on the GC
   */
  @AfterEach
  public void cleanUp() {
    deck = null;
  }

  /**
   * Should return the king of spades as the first card
   */
  @Test
  public void shouldEnsureTheDeckCreatedAndFirstDrawIsKingOfSpades() throws IllegalAccessException {
    assertEquals(deck.drawCard().toString(), "K♠");
  }

  /**
   * Should have a deck of size 51 after draw
   */
  @Test
  public void shouldEnsureTheDeckHasSizeOf51AfterDraw() throws IllegalAccessException {
    Card card = deck.drawCard();
    assertNotNull(card);
    assertEquals(deck.size(), 51);
  }

  /**
   * An attempt to draw from an empty deck should throw
   */
  @Test
  public void shouldThrowExceptionIfYouDrawFromEmptyDeck() throws Exception {
    int deckSize = deck.size();

    for (int i = 0; i < deckSize; i++) {
      Card card = deck.drawCard();
    }

    Exception exception = assertThrows(IllegalAccessException.class, () -> {
      deck.drawCard();
    });

    String expectedMsg   = "Cannot draw a card from an empty deck";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMsg));
  }

  /**
   * Should return a new deck after refresh
   */
  @Test
  public void shouldReturnANewDeckAfterRefresh() throws IllegalAccessException{
    assertEquals(deck.drawCard().toString(), "K♠");
    deck.drawCard();
    deck.drawCard();
    deck.refreshDeck();
    assertEquals(deck.drawCard().toString(), "K♠");
  }
}