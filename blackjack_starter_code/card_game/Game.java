package card_game;
// import card_game.*;

import java.util.*;

public class Game {

  private ArrayList<Player> players = new ArrayList<Player>();
  private static ArrayList<Card> deck = new ArrayList<Card>();
  private WinChecker winChecker = new WinChecker();

  public void buildDeck(){
    for (int i=1; i<14; i++) {
      for(Suit suit : Suit.values()){
        deck.add(new Card(i, suit));
      }
    }
    shuffleDeck();
  }

  public Game(){
    buildDeck();
  }

  public void shuffleDeck(){
    Collections.shuffle(deck);
  }

  public ArrayList<Card> getDeck(){
    return this.deck;
  }

  public Integer getPlayerCount(){
    Integer playerCounter = 0;
    System.out.println("Please enter player numbers from 2-7");
    Scanner scanner = new Scanner(System.in);
    playerCounter = Integer.parseInt(scanner.nextLine());
    return playerCounter;
  }

  public void getPlayerDetails(){
    int counter = (players.size()) +1;
    System.out.println("Player " + counter + ", Enter Name: ");
    Scanner scanner = new Scanner(System.in);
    Player player = new Player(scanner.nextLine());
    addPlayer(player);
  }


  public void addPlayer(Player player){
    players.add(player);
  }

  public ArrayList<Player> getPlayers(){
    return players;
  }

  public int playerCount(){
    return players.size();
  }

  public void twist(Player player){
    player.addToHand(deck.get(0));
    deck.remove(0);
  }

  public void deal(){
    for (Player player : this.players){
      player.setHand(deck.get(0), deck.get(1));
      deck.remove(0);
      deck.remove(0);
    } 
  }

  public void isBust(Player player){
    int total = player.sumHand();
    if(total > 21){
      System.out.println("Sorry" + player.getName() + " you are bust");
      this.players.remove(player);
    }
  }

  public void stickOrTwist(){
    for (Player player : this.players){
      System.out.println(player.getName() + " has " + player.printFirstHand() + " a total of " + player.sumHand());
      System.out.println("Would you like to stick or twist?");
      Scanner scanner = new Scanner(System.in);
      String response = scanner.nextLine();
      if(response == "twist"){
        twist(player);
        System.out.println(player.getName() + " has " + player.printHand() + " a total of " + player.sumHand());
        isBust(player);
      }
    }
  }
}