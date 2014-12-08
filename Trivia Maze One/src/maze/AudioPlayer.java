package maze;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

/**
 * @author Team: fighting mongoose
 *
 */
public class AudioPlayer
{

   private static final int	EXTERNAL_BUFFER_SIZE = 248000;
   
   /**
 * @param fileName the name of the sound file
 */
public static void play(String fileName)
   {
      File soundFile = new File(fileName);
      System.out.println(fileName);
      

      
    try
	{
    	 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);  
         AudioFormat audioFormat = audioInputStream.getFormat();      
         DataLine.Info	info = new DataLine.Info(SourceDataLine.class,audioFormat);  
         
         SourceDataLine.Info info2 = (SourceDataLine.Info)info;
//         System.out.println(info2);
         AudioFormat[]format = info2.getFormats();
         for(AudioFormat curr: format)
         {
        	 System.out.println(curr);
         }
         
         SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
         line.open(audioFormat); 
         line.start();

		int	nBytesRead = 0;
		byte[]	abData = new byte[EXTERNAL_BUFFER_SIZE];
      
      while (nBytesRead != -1)
		{
			try
			{
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			if (nBytesRead >= 0)
			{
				int	nBytesWritten = line.write(abData, 0, nBytesRead);
			}
		}

		line.drain();
		line.close();
		}
		catch (Exception e)
		{
         System.out.println(e);
		}
   }
}