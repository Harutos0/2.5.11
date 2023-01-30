import java.util.Random;
import java.util.Scanner;

public class Player {

  private String name;
  private int score;
  public static int activePlayer;
  public int gameScore = 0;
  private int overallScore = 0;

  public Player(int n){
    Scanner input = new Scanner (System.in);
    System.out.println("What is your name Player " + n + "?");
    String username = input.nextLine();
    this.name = username;
    this.score = 0;
  }

  public void setName(String n){
    this.name = n;
  }

  public String getName(){
    return this.name;
  }

  public void setScore(int increment){
    this.score += increment;
  }

  public int getScore(){
    return this.score;
  }

  public void setGameScore(int increment){
    this.gameScore += increment;
  }

  public int getGameScore(){
    return this.gameScore;
  }

  public void setOverallScore(int increment){
    this.overallScore += increment;
  }

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

  public static int choosePlayer(){
    activePlayer = (int) (Math.random() * 2 + 1);
    return activePlayer;
  }

}