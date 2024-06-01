package io.advance.fivecard;

public enum Ranking {
  HIGH_CARD,
  STRAIGHT,
  ONE_PAIR,
  TWO_PAIR,
  THREE_OF_A_KIND,
  FLUSH,
  FULL_HOUSE,
  FOUR_OF_A_KIND,
  STRAIGHT_FLUSH,
  ROYAL_FLUSH,
  ;

  @Override
  public String toString() {
    String[] translations = {
      "High Card", "Straight", "One Pair", "Two Pair", "Three of a Kind", "Flush", "Full House", "Four of a Kind", "Straight Flush", "Royal Flush"
    };
    return  translations[this.ordinal()];
  }
}
