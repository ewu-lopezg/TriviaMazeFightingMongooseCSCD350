import java.util.*;
import java.io.*;

public class FileReader 
{
   static private Scanner input = null;
   static Board currentBoard = new Board();
	
   public void readFile(String fileName)
   {
      int row = 0;
      ConnectInput(fileName);
   	
      char[][] board = new char[8][8];
      int gameNumber = 1; 
      int count = 1; 
         
      while(input.hasNext())
      {
            String stringHolder = input.nextLine();
            if(stringHolder.equals(""))
            {
               stringHolder = input.nextLine();
            }
            addToBoard(row, stringHolder, board);
            count++;
            row++;
            if(count > 8)
            {
               boolean found = false; 
               System.out.print("Game # " + gameNumber + " ");
               printBoard(board);
               count = 1;
               gameNumber++;
               row = 0; 
               found = scanBoard(board);
               if(!found)
                  System.out.println("no king is in check.");
            }   
      }
      disconnectInput();
   }
   public static String exceptionString()
   {
      String s; 
      try
      {
         s = input.nextLine();
      }
      catch(Exception e)
      {
         s = null;
      }
      return s; 
   }
   
   public static void addToBoard(int row, String stringHolder, char[][] board)
   {
      int colum = 0;
      while(colum < board[row].length)
      {
         board[row][colum] = stringHolder.charAt(colum);
         colum++;
      }
   }
   
   public static void printBoard(char[][] board)
   {
      for(int row = 0; row < board.length; row++)
      {
         for(int colum = 0; colum < board[row].length; colum++)
         {
            System.out.print(board[row][colum] + " ");
         }
         System.out.println();
      }
   }
   
   public boolean scanBoard(char[][] board)
   {
      boolean notEmpty = true; 
      boolean found = false; 
      
      for(int row = 0 ; row < board.length; row++)
      {	
         for(int colum = 0; colum < board[row].length; colum++)
         {
            if(!(currentBoard.checkCurrentPossition(row, colum, board)))
            {
               found = currentBoard.executeCheck(row, colum, board);
               if(found)
               {
                  colum = 7; 
                  row = 7;
                  found = true;
               }
            }
         }
         
      }
      return found; 
   }
   public boolean ConnectInput(String fileName)
   {
      try
      {
         input = new Scanner(new File(fileName));
      }
      catch(Exception e)
      {
         return false; 
      }
      return true; 
   }
	
   public void disconnectInput()
   {
      input.close();
   } 
	
}