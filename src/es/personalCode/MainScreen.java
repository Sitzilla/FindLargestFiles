package es.personalCode;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MainScreen extends JPanel implements ActionListener{
	//creates the panes for each row
	JPanel panelOne = new JPanel();
	JPanel panelTwo = new JPanel();
	
	JTextArea labelDescription = new JTextArea("Program that checks all files in your C Drive and returns the 10 largest files! (This could take a few minutes)", 5, 5);
	JButton buttonStart = new JButton("Start!");
	
	private Font bSize20 = new Font("Arial", Font.PLAIN, 20);
	
	
	public MainScreen(){
		
		labelDescription.setFont(bSize20);
		buttonStart.setFont(bSize20);
		
		panelOne.setLayout( new GridLayout(1,1));
		labelDescription.setLineWrap(true);
		labelDescription.setWrapStyleWord(true);
		labelDescription.setOpaque(false);
		labelDescription.setEditable(false);
		labelDescription.setMargin(new Insets(5, 5, 5, 5));
		panelOne.add(labelDescription);
		
		panelTwo.setLayout( new GridLayout(1,3));
		buttonStart.setPreferredSize(new Dimension(1,1));
		buttonStart.addActionListener(this); 
		panelTwo.add(buttonStart);
		
		//adds all of the rows to the frame
		setLayout( new GridLayout(2,1));
		add(panelOne);
		add(panelTwo);
		
	}

	
	
	
	public void actionPerformed(ActionEvent evt) {
		
		buttonStart.setText("Please wait...");
		
		long startTime = System.currentTimeMillis();
		String output;
		String myDirectoryPath = "C:\\";
		
		FileFinder.FileFinder(myDirectoryPath);
		
		//Return the top 10 largest files in the C-Drive as a string
		output = FileFinder.concatenateAnswers();
		
		//length of time for the program to run
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
//		System.out.println("Total runtime was: " + totalTime/1000 + " seconds.");
		output += "\n" + "\n" + "***Total runtime was: " + totalTime/1000 + " seconds.";
		
		//show output
		JOptionPane.showMessageDialog(null, output, "Final Output", JOptionPane.INFORMATION_MESSAGE);
		
		buttonStart.setText("Start!");
		
	}
	
	
	
}
