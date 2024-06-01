package io.advance.fivecard;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for the CardGame class
 */
public class CardGameTest {
  private CardGame game;

  /**
   * Create the global test deck
   */
  @BeforeEach
  public void createTestCardGame() {
    String[] args = {"5"};
    game = new CardGame(args, null);
  }

  /**
   * Implicitly unlink the card game instance to free up time on the GC
   */
  @AfterEach
  public void cleanUp() {
    game = null;
  }

  /**
   * Should return the flush when evaluating
   */
  @Test
  public void shouldReturnTheFlushWhenEvaluating() {
    //quickly deal a new hand
    Hand hand = new Hand(5);
    hand.addCard(new Card(Suit.SPADES, Rank.ACE));
    hand.addCard(new Card(Suit.SPADES, Rank.TWO));
    hand.addCard(new Card(Suit.SPADES, Rank.THREE));
    hand.addCard(new Card(Suit.SPADES, Rank.FOUR));
    hand.addCard(new Card(Suit.SPADES, Rank.FIVE));
    game.setHand(hand);
    assertEquals(game.evaluateHand(), Ranking.FLUSH.toString());
  }

  /**
   * Should return the One Pair when evaluating
   */
  @Test
  public void shouldReturnTheOnePairWhenEvaluating() {
    //quickly deal a new hand
    Hand hand = new Hand(5);
    hand.addCard(new Card(Suit.CLUBS, Rank.KING));
    hand.addCard(new Card(Suit.SPADES, Rank.ACE));
    hand.addCard(new Card(Suit.DIAMONDS, Rank.ACE));
    hand.addCard(new Card(Suit.HEARTS, Rank.QUEEN));
    hand.addCard(new Card(Suit.SPADES, Rank.TEN));
    game.setHand(hand);
    assertEquals(game.evaluateHand(), Ranking.ONE_PAIR.toString());
  }
}