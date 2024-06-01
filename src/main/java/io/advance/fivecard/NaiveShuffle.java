package io.advance.fivecard;

import java.util.Collections;

public class NaiveShuffle implements IShuffler {

  @Override
  public void shuffle(Deck deck) {
    Collections.shuffle(deck.getCards());
  }
  
}
