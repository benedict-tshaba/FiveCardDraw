package io.advance.fivecard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hand {
  private List<Card> cards;
  private final int handSize;

  public Hand(int handSize) {
    cards = new ArrayList<>(handSize);
    this.handSize = handSize;
  }

  public void sort() {
    cards.sort((a, b) -> a.getRank().ordinal() - b.getRank().ordinal());
  }

  public void clear() {
    cards.clear();
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public void setCards(List<Card> cards) {
    if(cards.size() > handSize) {
      throw new ArrayIndexOutOfBoundsException("Attempt to add cards to a hand that cannot hold that many cards");
    }
    this.cards = cards;
  }

  public List<Card> getCards() {
    return cards;
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
    Collections.sort(cards, Comparator.comparing(Card::getRank));

    if ( cards.get(0).getRank() == Rank.ACE
      && cards.get(1).getRank() == Rank.TWO
      && cards.get(2).getRank() == Rank.THREE
      && cards.get(3).getRank() == Rank.FOUR
      && cards.get(4).getRank() == Rank.FIVE
    ) {
      return true;
    }

    for (int i = 1; i < cards.size(); i++) {
      if (cards.get(i).getRank().ordinal() != cards.get(i - 1).getRank().ordinal() + 1) {
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