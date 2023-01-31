import java.util.Random;
import java.util.Scanner;

public class Player {

  private String name;
  private int score;
  public static int activePlayer;
  public int gameScore = 0;
  private int overallScore = 0;

  // Constructor
  public Player(int n){
    Scanner input = new Scanner (System.in);
    System.out.println("What is your name Player " + n + "?");
    String username = input.nextLine();
    this.name = username;
    this.score = 0;
  }

  public Player(){
    this.name = "Computer";
    this.score = 0;
  }

  // Mutator
  public void setName(String n){
    this.name = n;
  }

  // Accessor
  public String getName(){
    return this.name;
  }

  // Mutator
  public void setScore(int increment){
    this.score += increment;
  }

  // Accessor
  public int getScore(){
    return this.score;
  }

  // Mutator
  public void setGameScore(int increment){
    this.gameScore += increment;
  }

  // Accessor
  public int getGameScore(){
    return this.gameScore;
  }

  // Mutator
  public void setOverallScore(int increment){
    this.overallScore += increment;
  }

  // Accessor
  public int getOverallScore(){
    return this.overallScore;
  }
  
  public void resetScore(){
    this.score = 0;
  }

  public static void switchPlayer(){
    if (activePlayer == 1) {
      activePlayer = 2;
    }
    else {
      activePlayer = 1;
    }
  }

  // Randomly choosing a player per round
  public static int choosePlayer(){
    activePlayer = (int) (Math.random() * 2 + 1);
    return activePlayer;
  }

}