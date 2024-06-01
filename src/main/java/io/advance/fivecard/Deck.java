package io.advance.fivecard;

import java.util.List;
import java.util.ArrayList;

public class Deck {
  private List<Card> deck;

  public Deck() {
    deck = new ArrayList<>();
    init();
  }

  private void init() {
    deck.clear();

    for (Suit suit : Suit.values()) {
      for(Rank rank : Rank.values()) {
        deck.add(new Card(suit, rank));
      }
    }
  }

  public List<Card> getCards() {
    return deck;
  }

  public void refreshDeck() {
    init();
  }

  public Card drawCard() throws IllegalAccessException {
    if(deck.isEmpty()) {
      throw new IllegalAccessException("Cannot draw a card from an empty deck");
    }
    return deck.remove(deck.size() - 1);
  }

  public void print() {
    System.out.println(deck);
  }

  public int size() {
    return deck.size();
  }
}