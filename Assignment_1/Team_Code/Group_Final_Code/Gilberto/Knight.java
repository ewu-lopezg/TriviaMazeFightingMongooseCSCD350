public class Knight extends Board
{
   public boolean checkAllKnightMoves(int row, int colum, char[][] board, char target)
   {
      if(checkUpwardLeft(row-2, colum-1, board, target))
         return true; 
      else if(checkRightUp(row-1, colum+2, board, target))
         return true;
      else if(checkRightDown(row+1, colum+2, board, target))
         return true;
      else if(checkLeftUp(row-1, colum-2, board, target))
         return true;
      else if(checkLeftDown(row+1, colum-2, board, target))
         return true;
      else if(checkUpwardRight(row-2, colum+1, board, target))
         return true;
      else if(checkDownRight(row+2, colum+1, board, target))
         return true;
      else if(checkDownLeft(row+2, colum-1, board, target))
         return true;
      return false; 
   }
   public boolean checkUpwardLeft(int row, int colum, char[][] board, char target)
   {
      if(0 <= row && 0 <= colum && verify(row, colum, board,target))
      {         
         if(board[row][colum] == target)
         {
            printOutput(target);
            return true;
         }
         row -= 2;
         colum--;
      }
      return false; 
   }
   
   public boolean checkUpwardRight(int row, int colum, char[][] board, char target)
   {
      if(0 <= row && colum < board[row].length && verify(row, colum, board,target))
      {         
         if(board[row][colum] == target)
         {
            printOutput(target);
            return true;
         }
         row -= 2;
         colum++;
      }
      return false; 
   }
   
   public boolean checkLeftUp(int row, int colum, char[][] board, char target)
   {
      if(0 <= row && colum < board[row].length && verify(row, colum, board,target))
      {
         if(board[row][colum] == target)
         {
            printOutput(target);
            return true;
         }
         row --;
         colum -= 2;
      }
      return false; 
   }
   
   public boolean checkLeftDown(int row, int colum, char[][] board, char target)
   {
      if(row < board.length && 0 <= colum && verify(row, colum, board,target))
      {         
         if(board[row][colum] == target)
         {
            printOutput(target);
            return true;
         }
         row++;
         colum -= 2;
      }
      return false; 
   }
   
   public boolean checkRightUp(int row, int colum, char[][] board, char target)
   {
      if(0 <= row && colum < board[row].length && verify(row, colum, board,target))
      {
         if(board[row][colum] == target)
         {
            printOutput(target);
            return true;
         }
         row--;
         colum += 2;
      }
      return false; 
   }
   
   public boolean checkRightDown(int row, int colum, char[][] board, char target)
   {
      if(row < board.length && colum < board[row].length && verify(row, colum, board,target))
      {         
         if(board[row][colum] == target)
         {
            printOutput(target);
            return true;
         }
         row++;
         colum += 2;
      }
      return false; 
   }
   
   public boolean checkDownRight(int row, int colum, char[][] board, char target)
   {
      if(row < board.length && colum < board[row].length && verify(row, colum, board,target))
      {         
         if(board[row][colum] == target)
         {
            printOutput(target);
            return true;
         }
         row += 2;
         colum++;
      }
      return false; 
   }
   
   public boolean checkDownLeft(int row, int colum, char[][] board, char target)
   {
      if(row < board.length && 0 <= colum && verify(row, colum, board,target))
      {         
         if(board[row][colum] == target)
         {
            printOutput(target);
            return true;
         }
         row += 2;
         colum--;
      }
      return false; 
   }
}