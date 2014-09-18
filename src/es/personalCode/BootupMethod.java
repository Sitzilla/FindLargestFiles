package es.personalCode;

import java.awt.Dimension;
import javax.swing.JFrame;


public class BootupMethod {

	public static void main(String[] args) {

		JFrame window = new JFrame("File Finder");
		MainScreen content = new MainScreen();
		window.setContentPane(content);
		Dimension d = new Dimension(300,250);
		window.setPreferredSize(d);
		window.setResizable(false);
		window.pack();
		window.setLocation(200,200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		
	}
	
}
