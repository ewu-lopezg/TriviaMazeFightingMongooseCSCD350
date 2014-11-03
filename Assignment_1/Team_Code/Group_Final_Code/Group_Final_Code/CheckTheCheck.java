/**  
* @author Mohammed Al-Hamlan
* @author Mason Varias
* @author Gilberto Lopez
* Assignment# 2
* 10/3/2014
* CheckTheCheck.java - One class to solve the movement of chess
* peices and testing if the king is inchek.  
*/

import java.io.*; 
import java.util.*;


public class CheckTheCheck
{

   static char[][] board;
   static boolean stop;
   static int whiteKingi ; 
   static int whiteKingj ; 
   static int blackKingi ; 
   static int blackKingj;
	
	/**  
    * @return if White move is found than returns true, otherwise return false  
    * 
    */ 
   private static boolean checkWhite( )                      
   {
      int i = whiteKingi, j = whiteKingj ; 
   	
      // Moves for knight
      if( i-2 >= 0 && j-1 >= 0 && board[i-2][j-1] == 'n' ) 
         return true;
      if( i-1 >= 0 && j-2 >= 0 && board[i-1][j-2] == 'n' ) 
         return true;
      if( i+1  < 8 && j-2 >= 0 && board[i+1][j-2] == 'n' ) 
         return true;
      if( i+2  < 8 && j-1 >= 0 && board[i+2][j-1] == 'n' ) 
         return true;
      if( i-2 >= 0 && j+1  < 8 && board[i-2][j+1] == 'n' ) 
         return true;
      if( i-1 >= 0 && j+2  < 8 && board[i-1][j+2] == 'n' ) 
         return true;
      if( i+1  < 8 && j+2  < 8 && board[i+1][j+2] == 'n' ) 
         return true;
      if( i+2  < 8 && j+1  < 8 && board[i+2][j+1] == 'n' ) 
         return true;
   	
   	// Moves for pawn
      if( i-1 >= 0 && j-1 >= 0 && board[i-1][j-1] == 'p') 
         return true;
      if( i-1 >= 0 && j+1  < 8 && board[i-1][j+1] == 'p') 
         return true;
   	
   	// Moves for rook and queen
      boolean found = false;
      for (int k = j; k >=0 && !found ; k--)
      {
         if( board[i][k] != 'r' && board[i][k] != 'q' &&  board[i][k] != '.' && board[i][k] != 'K')
            found = true;
         if( board[i][k] == 'r' || board[i][k] == 'q' )
            return true;
      }
      
      found = false;
      for (int k = i; k >=0 && !found; k--)
      {
         if( board[k][j] != 'r' && board[k][j] != 'q' &&  board[k][j] != '.' && board[k][j] != 'K')
            found = true;
         if( board[k][j] == 'r' || board[k][j] == 'q' ) 
            return true;
      }
      
      found = false;
      for (int k = i; k < 8 && !found; k++)
      {
         if( board[k][j] != 'r' && board[k][j] != 'q' &&  board[k][j] != '.' && board[k][j] != 'K')
            found = true;
         if( board[k][j] == 'r' || board[k][j] == 'q' ) 
            return true;
      }
      
      found = false;
      for (int k = j; k < 8 && !found; k++)
      {
         if( board[i][k] != 'r' && board[i][k] != 'q' &&  board[i][k] != '.' && board[i][k] != 'K')
            found = true;
         if( board[i][k] == 'r' || board[i][k] == 'q' )
            return true;
      }
   	
   	// Moves for bishop and queen
      found = false;
      for (int k = i, l = j ; k >=0 && l>=0 && !found; k--, l--)
      {
         if( board[k][l] != 'b' && board[k][l] != 'q' && board[k][l] != '.' && board[k][l] != 'K')
            found = true;
         if( board[k][l] == 'b' || board[k][l] == 'q' ) 
            return true;
      }
      
      found = false;
      for (int k = i, l = j ; k <8 && l <8  && !found; k++, l++)
      {
         if( board[k][l] != 'b' && board[k][l] != 'q' && board[k][l] != '.' && board[k][l] != 'K')
            found = true;
         if( board[k][l] == 'b' || board[k][l] == 'q' ) 
            return true;
      }
      
      found=false;
      for (int k = i, l = j ; k >=0 && l<8 && !found; k--, l++)
      {
         if( board[k][l] != 'b' && board[k][l] != 'q' && board[k][l] != '.' && board[k][l] != 'K')
            found = true;
         if( board[k][l] == 'b' || board[k][l] == 'q' )
            return true;
      }
      
      found = false;
      for (int k = i, l = j ; k <8 && l>=0  && !found; k++, l--)
      {
         if( board[k][l] != 'b' && board[k][l] != 'q' && board[k][l] != '.' && board[k][l] != 'K')
            found = true;
         if( board[k][l] == 'b' || board[k][l] == 'q' ) 
            return true;         
      }
      return false;
   } //End of Check white peices ...
      
	 
   /**  
    * @return If black move is found return true, otherwise return false
    * This method is to:  
    * Validate black peices.
    */ 
   private static boolean checkBlack( )                     
   {
      int i = blackKingi, j = blackKingj ; 
   	
      // Moves for knight
      if( i-2 >= 0 && j-1 >= 0 && board[i-2][j-1] == 'N' ) 
         return true;
      if( i-1 >= 0 && j-2 >= 0 && board[i-1][j-2] == 'N' ) 
         return true;
      if( i+1  < 8 && j-2 >= 0 && board[i+1][j-2] == 'N' ) 
         return true;
      if( i+2  < 8 && j-1 >= 0 && board[i+2][j-1] == 'N' ) 
         return true;
      if( i-2 >= 0 && j+1  < 8 && board[i-2][j+1] == 'N' ) 
         return true;
      if( i-1 >= 0 && j+2  < 8 && board[i-1][j+2] == 'N' ) 
         return true;
      if( i+1  < 8 && j+2  < 8 && board[i+1][j+2] == 'N' ) 
         return true;
      if( i+2  < 8 && j+1  < 8 && board[i+2][j+1] == 'N' )
          return true;
     
   	// Moves for pawn
      if( i+1 < 8 && j+1 <  8 && board[i+1][j+1] == 'P') 
         return true;
      if( i+1 < 8 && j-1 >= 0 && board[i+1][j-1] == 'P') 
         return true;
   	
   	// Moves for rook and queen
      boolean found = false;
      for (int k = j; k >=0 && !found ; k--)
      {
         if( board[i][k] != 'R' && board[i][k] != 'Q' &&  board[i][k] != '.' && board[i][k] != 'k')
            found = true;
         if( board[i][k] == 'R' || board[i][k] == 'Q' ) 
            return true;
      }
      
      found = false;
      for (int k = i; k >=0 && !found; k--)
      {
         if( board[k][j] != 'R' && board[k][j] != 'Q' &&  board[k][j] != '.' && board[k][j] != 'k')
            found = true;
         if( board[k][j] == 'R' || board[k][j] == 'Q' ) 
            return true;
      }
      
      found = false;
      for (int k = i; k < 8 && !found; k++)
      {
         if( board[k][j] != 'R' && board[k][j] != 'Q' &&  board[k][j] != '.' && board[k][j] != 'k')
            found = true;
         if( board[k][j] == 'R' || board[k][j] == 'Q' ) 
            return true;
      }
      
      found = false;
      for (int k = j; k < 8 && !found; k++)
      {
         if( board[i][k] != 'R' && board[i][k] != 'Q' &&  board[i][k] != '.' && board[i][k] != 'k')
            found = true;	
         
         if( board[i][k] == 'R' || board[i][k] == 'Q' )
            return true;
      }
   	
   	// Moves for bishop and queen
      found = false;
      for (int k = i, l = j ; k >=0 && l>=0 && !found; k--, l--)
      {
         if( board[k][l] != 'B' && board[k][l] != 'Q' && board[k][l] != '.' && board[k][l] != 'k')
            found = true;
         if( board[k][l] == 'B' || board[k][l] == 'Q' ) 
            return true;
      }
      
      found = false;
      for (int k = i, l = j ; k <8 && l <8  && !found; k++, l++)
      {
         if( board[k][l] != 'B' && board[k][l] != 'Q' && board[k][l] != '.' && board[k][l] != 'k')
            found = true;
         if( board[k][l] == 'B' || board[k][l] == 'Q' ) 
            return true;
      }
      
      found=false;
      for (int k = i, l = j ; k >=0 && l<8 && !found; k--, l++)
      {
         if( board[k][l] != 'B' && board[k][l] != 'Q' && board[k][l] != '.' && board[k][l] != 'k')
            found = true;
         if( board[k][l] == 'B' || board[k][l] == 'Q' )
            return true;
      }
      found = false;
      for (int k = i, l = j ; k <8 && l>=0  && !found; k++, l--)
      {
         if( board[k][l] != 'B' && board[k][l] != 'Q' && board[k][l] != '.' && board[k][l] != 'k')
            found = true;
         if( board[k][l] == 'B' || board[k][l] == 'Q' )
            return true;
      }
      return false;
   }  //End of Check black peices ...
      
   
   /**  
    *@return If there is a spot on the board is not empty than return false, otherwise return true
    * This method is to:  
    * to test the board with no 
    * peices and return true to stop
    */ 
   private static boolean toLast( )            
   {
      boolean stop = true;
      for (int i = 0; i < board.length && stop; i++) 
      {
         for (int j = 0; j < board.length && stop; j++) 
         {
            if( board[i][j] != '.')
               stop = false;
         }
      }
      return stop;
   } //End of toLast ...
     
   
   /**  
    *@param boardNumber 
    * This method is to:  
    * Solve if the any of the kings incheck, 
    * and print out the result.
    */ 
   private static void getResult(int boardNumber)
   {
   
      boolean white = checkWhite();
      boolean black = checkBlack();
      if( !white && !black) 
         System.out.println("Game# " + boardNumber + ": no king is in check.\n");
      else if( white )
         System.out.println("Game# " + boardNumber + ": white king is in check.\n");
      else 
         System.out.println("Game# " + boardNumber + ": black king is in check.\n");
   } //End of getResult ...
   
   
   /**  
    * @param args console input 
    * @exception Throwable The Throwable class is the superclass of all errors and exceptions in the Java language. 
    */ 
   public static void main(String[] args) throws Throwable 
   {
     
      BufferedReader in = new BufferedReader(new FileReader(args[0]));
      board = new char[8][8];
      stop = false;
      int boardNumber = 1;
    
      while ( !stop )                             /* This is gonna be implements only if stop is false.*/
      {
         for (int i = 0; i < 8; i++)              
         {
            String line = in.readLine();         
            
            for (int j = 0; j < 8; j++)           /* nested loop to fill 2D array,*/
            {            
               board[i][j] = line.charAt(j);      /* and detect the king's position*/
               if( board[i][j] == 'k' ) 
               { 
                  blackKingi = i ; 
                  blackKingj = j; 
               }
               if( board[i][j] == 'K' ) 
               { 
                  whiteKingi = i; 
                  whiteKingj = j; 
               }
            }
            System.out.print(line);          /* For testing purpose only. */
            System.out.print("\n");
         }
      	         
         stop = toLast( );                    /* To detect the last board and stop if "stop" is true.*/
         
         if( !stop )
         {
            getResult(boardNumber);
            boardNumber++;
            in.readLine();
         }
         else
            System.out.println("\n\nIt's done, Thanks.");
         
      } // end while ...
   	
   } // end main ...
 
} // end main ...