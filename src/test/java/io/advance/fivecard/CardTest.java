package io.advance.fivecard;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for the Card class
 */
public class CardTest {
  private Card card;

  /**
   * Create the global test card
   */
  @BeforeEach
  public void createTestCard() {
    card = new Card(Suit.CLUBS, Rank.ACE);
  }

  /**
   * Implicitly unlink the card instance to free up time on the GC
   */
  @AfterEach
  public void cleanUp() {
    card = null;
  }

  /**
   * Should create a new card successfully
   */
  @Test
  public void shouldEnsureANewCardWithGivenRankAndSuit() {
    assertEquals(card.toString(), "A♣");
  }

  /**
   * Should return the correct rank of the card
   */
  @Test
  public void shouldEnsureThatTheRankIsCorrect() {
    assertEquals(card.getRank(), Rank.ACE);
  }

  /**
   * Should return the correct suit of the card
   */
  @Test
  public void shouldEnsureThatTheSuitIsCorrect() {
    assertEquals(card.getSuit(), Suit.CLUBS);
  }
}
