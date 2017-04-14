package card_game;

// import card_game.*;
import java.util.*;

public class Runner{
  public static void main(String[] args){

    Game game = new Game(); 
    Integer x = game.getPlayerCount();
    for(int i=1; i< (x+1); i++){
      game.getPlayerDetails();
    }
    game.deal();
    String winner = WinChecker.winningHand(game.getPlayers());
    System.out.println("The winner is " + winner);
}
}