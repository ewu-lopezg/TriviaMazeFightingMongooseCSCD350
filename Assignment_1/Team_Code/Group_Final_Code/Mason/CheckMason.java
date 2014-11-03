import java.util.*;
import java.io.*;

/**
*this program check if a king is in check
*
*@author mason varias
*@version 1.0
*@since 2014-10-3
**/
public class CheckMason
{
   //class level board variable
   protected static char[][] board = new char[8][8]; 
/**
*@param args
*@return nothing
*@exception FileNotFoundException
**/
   public static void main(String[]args)throws FileNotFoundException
   {
      
      boolean empty = true;
      String[]king = new String[]{"no","white","black"};
      int kingIndex = 0;
      int gameNum = 1;

           
//        Scanner fin = new Scanner(new File("boards.txt"));
        if(args.length==0)
         System.exit(1);
        Scanner fin = new Scanner(new File(args[0]));
    
      //read in the board from the file  
      empty = readBoard(fin);  
      while(!empty)
      {
         //check if the king is in check
         kingIndex = kingCheck();
         
         System.out.println("Game #" + gameNum + ": "+ king[kingIndex]+ " king is in check.");
         //read in next board config.
         empty = readBoard(fin);
         gameNum++;
      }
      
   }//end main
   
/**
*reads in the board and returns if the board is full
*@param fin the scanner with the file for the board
*@return boolean if the board is empty
**/
   protected static boolean readBoard(Scanner fin)
   {

      boolean empty = true;
      
      for(int row=0; row<8; row++)
      {
         String line = fin.nextLine();
         for(int col=0; col<8; col++)
         {
            board[row][col] = line.charAt(col);
            
            if(board[row][col] != '.')
               empty = false;
               
 //          System.out.print(board[row][col]);
         }
  //       System.out.println();
      }

      if(fin.hasNext())
         fin.nextLine();
      return empty;
   }//end read board

/**
*decides which king is in check
*@return int the index of which king is in check 0=no 1 = white 2 =black
**/
   protected static int kingCheck()
   {
      int king = 0;
      int[]location = {0,-1};
      boolean check = false;
      
      do
      {
         //find the next king
         location = find(location);
         if(location[1] != -1)
         {
            //check what can attack the king
            check = checkAttacks(location);
         }
     
      }while(!check && location[1] !=-1);
    
      //return which king is in check if any
      if(location[1]== -1)
         king = 0;
      else if(board[location[0]][location[1]]== 'k')
         king = 2;
      else if(board[location[0]][location[1]]=='K')
         king = 1;
   
      return king;
   }//end check king
   
   
 /**
 *decides if a king is in check
 *@param king the location of the king
 *@return boolean if the king is in check
 **/
   protected static boolean checkAttacks(int[] king)
   {
      //check up,down, left, right for rook or queen
      if(rookCheck(king))
         return true;
        
      //check diagonals for bishop or queen  
      if(bishopCheck(king))
         return true;
         
      //check if pawns can attack   
      if(pawnCheck(king))
         return true;
       
      //check if king can attack   
      if(knightCheck(king))
         return true;
         
      return false;
   }
  
/**
*checks the direction the rook can go
*@param location the location of the king
*@boolean if the king is in check
**/
   protected static boolean rookCheck(int[] location)
   {
      //check up
      for(int i = location[0]-1; i > 0; i--)
      {
         //compare which king to opponents pieces
         if( board[location[0]][location[1]]=='k' && board[i][location[1]] == 'R' ||
             board[i][location[1]]=='r' && board[location[0]][location[1]] == 'K' ||
             board[location[0]][location[1]]=='k' && board[i][location[1]] == 'Q' ||
             board[i][location[1]]=='q' && board[location[0]][location[1]] == 'K')
            return true;
            
         //if blocked   
         if(board[i][location[1]]!='.')
            i=0;
      }
      
      //check down
      for(int i= location[0]+1; i<8; i++)
      {
         //compare which king to opponents pieces
         if( board[location[0]][location[1]]=='k' && board[i][location[1]] == 'R' ||
             board[i][location[1]]=='r' && board[location[0]][location[1]] == 'K' ||
             board[location[0]][location[1]]=='k' && board[i][location[1]] == 'Q' ||
             board[i][location[1]]=='q' && board[location[0]][location[1]] == 'K')
            return true;
        
        //if blocked    
         if(board[i][location[1]]!='.')
            i=8;
      }
      
      //check left
      for(int j = location[1]-1; j > 0; j--)
      {
         //compare which king to opponents pieces
         if( board[location[0]][location[1]]=='k' && board[location[0]][j] == 'R' ||
             board[location[0]][j]=='r' && board[location[0]][location[1]] == 'K' ||
             board[location[0]][location[1]]=='k' && board[location[1]][j] == 'Q' ||
             board[location[0]][j]=='q' && board[location[0]][location[1]] == 'K')
            return true;
         
         //if blocked   
         if(board[location[0]][j]!='.')
            j=0;
      }
      
      //check right
      for(int j= location[1]+1; j<8; j++)
      {
      //compare which king to opponents pieces
         if( board[location[0]][location[1]]=='k' && board[location[0]][j] == 'R' ||
             board[location[0]][j]=='r' && board[location[0]][location[1]] == 'K' ||
             board[location[0]][location[1]]=='k' && board[location[1]][j] == 'Q' ||
             board[location[0]][j]=='q' && board[location[0]][location[1]] == 'K')
            return true;
            
         //if blocked   
         if(board[location[0]][j]!='.')
            j=8;

      }
      
      return false;
   }//end rookCheck
   
/**
*checks the direction the bishop can go
*@param location the location of the king
*@boolean if the king is in check
**/
   protected static boolean bishopCheck(int[] location)
   {
      //up,left
      for(int i = location[0]-1, j= location[1]-1; i > 0 && j>0 ; i--, j--)
      {
         if( board[location[0]][location[1]]=='k' && board[i][j] == 'B' ||
             board[i][j]=='b' && board[location[0]][location[1]] == 'K' ||
             board[location[0]][location[1]]=='k' && board[i][j] == 'Q' ||
             board[i][j]=='q' && board[location[0]][location[1]] == 'K')
            return true;
         
         //if blocked   
         if(board[i][j]!='.')
            i=0;
      }
      
      //up right
      for(int i = location[0]-1, j= location[1]+1; i > 0 && j<8 ; i--, j++)
      {
         if( board[location[0]][location[1]]=='k' && board[i][j] == 'B' ||
             board[i][j]=='b' && board[location[0]][location[1]] == 'K' ||
             board[location[0]][location[1]]=='k' && board[i][j] == 'Q' ||
             board[i][j]=='q' && board[location[0]][location[1]] == 'K')
            return true;
            
         //if blocked   
         if(board[i][j]!='.')
            i=0;
      }
      
      //down right
      for(int i = location[0]+1, j= location[1]+1; i <8 && j<8 ; i++, j++)
      {
        if( board[location[0]][location[1]]=='k' && board[i][j] == 'B' ||
             board[i][j]=='b' && board[location[0]][location[1]] == 'K' ||
             board[location[0]][location[1]]=='k' && board[i][j] == 'Q' ||
             board[i][j]=='q' && board[location[0]][location[1]] == 'K')
            return true;
            
        //if blocked   
         if(board[i][j]!='.')
            i=8;
      }
      
      //down left
      for(int i = location[0]+1, j= location[1]-1; i<8 && j>0 ; i++, j--)
      {
         if( board[location[0]][location[1]]=='k' && board[i][j] == 'B' ||
             board[i][j]=='b' && board[location[0]][location[1]] == 'K' ||
             board[location[0]][location[1]]=='k' && board[i][j] == 'Q' ||
             board[i][j]=='q' && board[location[0]][location[1]] == 'K')
            return true;
            
        //if blocked   
         if(board[i][j]!='.')
            j=0;
      }
      
      return false;
   }//end rookCheck
   
/**
*checks the direction the pawn can go
*@param location the location of the king
*@boolean if the king is in check
**/
   protected static boolean pawnCheck(int[]location)
   {
      //check for black king
      if(board[location[0]][location[1]] == 'k')//black king, lowerCase, start top
      {
         if(location[0] < 8)
         {  
            if(location[1] > 0)
            {
               //check left
               if(board[location[0]+1][location[1]-1] == 'P')
                  return true;
            }
            
            if(location[1] < 8)
            {
               //check right
               if(board[location[0]+1][location[1]+1] == 'P')
                  return true;   
            }
         }
      }
      
      //check for white king
      else if(board[location[0]][location[1]] == 'K')//whight king, upperCase, start bottom
      {
         if(location[0] > 0)
         {
            if(location[1] > 0)
            {
               //check left
               if(board[location[0]-1][location[1]-1] == 'p')
                  return true;  
            }
            if(location[1] < 8)
            {
               //check right
               if(board[location[0]-1][location[1]+1] == 'p')
                  return true;
            }
         }
      }
      
      return false;
   }//end pawnCheck
   
/**
*checks the direction the knight can go
*@param location the location of the king
*@boolean if the king is in check
**/
   protected static boolean knightCheck(int[]location)
   {
      if(location[0]+2 < 8)
      {
         if(location[1]+1 < 8)
         {
            
            if(board[location[0]+2][location[1]+1]=='n' && board[location[0]][location[1]] == 'K' ||
               board[location[0]+2][location[1]+1]=='N' && board[location[0]][location[1]] == 'k')
               return true;
         }
         if(location[1]-1 >-1)
         {
            if(board[location[0]+2][location[1]-1]=='n' && board[location[0]][location[1]] == 'K' ||
               board[location[0]+2][location[1]-1]=='N' && board[location[0]][location[1]] == 'k')
               return true;
         }
      }//down 2
      
      if (location[0]-2 > -1)
      {
         if(location[1]+1 < 8)
         {
            if(board[location[0]-2][location[1]+1]=='n' && board[location[0]][location[1]] == 'K' ||
               board[location[0]-2][location[1]+1]=='N' && board[location[0]][location[1]] == 'k')
               return true;
         }
         if(location[1]-1 > -1)
         {
            if(board[location[0]-2][location[1]-1]=='n' && board[location[0]][location[1]] == 'K' ||
               board[location[0]-2][location[1]-1]=='N' && board[location[0]][location[1]] == 'k')
               return true;
         }
      }//up 2
            
      if(location[1]+2 < 8)
      {
         if(location[0]+1 < 8)
         {
              if(board[location[0]+1][location[1]+2]=='n' && board[location[0]][location[1]] == 'K' ||
                 board[location[0]+1][location[1]+2]=='N' && board[location[0]][location[1]] == 'k')
                 return true;
         }
         if(location[0]-1 >-1)
         {
              if(board[location[0]-1][location[1]+2]=='n' && board[location[0]][location[1]] == 'K' ||
                 board[location[0]-1][location[1]+2]=='N' && board[location[0]][location[1]] == 'k')
                 return true;
         }
      }//right 2

      if(location[1]-2 > -1)
      {
         if(location[0]+1 <8)
         {
           if(board[location[0]+1][location[1]-2]=='n' && board[location[0]][location[1]] == 'K' ||
              board[location[0]+1][location[1]-2]=='N' && board[location[0]][location[1]] == 'k')
                return true;
         }
         if(location[0]-1 >-1)
         {
               if(board[location[0]-1][location[1]-2]=='n' && board[location[0]][location[1]] == 'K' ||
                  board[location[0]-1][location[1]-2]=='N' && board[location[0]][location[1]] == 'k')
                 return true;
         }
      }//left 2
      
      return false;
   }//end knightCHeck

 /**
*finds the king
*@param location the current location on the board
*@boolean location the location of the king or 0,-1 if no king is found
**/
   protected static int[] find(int[] location)
   {
   int i = location[0];
   int j = location[1]+1;
       
      for(; i< 8; i++)
      {
         for(; j< 8; j++)
         {
            if(board[i][j]== 'k' || board[i][j] == 'K')
            {
               location[0]=i;
               location[1]=j;
               return location;
            }
         }
         j=0;
      }
      
      location[0]=0;
      location[1]=-1;
      return location;
   }//end find
   
}//end check class