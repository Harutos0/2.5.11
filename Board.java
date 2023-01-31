import java.util.Scanner;

public class Board {
    private static int boardPieces;

    // Constructor
    public Board(int p){
        boardPieces = p;
    }

    // Accesor
    public static int getPieces(){
        return boardPieces;
    }

    // Subtracts an intended amount from the remaining pieces
    public static void takePieces(int pieces){
        boardPieces -= pieces;
    } 

    // A method to decide what kind of game a user is palying
    public static String gameMode(){
        Scanner input = new Scanner (System.in);
        System.out.println("Would you like to play with a computer or two player? (1/2)");
        String gameMode = input.nextLine();
        return gameMode;
    }

    // Checks to see if the inputted value is valid and calls takePieces if true
    public static void checkPieces(Player p){
        try{
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
        catch (Exception e){
            System.out.println("Sorry, please choose a number greater than 0 and less than or equal to half of the remaining pieces.");
            Board.checkPieces(p);
        }
    }

    public static void checkPieces(Player p, int i){
        if ((i <= boardPieces/2) && (i > 0)){
           Board.takePieces(i);
           p.setScore(i);
        }
    }
}
