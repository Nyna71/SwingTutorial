package nyna.swing.chapter2;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class ChangeEventDemo implements ChangeListener {
	
	// Creates the global variable label for the demo
	JLabel demoLB = new JLabel("");
	
	ChangeEventDemo() {
		JFrame rootFR = new JFrame("Change Event Demo");
		rootFR.getContentPane().setLayout(new FlowLayout());
		rootFR.setBounds(800, 200, 250, 200);
		rootFR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Creates the button for the demo
		JButton demoBT = new JButton("Press for change event test");
		demoBT.addChangeListener(this);
		demoLB.setBorder(BorderFactory.createTitledBorder("Current State"));
		demoLB.setPreferredSize(new Dimension((int) demoBT.getPreferredSize().getWidth(), 100));
		
		rootFR.add(demoBT);
		rootFR.add(demoLB);
		rootFR.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        new ChangeEventDemo();
		    }
		});
	}

	@Override
	public void stateChanged(ChangeEvent ce) {
		String label = "<html>";
		JButton demoBT = (JButton) ce.getSource();
		ButtonModel model = demoBT.getModel();
		
		if(model.isEnabled())
			label +=  "Enabled<br>";
		if(model.isArmed())
			label +=  "Armed<br>";
		if(model.isRollover())	
			label +=  "Rollover<br>";
		if(model.isPressed())	
			label +=  "Pressed<br>";
		
		demoLB.setText(label);
	}

}
