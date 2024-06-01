package io.advance.fivecard;

/**
 * Five Card Poker
 *
 */
public class App {
  public static void main(String[] args) throws IllegalAccessException {
    CardGame game = new CardGame(args, new NaiveShuffle());
    CommandLineUI cmd = new CommandLineUI(game);
    cmd.simulateShuffle();
    cmd.display();
  }
}
