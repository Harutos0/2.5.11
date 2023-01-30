import java.util.Scanner;

public class Board {
    private static int boardPieces;

    public Board(int p){
        boardPieces = p;
    }

    public static int getPieces(){
        return boardPieces;
    }

    public static void takePieces(int pieces){
        boardPieces -= pieces;
    } 

    public static void checkPieces(Player p){
        Scanner input = new Scanner(System.in);
        System.out.println("How many pieces would you like to take?");
        int pieces = input.nextInt();

        if ((pieces <= boardPieces/2) && (pieces > 0)){
           Board.takePieces(pieces);
           p.setScore(pieces);
        }
        else{
            System.out.println("Sorry, please choose a number greater than 0 and less than or equal to half of the remaining pieces.");
            Board.checkPieces(p);
        }
        


    }
}
