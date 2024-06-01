package io.advance.fivecard;

public class CommandLineUI implements IDisplay {
  private CardGame game;

  public CommandLineUI(CardGame game) {
    this.game = game;
  }

  @Override
  public void simulateShuffle() {
    for (int i = 0; i < 3; i++) {
      System.out.print("Shuffling... ");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        //Chances of this happening are slim - And we' be in very deep trouble in any case
        System.err.println(e.getMessage());
        System.exit(1);
      }
    }
    System.out.println();
  }

  @Override
  public void display() {
    System.out.println("Your Hand: " + game.getHand());
    System.out.println("You Have: " + game.evaluateHand());
  }
}
