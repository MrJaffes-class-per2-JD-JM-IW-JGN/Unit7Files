import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI
{	
	FileManager fileManager = new FileManager(FileManager.fileDirectory);
	Parsing parse = new Parsing();
	
	public static JFrame window = new JFrame();
	JFileChooser fileChooser = new JFileChooser(FileManager.fileDirectory);
	
	public static JTextArea textArea = new JTextArea();
	
	//Menu bar Items
	JMenuBar menuBar = new JMenuBar();
	
	JMenu file = new JMenu("File");
		JMenuItem New = new JMenuItem("New");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		
	
	JMenu edit = new JMenu("Edit");
	
	JMenu features = new JMenu("Features");
		JMenuItem rainbow = new JMenuItem("RAINBOW!!!");
		JMenuItem parseName = new JMenuItem("Parse Name");
		
	JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
	
	public void windowInit()
	{
		window.setTitle(FileManager.fileDirectory);
		window.setEnabled(true);
		window.setSize(400, 400);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.repaint();
	}
	
	public void menuInit()
	{
		menuBar.add(file);
			file.add(New);
				New.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						fileChooser.showDialog(fileChooser, "New");
						FileManager.fileDirectory = fileChooser.getSelectedFile().toString();
						fileManager.makeNewFile(FileManager.fileDirectory);
						textArea.setText(null);
						fileManager.readFile();
					}
				});
			file.add(open);
				open.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						fileChooser.showDialog(fileChooser, "Open");
						FileManager.fileDirectory = fileChooser.getSelectedFile().toString();
						fileManager.readFile();
					}
				});
			file.add(save);
				save.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						fileManager.writeToFile();
						System.out.println("Well This works");
					}
				});
		//menuBar.add(edit);
		menuBar.add(features);
			features.add(parseName);
			parseName.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					parse.parseName();
				}
			});
			features.add(rainbow);
			rainbow.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					textArea.setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
					textArea.setForeground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
				}
			});		
		//menuBar.add(help);
		window.add(menuBar);
		window.setJMenuBar(menuBar);
		menuBar.setVisible(true);
	}
	
	void textAreaInit()
	{
		textArea.setVisible(true);
		window.add(textArea);
	}
	
	void fileChooserInit()
	{
		fileChooser.setVisible(true);
		window.add(fileChooser);
	}
}
