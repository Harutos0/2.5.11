import java.util.Scanner;
import java.util.Random;
import java.util.Date; 
import java.util.concurrent.TimeUnit;


public class nimRunner {
    public static void main(String[] args) {
      while(true){
      String type = Board.gameMode();

      // For one player
      if (type.equals("1")){
        int i = 0;
        int j = 0;

        Player p1 = new Player(1);
        Player comp = new Player();

        // A loop for a game
        while(j==0){
          int numPieces = (int) (Math.random() * 40 + 10);
          Board game = new Board(numPieces);

          // A loop for actions during a game
          while(i==0){
            System.out.println("");
            System.out.println("There are " + Board.getPieces() + " pieces left.");
            System.out.println("");
            int player = Player.choosePlayer();
            // Ending games
            if (Board.getPieces() == 1){
              if (player == 1){
                System.out.println(p1.getName()+ " loses.");
                comp.setGameScore(1);
              }
              else{
                System.out.println(comp.getName()+ " loses.");
                p1.setGameScore(1);
              }
              i ++;
            }
            // Taking pieces from a pile for each player objects
            else if (player == 1){
              System.out.println(p1.getName() + ". Your turn.");
              Board.checkPieces(p1);
            }
            else if (player == 2){
              System.out.println(comp.getName() + "\'s turn.");
              int piec = (int) (Math.random() * (Board.getPieces()/2 - 1) +1);
              Board.checkPieces(comp, piec);
              try {
                Thread.sleep(1000);
              }
              catch(InterruptedException ex)
              {
                  ex.printStackTrace();
              }
              System.out.println("Computer took " + piec);
            }
          }
  
          // Prinitng out scores
          if (p1.getScore() > comp.getScore()){
            System.out.println("Score:");
            System.out.println(p1.getName() + " scored higher with " + p1.getScore() + " points");
          }
          if (comp.getScore() > p1.getScore()){
            System.out.println("Score:");
            System.out.println(comp.getName() + " scored higher with " + comp.getScore() + " points");
          }
          if (p1.getScore() == comp.getScore()){
            System.out.println("Score:");
            System.out.println(p1.getName() + " and " + comp.getName() + " got the same points of " + p1.getScore());
          }
          p1.setOverallScore(p1.getScore());
          comp.setOverallScore(comp.getScore());
  
          // Asking the  player whether he or she would like to play again
          Scanner again = new Scanner (System.in);
          System.out.println("Would you like to play again?(y/n) ");
          String playagain = again.nextLine();
          if (playagain.equals("y")){
            i = 0;
            System.out.println("");
          }
          else{
            System.out.println("Thank you for playing.");
            System.out.println("FINAL SCORES: ");
            System.out.println(p1.getName()+ ": " + (p1.getOverallScore() + (p1.getGameScore()*20)));
            System.out.println(comp.getName()+ ": " + (comp.getOverallScore()  + (comp.getGameScore()*20)));
        
            j++;
          }
        }
      }

      // For 2 player
      else if (type.equals("2")){
        // Initiates Player names
        Player p1 = new Player(1);
        Player p2 = new Player(2);

        // Two integer variables for loops
        int i = 0;
        int j = 0;

        // A loop for a game
        while(j==0){
          // randomize number of pieces from 10-50
          int numPieces = (int) (Math.random() * 40 + 10);
          Board game = new Board(numPieces);
          // Resets players point to zero to restart the game
          p1.resetScore();
          p2.resetScore();

          // A loop running until the game ends
          while(i==0){
            System.out.println("");
            System.out.println("There are " + Board.getPieces() + " pieces left.");
            System.out.println("");
            int player = Player.choosePlayer();
            // Ending games
            if (Board.getPieces() == 1){
              if (player == 1){
                System.out.println(p1.getName()+ " loses.");
                p2.setGameScore(1);
              }
              else{
                System.out.println(p2.getName()+ " loses.");
                p1.setGameScore(1);
              }
              i ++;
            }
            // Taking pieces from a pile for each player objects
            else if (player == 1){
              System.out.println(p1.getName() + ". Your turn.");
              Board.checkPieces(p1);
            }
            else if (player == 2){
              System.out.println(p2.getName() + ". Your turn.");
              Board.checkPieces(p2);
            }
          }

          // Prinitng out scores
          if (p1.getScore() > p2.getScore()){
            System.out.println("Score:");
            System.out.println(p1.getName() + " scored higher with " + p1.getScore() + " points");
          }
          if (p2.getScore() > p1.getScore()){
            System.out.println("Score:");
            System.out.println(p2.getName() + " scored higher with " + p2.getScore() + " points");
          }
          if (p1.getScore() == p2.getScore()){
            System.out.println("Score:");
            System.out.println(p1.getName() + " and " + p2.getName() + " got the same points of " + p1.getScore());
          }
          p1.setOverallScore(p1.getScore());
          p2.setOverallScore(p2.getScore());

          // Asking the  player whether he or she would like to play again
          Scanner again = new Scanner (System.in);
          System.out.println("Would you like to play again?(y/n) ");
          String playagain = again.nextLine();
          if (playagain.equals("y")){
            i = 0;
            System.out.println("");
          }
          else{
            System.out.println("Thank you for playing.");
            System.out.println("FINAL SCORES: ");
            System.out.println(p1.getName()+ ": " + (p1.getOverallScore() + (p1.getGameScore()*20)));
            System.out.println(p2.getName()+ ": " + (p2.getOverallScore()  + (p2.getGameScore()*20)));
        
            j++;
          }
        }
      }
    }
  }
}