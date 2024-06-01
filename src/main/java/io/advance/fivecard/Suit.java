package io.advance.fivecard;

public enum Suit {
  HEARTS,
  DIAMONDS,
  CLUBS,
  SPADES,
  ;

  @Override
  public String toString() {
    String[] suitIcons = {"♥", "♦", "♣", "♠"};
    return suitIcons[this.ordinal()];
  }
}
