public class Rook extends Board
{
   public boolean checkAllRookMoves(int row, int colum, char[][] board, char target)
   {  
      if(checkLeft(row, colum-1, board, target))
         return true; 
      else if(checkRight(row, colum+1, board, target))
         return true; 
      else if(checkUp(row-1, colum, board, target))
         return true; 
      else if(checkDown(row+1, colum, board, WHITE_KING))
         return true; 
      else 
         return false; 
   }
   
   public boolean checkLeft(int row, int colum, char[][] board, char target)
   {
      while(0 <= colum && verify(row, colum, board, target))
      {  
         if(board[row][colum] == target)
         {
            printOutput(target);
            return true; 
         }
         colum--; 
      }
      return false; 
   }
   
   public boolean checkRight(int row, int colum, char[][] board, char target)
   {
      while(colum < board[row].length && verify(row, colum, board ,target))
      {         
         if(board[row][colum] == target)
         {
            printOutput(target);
            return true;
         }
         colum++;
      }
      return false; 
   }
   
   public boolean checkUp(int row, int colum, char[][] board, char target)
   {
      while(0 <= row && verify(row, colum, board,target))
      {
         if(board[row][colum] == target)
         {
            printOutput(target);
            return true;  
         }
         row--;
      }
      return false; 
   }
   
   public boolean checkDown(int row, int colum, char[][] board, char target)
   {
      while(row < board.length && verify(row, colum, board,target))
      {         
         if(board[row][colum] == target)
         {
            printOutput(target);
            return true;
         }
         row++;
      }
      return false; 
   }
}