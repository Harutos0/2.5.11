import java.util.Scanner;
import java.util.Random;

public class nimRunner {
    public static void main(String[] args) {
      Player p1 = new Player(1);
      Player p2 = new Player(2);

      int i = 0;
      int j = 0;

      while(j==0){
        int numPieces = (int) (Math.random() * 40 + 10);
        Board game = new Board(numPieces);
        p1.resetScore();
        p2.resetScore();

        while(i==0){
          System.out.println("");
          System.out.println("There are " + Board.getPieces() + " pieces left.");
          System.out.println("");
          int player = Player.choosePlayer();
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
          else if (player == 1){
            System.out.println(p1.getName() + ". Your turn.");
            Board.checkPieces(p1);
          }
          else if (player == 2){
            System.out.println(p2.getName() + ". Your turn.");
            Board.checkPieces(p2);
          }
        }


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