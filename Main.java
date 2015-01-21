
public class Main
{
	public static void main(String args[])
	{
		GUI gui = new GUI();
		FileManager fileManager = new FileManager("file.txt");
		Parsing parse = new Parsing();
		gui.menuInit();
		gui.textAreaInit();
		gui.windowInit();
		fileManager.readFile();
	}
}
