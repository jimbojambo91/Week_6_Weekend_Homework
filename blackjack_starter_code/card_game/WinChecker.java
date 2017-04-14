package card_game;

import card_game.*;
import java.util.*;

public class WinChecker {

  static public String winningHand(ArrayList<Player> players){

    Player winningPlayer = players.get(0);

    for (Player player : players){
      if(winningPlayer.sumHand() < player.sumHand()){
        winningPlayer = player;
      }
    }

    return winningPlayer.getName();
  }

}