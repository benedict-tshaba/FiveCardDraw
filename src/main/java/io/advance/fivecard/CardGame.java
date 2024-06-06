package io.advance.fivecard;

import java.util.List;
import java.util.Random;

public class CardGame {
  private Deck deck;
  private Hand hand;
  private IShuffler shuffler;
  private static final Random RANDOM = new Random();

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

  private void swap(List<Card> cards, int i, int j) {
    Card temp = cards.get(i);
    cards.set(i, cards.get(j));
    cards.set(j, temp);
  }

  private void simpleNaiveBayes(List<Card> cards) {
    for(int i = cards.size() - 1; i > 0; i--) {
      int j = RANDOM.nextInt(i + 1);
      swap(cards, i, j);
    }
  }

  private void shuffle(Deck deck) {
    if(shuffler != null) {
      shuffler.shuffle(deck);
    }
    else {
      simpleNaiveBayes(deck.getCards());
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

  public void setDeck(Deck deck) {
    this.deck = deck;
  }

  public Deck getDeck() {
    return deck;
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