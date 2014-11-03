public class Queen extends Bishop
{
   public boolean checkAllQueenMoves(int row, int colum, char[][] board, char target)
   {
      if(checkAllBishopMoves(row, colum, board, target))
         return true; 
      else if(checkAllRookMoves(row, colum, board, target))
         return true; 
      else
         return false; 
   }
}