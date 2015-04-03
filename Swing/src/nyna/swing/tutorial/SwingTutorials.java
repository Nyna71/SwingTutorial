package nyna.swing.tutorial;

import javax.swing.*;

public class SwingTutorials {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fractal");
		FractalPanel panel = new FractalPanel();
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		
		frame.setVisible(true);

	}
}
