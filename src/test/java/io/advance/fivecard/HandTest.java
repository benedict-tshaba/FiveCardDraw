package io.advance.fivecard;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.advance.fivecard.Rank.FOUR;

public class HandTest {
  private Hand hand;

  /**
   * Create the global test card
   */
  @BeforeEach
  public void createTestCard() {
    hand = new Hand(5);
  }

  /**
   * Implicitly unlink the card instance to free up time on the GC
   */
  @AfterEach
  public void cleanUp() {
    hand = null;
  }
  
  @Test
  void testSort() {
    hand.addCard(new Card(Suit.DIAMONDS, Rank.KING));
    hand.addCard(new Card(Suit.CLUBS, Rank.QUEEN));
    hand.addCard(new Card(Suit.SPADES, Rank.JACK));
    hand.addCard(new Card(Suit.HEARTS, Rank.TEN));
    hand.addCard(new Card(Suit.HEARTS, Rank.ACE));

    hand.sort();
    
    assertEquals(Rank.ACE, hand.getCards().get(0).getRank());
    assertEquals(Rank.KING, hand.getCards().get(4).getRank());
    assertEquals(Rank.TEN, hand.getCards().get(1).getRank());
    assertEquals(Rank.JACK, hand.getCards().get(2).getRank());
    assertEquals(Rank.QUEEN, hand.getCards().get(3).getRank());
  }

  @Test
  void testHandEvaluation() {
    hand.setCards(Arrays.asList(
      new Card(Suit.HEARTS, Rank.ACE),
      new Card(Suit.HEARTS, Rank.FIVE),
      new Card(Suit.HEARTS, Rank.THREE),
      new Card(Suit.HEARTS, Rank.TWO),
      new Card(Suit.HEARTS, Rank.FOUR)
    ));
    hand.sort();
    assertTrue(hand.isStraightFlush());
    assertFalse(hand.isFourOfAKind());
    assertFalse(hand.isFullHouse());
    assertTrue(hand.isFlush());
    assertTrue(hand.isStraight());
    assertFalse(hand.isThreeOfAKind());
    assertFalse(hand.isTwoPair());
    assertFalse(hand.isOnePair());
  }
}
