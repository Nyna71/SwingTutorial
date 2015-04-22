package nyna.swing.fundamentals;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class StopTheClok implements ActionListener {
	
	private JLabel statusLB = new JLabel("Click Start button to run tghe clock");
	private double startTime;
	
	StopTheClok () {
		
		JFrame rootFR = new JFrame("Stop the running clock!");
		rootFR.getContentPane().setLayout(new FlowLayout());
		rootFR.setBounds(800, 600, 230, 100);
		rootFR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add Start & Stop Buttons
		JButton startJB = new JButton("Start");
		JButton stopJB = new JButton("Stop");
		
		// Add Action Listener to buttons
		startJB.addActionListener(this);
		stopJB.addActionListener(this);
		
		rootFR.add(startJB);
		rootFR.add(stopJB);
		rootFR.add(statusLB);
		
		rootFR.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Calendar cal = Calendar.getInstance();
		
		if(ae.getActionCommand().equals("Start")) {
			statusLB.setText("Clock running, click Stop");
			startTime = cal.getTimeInMillis();
		} else {
			statusLB.setText("Elapse Time is: " + 
					(cal.getTimeInMillis() - startTime) / 1000 + "sec");
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        new StopTheClok();
		    }
		});

	}
}
