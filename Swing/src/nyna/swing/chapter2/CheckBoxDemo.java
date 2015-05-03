package nyna.swing.chapter2;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CheckBoxDemo implements ItemListener {

	JLabel jlWhat;
	JLabel jlSelected;
	JCheckBox jcbEnableOptions;
	JCheckBox jcbSpeed;
	JCheckBox jcbSize;
	JCheckBox jcbDebug;
	
	CheckBoxDemo() {
		JFrame rootFR = new JFrame("Check Box Demo");
		rootFR.getContentPane().setLayout(new GridLayout(4, 1));
		rootFR.setBounds(600, 200, 400, 400);
		rootFR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Initialize enable option CheckBox
		jcbEnableOptions = new JCheckBox("Enable Options");
		rootFR.add(jcbEnableOptions);
		
		// Create a bordered pane to add the 3 options CheckBox
		JPanel jpOptions = new JPanel();
		jpOptions.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Options:"));
		jpOptions.setLayout(new GridLayout(3, 1));
		
		// Create the 3 options CheckBoxes, disable them, and them them to the option panel
		jcbSpeed = new JCheckBox("Maximize Speed");
		jcbSize = new JCheckBox("Minimize size");
		jcbDebug = new JCheckBox("Debug");
		jcbSpeed.setEnabled(false);
		jcbSize.setEnabled(false);
		jcbDebug.setEnabled(false);
		
		jpOptions.add(jcbSpeed);
		jpOptions.add(jcbSize);
		jpOptions.add(jcbDebug);
		rootFR.add(jpOptions);
		
		// Add the last 2 remaining labels
		jlWhat = new JLabel("Selection Change: ");
		jlSelected = new JLabel("Options selected: ");
		rootFR.add(jlWhat);
		rootFR.add(jlSelected);
		
		// Add Listeners to CheckBoxes
		jcbEnableOptions.addItemListener(this);
		jcbSpeed.addItemListener(this);
		jcbSize.addItemListener(this);
		jcbDebug.addItemListener(this);
		
		rootFR.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        new CheckBoxDemo();
		    }
		});
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		// Retrieve the selected Check Box
		JCheckBox jcbSelected = (JCheckBox) ie.getItem();
		
		if(jcbSelected == jcbEnableOptions)
			if(jcbEnableOptions.isSelected()) {
				jcbSpeed.setEnabled(true);
				jcbSize.setEnabled(true);
				jcbDebug.setEnabled(true);
			} else {
				jcbSpeed.setEnabled(false);
				jcbSize.setEnabled(false);
				jcbDebug.setEnabled(false);
			}
		
		// Create label text for selected options.
		String optionsText = "Options selected: ";
		if(jcbSpeed.isSelected()) optionsText += "Speed ";
		if(jcbSize.isSelected()) optionsText += "Size ";
		if(jcbDebug.isSelected()) optionsText += "Debug ";
		
		// Update label's text
		jlWhat.setText("Selection Change: " + jcbSelected.getText() + " selected.");
		jlSelected.setText(optionsText);
	}
}
