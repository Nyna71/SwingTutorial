package nyna.swing.fundamentals;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CodeMachine implements ActionListener {
	
	JTextField plainTextTF = new JTextField(20);
	JTextField encodedTextTF = new JTextField(20);
	
	CodeMachine() {
		JFrame rootFR = new JFrame("Simple Code Machine");
		rootFR.getContentPane().setLayout(new FlowLayout());
		rootFR.setBounds(800, 600, 340, 130);
		rootFR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add Labels and Text Fields
		JLabel plainTextLB = new JLabel ("    Plain Text");
		JLabel encodedTextLB = new JLabel("Cipher Text");
		plainTextTF.setActionCommand("Encode");
		encodedTextTF.setActionCommand("Decode");
		
		rootFR.getContentPane().add(plainTextLB);
		rootFR.getContentPane().add(plainTextTF);
		rootFR.getContentPane().add(encodedTextLB);
		rootFR.getContentPane().add(encodedTextTF);
		
		// Add Buttons
		JButton encodeJB = new JButton("Encode");
		JButton decodeJB = new JButton("Decode");
		JButton resetJB = new JButton("Reset");
		rootFR.getContentPane().add(encodeJB);
		rootFR.getContentPane().add(decodeJB);
		rootFR.getContentPane().add(resetJB);
		
		// Add Listeners
		plainTextTF.addActionListener(this);
		encodedTextTF.addActionListener(this);
		encodeJB.addActionListener(this);
		decodeJB.addActionListener(this);
		resetJB.addActionListener(this);
		
		rootFR.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        new CodeMachine();
		    }
		});
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Encode")) {
			String plainText = plainTextTF.getText();
			String encodedText = "";
			
			for(int i = 0; i < plainText.length(); i++) {
				encodedText += (char) (plainText.charAt(i) + 1);
			}
			encodedTextTF.setText(encodedText);
		}
		else if(ae.getActionCommand().equals("Decode")) {
			String encodedText = encodedTextTF.getText();
			String plainText = "";
			for(int i = 0; i < encodedText.length(); i++) {
				plainText += (char) (encodedText.charAt(i) - 1);
			}
			plainTextTF.setText(plainText);
		}
		else {
			plainTextTF.setText("");
			encodedTextTF.setText("");
		}
	}
}