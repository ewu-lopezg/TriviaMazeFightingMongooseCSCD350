public class Bishop extends Rook 
{
   public boolean checkAllBishopMoves(int row, int colum, char[][] board, char target)
   {
      if(checkUpwardRight(row-1, colum+1, board, target))
         return true; 
      else if(checkUpwardLeft(row-1, colum-1, board, target))
         return true; 
      else if(checkDownwardRight(row+1, colum+1, board, target))
         return true; 
      else if(checkDownwardLeft(row+1, colum-1, board, target))
         return true;
      else 
         return false; 
   }
   public boolean checkUpwardRight(int row, int colum, char[][] board, char target)
   {
     while(0 <= row && colum < board[row].length && verify(row, colum, board,target))
     {
         if(board[row][colum] == target)
         {
             printOutput(target);
             return true; 
         }
         row--; 
         colum++;
     }
      return false; 
   }
   
   public boolean checkUpwardLeft(int row, int colum, char[][] board, char target)
   {
     while(0 <= row && 0 <= colum && verify(row, colum, board,target))
     {
         if(board[row][colum] == target)
         {
             printOutput(target);
             return true; 
         }
         row--; 
         colum--;
     }
      return false; 
   }
   
   public boolean checkDownwardRight(int row, int colum, char[][] board, char target)
   {
       while(row < board.length && colum < board[row].length && verify(row, colum, board,target))
       {
         if(board[row][colum] == target)
         {
             printOutput(target);
             return true; 
         }
         row++; 
         colum++;
       }
      return false; 
   }
   
   public boolean checkDownwardLeft(int row, int colum, char[][] board, char target)
   {
      while(row < board.length && 0 <= colum && verify(row, colum, board,target))
      {
         if(board[row][colum] == target)
         {
             printOutput(target);
             return true; 
         }
         row++; 
         colum--;
      }
      return false; 
   }
}