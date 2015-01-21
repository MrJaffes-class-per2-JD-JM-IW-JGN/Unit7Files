import java.io.*;
import java.util.*;

public class Parsing 
{
	void parseName()
	{
		String[] words = new String[1000];
		try 
		{
			GUI.textArea.setText("");
			Scanner scanner = new Scanner(new File(FileManager.fileDirectory));
			
			for(int i = 0; scanner.hasNext(); i++)
			{
				words[i] = scanner.next();
			}
			
			scanner = new Scanner(new File(FileManager.fileDirectory));
			
			for(int i = 0; scanner.hasNext() && words[i] != null; i+=4)
			{
				GUI.textArea.append(words[i + 2] + ", " + words[i] + " " + words[i + 1] + " " + words[i + 3] +"\n");
				System.out.println(words[i + 2] + " " + words[i] + " " + words[i + 1] + "\n");
			}
			scanner.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.toString());
		}
	}
}
