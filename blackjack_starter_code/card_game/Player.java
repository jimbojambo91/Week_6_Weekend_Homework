package card_game;
import card_game.*;
import java.util.*;

public class Player {

  private String name;
  private static ArrayList<Card> hand = new ArrayList<Card>();

  public Player(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public void setHand(Card card1, Card card2){
    this.hand.add(card1);
    this.hand.add(card2);
  }

  public void addToHand(Card card){
    this.hand.add(card);
  }

  public ArrayList<Card> getHand(){
    return this.hand;
  }

  public String printHand(){
    return this.hand.get(0).toString() + ", " + this.hand.get(1).toString();
  }

  public int sumHand(){
    return this.hand.get(0).getNumber() + this.hand.get(1).getNumber();
  }

}