public class Board
{
	final char WHITE_PAWN = 'P';
   final char BLACK_PAWN = 'p';
   final char WHITE_KNIGHT = 'N';
   final char BLACK_KNIGHT = 'n';
   final char WHITE_BISHOP = 'B'; 
   final char BLACK_BISHOP = 'b';
   final char WHITE_ROOK = 'R'; 
   final char BLACK_ROOK = 'r';
   final char WHITE_QUEEN = 'Q'; 
   final char BLACK_QUEEN = 'q'; 
   final char WHITE_KING = 'K';
   final char BLACK_KING = 'k';
   
   private static Pawn pawn = new Pawn();
   private static Rook rook = new Rook();
   private static Bishop bishop = new Bishop();
   private static Knight knight = new Knight();
   private static Queen queen = new Queen();
   
   boolean bomb;
   boolean found = false;
	
	public void printOutput(char target)
   {
      if(target == BLACK_KING)
         System.out.println("Black king is in check");
      if(target == WHITE_KING)
         System.out.println("White king is in check");
      
   }
   
   public boolean executeCheck(int row,int colum, char[][] board)
   {
      char letter = board[row][colum];
      
      switch(letter)
      {
         case WHITE_PAWN: 
            found = pawn.checkWhitePawn(row ,colum ,board);
            break; 
         case BLACK_PAWN:
            found = pawn.checkBlackPawn(row ,colum ,board);
            break;  
         case WHITE_KNIGHT:
            found = knight.checkAllKnightMoves(row, colum, board, BLACK_KING);
            break;  
         case BLACK_KNIGHT:
            found = knight.checkAllKnightMoves(row, colum, board, WHITE_KING);
            break;  
         case WHITE_BISHOP:
            found = bishop.checkAllBishopMoves(row, colum, board, BLACK_KING);
            break;  
         case BLACK_BISHOP:
            found = bishop.checkAllBishopMoves(row, colum, board, WHITE_KING);
            break;  
         case WHITE_ROOK:
            found = rook.checkAllRookMoves(row, colum, board, BLACK_KING);
            break;  
         case BLACK_ROOK:
            found = rook.checkAllRookMoves(row, colum, board, WHITE_KING);
            break; 
         case WHITE_QUEEN:
            found = queen.checkAllQueenMoves(row, colum, board, BLACK_KING);
            break;  
         case BLACK_QUEEN:
            found = queen.checkAllQueenMoves(row, colum, board, WHITE_KING);
            break; 
         case WHITE_KING:
            found = false; 
            break; 
         case BLACK_KING:
            found = false; 
            break;
      }  
      return found;
   }
   
   public boolean verify(int row, int colum, char[][] board, char target)
   {  
      boolean clear = check(row, colum, board); 
      
      if(!clear)
      {
         return false; 
      }
      
      boolean empty = isEmpty(row, colum, board, target); 
      
      if(!empty)
      {
         return false;
      }
      return true;
   }
   
   public boolean isEmpty(int row, int colum, char[][] board, char target)
   {
      char holder = board[row][colum];
      if(holder != '.' && holder != target)
         return false;   
      return true;
   }
   
   public boolean check(int row, int colum, char[][] board)
	{
		try
		{
			char temp = board[row][colum];
		}
		catch(IndexOutOfBoundsException e )
		{
			return false; 
		}
		return true;
	}
   
	public boolean checkCurrentPossition(int row, int colum, char[][]board)
	{
		if(board[row][colum] == '.')
		{
			return true; 
		}
		return false; 
	}
//----------------------------------------------------------------------------------------------------------------------------------------	
	
}
