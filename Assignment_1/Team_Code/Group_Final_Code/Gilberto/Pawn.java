public class Pawn extends Board
{
   public boolean checkBlackPawn(int row, int colum, char[][] board)
   {  
        if((verify(row+1, colum+1, board, 'K')) && (verify(row+1, colum-1, board, 'K')) )//check both possible moves are within board range
       {
            char possibleMoveOne = board[row+1][colum+1];
            char possibleMoveTwo = board[row+1][colum-1]; 
           
            if(possibleMoveOne == WHITE_KING)//compare possible moves to check mate 
            {
               System.out.println("White king in check");
               return true;
            }
            else if(possibleMoveTwo == WHITE_KING)
            {
               System.out.println("White king in check ");
               return true; 
            }
            else
            {
               return false; 
            }
       }
       else
       {
         return false;
       }
   }
   public boolean checkWhitePawn(int row, int colum, char[][] board)
   {
      if((verify(row-1, colum+1, board, 'k')) && (verify(row-1, colum-1, board, 'k')) )//check both possible moves are within board range
       {
            char possibleMoveOne = board[row-1][colum+1];
            char possibleMoveTwo = board[row-1][colum-1]; 
           
            if(possibleMoveOne == BLACK_KING)//compare possible moves to check mate 
            {
               System.out.println("Black king in check");
               return true;
            }
            else if(possibleMoveTwo == BLACK_KING)
            {
               System.out.println("Black king in check");
               return true; 
            }
            else
            {
               return false; 
            }
       }
       else
       {
         return false;
       }
   }
}