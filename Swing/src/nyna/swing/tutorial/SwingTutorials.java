package nyna.swing.tutorial;

import javax.swing.*;

public class SwingTutorials {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("HelloWorld");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new JLabel("Text"));
		
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

}
