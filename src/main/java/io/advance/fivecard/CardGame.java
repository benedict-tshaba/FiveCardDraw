package io.advance.fivecard;

import java.util.Collections;

public class CardGame {
  private Deck deck;
  private Hand hand;
  private IShuffler shuffler;

  public CardGame(String[] args, IShuffler shuffler) {
    int handSize = 5;

    if (args.length == 1) {
      handSize = Integer.parseInt(args[0]);
    }

    this.shuffler = shuffler;

    try {
      initGame();
      hand = deal(deck, handSize);
    } catch (IllegalAccessException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }

  private void initGame() {
    deck = new Deck();
    shuffle(deck);
  }

  private void shuffle(Deck deck) {
    if(shuffler != null) {
      shuffler.shuffle(deck);
    }
    else {
      Collections.shuffle(deck.getCards());
    }
  }

  private Hand deal(Deck deck, int cardsPerHand) throws IllegalAccessException {
    hand = new Hand(cardsPerHand);
    for (int i = 0; i < cardsPerHand; i++) {
      hand.addCard(deck.drawCard());
    }
    hand.sort();
    return hand;
  }

  public void setHand(Hand hand) {
    this.hand = hand;
  }

  public Hand getHand() {
    return hand;
  }

  public String evaluateHand() {
    hand.sort();
    if (hand.isStraightFlush()) {
      return Ranking.STRAIGHT_FLUSH.toString();
    } else if (hand.isFourOfAKind()) {
      return Ranking.FOUR_OF_A_KIND.toString();
    } else if (hand.isFullHouse()) {
      return Ranking.FULL_HOUSE.toString();
    } else if (hand.isFlush()) {
      return Ranking.FLUSH.toString();
    } else if (hand.isStraight()) {
      return Ranking.STRAIGHT_FLUSH.toString();
    } else if (hand.isThreeOfAKind()) {
      return Ranking.THREE_OF_A_KIND.toString();
    } else if (hand.isTwoPair()) {
      return Ranking.TWO_PAIR.toString();
    } else if (hand.isOnePair()) {
      return Ranking.ONE_PAIR.toString();
    } else {
      return Ranking.HIGH_CARD.toString();
    }
  }
}