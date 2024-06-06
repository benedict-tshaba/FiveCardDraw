package io.advance.fivecard;

public enum Suit {
  HEARTS("♥"),
  DIAMONDS("♦"),
  CLUBS("♣"),
  SPADES("♠");
  
  private final String value;

  Suit(String value) {
      this.value = value;
  }

  @Override
  public String toString() {
      return value;
  }
}
