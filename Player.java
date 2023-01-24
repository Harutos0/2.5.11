import java.util.Random;

public class Player {

  private String name;
  private int score;
  public static int activePlayer;

  public Player(String n){
    this.name = n;
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

  public static void switchPlayer(){
    if (activePlayer == 1) {
      activePlayer = 2;
    }
    else {
      activePlayer = 1;
    }
  }

  public static void choosePlayer(){
    activePlayer = (int) (Math.random() * 2);
    System.out.println(activePlayer);
  }

}