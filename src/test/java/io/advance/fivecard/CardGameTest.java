package io.advance.fivecard;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for the CardGame class
 */
public class CardGameTest {
  private CardGame game;
  private Deck deck;

  /**
   * Create the global test deck
   */
  @BeforeEach
  public void createTestCardGame() {
    String[] args = {"5"};
    game = new CardGame(args, null);
    deck = new Deck();
  }

  /**
   * Implicitly unlink the card game instance to free up time on the GC
   */
  @AfterEach
  public void cleanUp() {
    game = null;
    deck = null;
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

  @Test
  void testInitGame() {
    assertNotNull(game.getHand());
  }

  @Test
  void testSimpleNaiveBayesShuffle() {
    assertNotEquals(deck.getCards(), game.getDeck().getCards());
  }
  
  @Test
  void testEvaluateHandStraightFlush() {
    Hand hand = new Hand(5);
    hand.setCards(Arrays.asList(
      new Card(Suit.HEARTS, Rank.NINE),
      new Card(Suit.HEARTS, Rank.KING),
      new Card(Suit.HEARTS, Rank.QUEEN),
      new Card(Suit.HEARTS, Rank.JACK),
      new Card(Suit.HEARTS, Rank.TEN)
    ));
    game.setHand(hand);
    assertEquals(Ranking.STRAIGHT_FLUSH.toString(), game.evaluateHand());
  }

  @Test
  void testEvaluateHandFullHouse() {
    Hand hand = new Hand(5);
    hand.setCards(Arrays.asList(
      new Card(Suit.SPADES, Rank.ACE),
      new Card(Suit.HEARTS, Rank.ACE),
      new Card(Suit.CLUBS, Rank.ACE),
      new Card(Suit.HEARTS, Rank.JACK),
      new Card(Suit.DIAMONDS, Rank.JACK)
    ));
    game.setHand(hand);
    assertEquals(Ranking.FULL_HOUSE.toString(), game.evaluateHand());
  }

  @Test
  void testEvaluateHandFlush() {
    Hand hand = new Hand(5);
    hand.setCards(Arrays.asList(
      new Card(Suit.SPADES, Rank.ACE),
      new Card(Suit.SPADES, Rank.ACE),
      new Card(Suit.SPADES, Rank.THREE),
      new Card(Suit.SPADES, Rank.FIVE),
      new Card(Suit.SPADES, Rank.FIVE)
    ));
    game.setHand(hand);
    assertEquals(Ranking.FLUSH.toString(), game.evaluateHand());
  }
}