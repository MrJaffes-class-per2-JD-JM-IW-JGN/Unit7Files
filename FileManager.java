import java.io.*;

public class FileManager
{
	public static String fileDirectory = "";
		
	FileManager(String directory)
	{
		fileDirectory = directory;
	}
	
	public void writeToFile()
	{
		makeNewFile(fileDirectory);
		try 
		{
			FileWriter fileWriter = new FileWriter(fileDirectory, true);
			BufferedWriter bWriter = new BufferedWriter(fileWriter);
			bWriter.write(GUI.textArea.getText());
			System.out.println("saved");
			bWriter.close();
			fileWriter.close();
		}
		catch (IOException e) 
		{
			System.out.println("Woops bWriter broke");
		}
	}
	
	public void readFile()
	{
		String lineHolder;
		try 
		{
			FileReader fileReader = new FileReader(fileDirectory);
			BufferedReader bReader = new BufferedReader(fileReader);
			GUI.textArea.setText("");
			lineHolder = bReader.readLine();
			while(lineHolder != null )
			{
				GUI.textArea.append(lineHolder + "\n");
				lineHolder = bReader.readLine();
			}
            System.out.println("read");
            GUI.window.setTitle(FileManager.fileDirectory);
			bReader.close();
			fileReader.close();
		}
		catch (IOException e) 
		{
			System.out.println("Woops bReader broke \n" + e.getMessage());
		}
	}
	
	@SuppressWarnings("static-access")
	public void makeNewFile(String fileDirectory)
	{
		this.fileDirectory = fileDirectory;
		File file = new File(fileDirectory);
		try 
		{
			file.delete();
			file.createNewFile();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
