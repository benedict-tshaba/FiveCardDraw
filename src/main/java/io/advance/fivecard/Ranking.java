package io.advance.fivecard;

public enum Ranking {
  HIGH_CARD("High Card"),
  STRAIGHT("Straight"),
  ONE_PAIR("One Pair"),
  TWO_PAIR("Two Pair"),
  THREE_OF_A_KIND("Three of a Kind"),
  FLUSH("Flush"),
  FULL_HOUSE("Full House"),
  FOUR_OF_A_KIND("Four of a Kind"),
  STRAIGHT_FLUSH("Straight Flush"),
  ROYAL_FLUSH("Royal Flush");
  
  private final String value;

  Ranking(String value) {
      this.value = value;
  }

  @Override
  public String toString() {
      return value;
  }
}
