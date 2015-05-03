package nyna.swing.chapter2;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class IconLabelDemo {
	
	IconLabelDemo() {
		JFrame rootFR = new JFrame("Icon Label Demo");
		rootFR.getContentPane().setLayout(new GridLayout(4, 1, 4, 4));
		rootFR.setBounds(800, 200, 340, 480);
		rootFR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set a dummy border around the content pane
		JPanel cp = (JPanel) rootFR.getContentPane();
		cp.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		
		// Image Icon
		ImageIcon pikaICO = new ImageIcon("img/hive.jpg");
		
		// Create a common border for labels 
		Border eb = new EtchedBorder();
		
		// Label1: simple icon
		JLabel lb1 = new JLabel(pikaICO);
		lb1.setBorder(eb);
		
		// Label2: icon and default text position
		JLabel lb2 = new JLabel("Default position", pikaICO, SwingUtilities.CENTER);
		lb2.setBorder(eb);
		
		// Label3: icon and left text position
		JLabel lb3 = new JLabel("Left position", pikaICO, SwingUtilities.CENTER);
		lb3.setHorizontalTextPosition(SwingUtilities.LEFT);
		lb3.setBorder(eb);

		// Label4: icon and upper text position
		JLabel lb4 = new JLabel("Top position", pikaICO, SwingUtilities.CENTER);
		lb4.setVerticalTextPosition(SwingUtilities.TOP);
		lb4.setHorizontalTextPosition(SwingUtilities.CENTER);
		lb4.setBorder(eb);
		
		rootFR.getContentPane().add(lb1);
		rootFR.getContentPane().add(lb2);
		rootFR.getContentPane().add(lb3);
		rootFR.getContentPane().add(lb4);
		
		rootFR.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        new IconLabelDemo();
		    }
		});
	}

}
