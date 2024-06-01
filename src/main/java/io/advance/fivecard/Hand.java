package io.advance.fivecard;

import java.util.ArrayList;
import java.util.List;

public class Hand {
  private ArrayList<Card> cards;
  private int handSize;

  public Hand(int handSize) {
    cards = new ArrayList<>(handSize);
    this.handSize = handSize;
  }

  public void sort() {
    cards.sort((a, b) -> a.getRank().ordinal() - b.getRank().ordinal());
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public void removeCard(int index) {
    cards.remove(index);
  }

  public void removeCard(Card card) {
    cards.remove(card);
  }

  public boolean isStraightFlush() {
    return isFlush() && isStraight();
  }

  public boolean isFourOfAKind() {
    return cards.get(0).getRank().equals(cards.get(3).getRank()) || cards.get(1).getRank().equals(cards.get(4).getRank());
  }

  public boolean isFullHouse() {
    return (cards.get(0).getRank().equals(cards.get(2).getRank()) && cards.get(3).getRank().equals(cards.get(4).getRank())) ||
        (cards.get(0).getRank().equals(cards.get(1).getRank()) && cards.get(2).getRank().equals(cards.get(4).getRank()));
  }

  public boolean isFlush() {
    Suit suit = cards.get(0).getSuit();
    for (Card card : cards) {
      if (!card.getSuit().equals(suit)) {
        return false;
      }
    }
    return true;
  }

  public boolean isStraight() {
    for (int i = 1; i < handSize; i++) {
      if (cards.get(i).getRank() != cards.get(i - 1).getRank()) {
        return false;
      }
    }
    return true;
  }

  public boolean isThreeOfAKind() {
    return (cards.get(0).getRank().equals(cards.get(2).getRank()) ||
        cards.get(1).getRank().equals(cards.get(3).getRank()) ||
        cards.get(2).getRank().equals(cards.get(4).getRank()));
  }

  public boolean isTwoPair() {
    return (cards.get(0).getRank().equals(cards.get(1).getRank()) && cards.get(2).getRank().equals(cards.get(4).getRank())) ||
        (cards.get(0).getRank().equals(cards.get(1).getRank()) && cards.get(3).getRank().equals(cards.get(4).getRank())) ||
        (cards.get(1).getRank().equals(cards.get(2).getRank()) && cards.get(3).getRank().equals(cards.get(4).getRank()));
  }

  public boolean isOnePair() {
    return (cards.get(0).getRank().equals(cards.get(1).getRank()) ||
        cards.get(1).getRank().equals(cards.get(2).getRank()) ||
        cards.get(2).getRank().equals(cards.get(3).getRank()) ||
        cards.get(3).getRank().equals(cards.get(4).getRank()));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int index = 0; index < cards.size(); index++) {
      sb.append(cards.get(index)).append(" ");
    }
    return sb.toString();
  }
}