package nyna.swing.chapter2;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class PhoneList {

	private JFrame frmASimplePhone;
	
	private JTextField txtName;
	private JTextField txtPhonenumber;
	
	private JCheckBox chckbxIgnoreCase;
	
	private final ButtonGroup btnGrpMatch = new ButtonGroup();
	private JRadioButton rdbtnExactMatch;
	private JRadioButton rdbtnStartsWith;
	private JRadioButton rdbtnEndsWith;
	
	private String phoneList[][] = {
			{"Jon", "555-8765"},
			{"Jessica", "555-5643"},
			{"Adam", "555-1212"},
			{"Rachel", "555-3435"},
			{"Tom & Jerry", "555-1001"}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoneList window = new PhoneList();
					window.frmASimplePhone.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PhoneList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmASimplePhone = new JFrame();
		frmASimplePhone.setTitle("A Simple Phone List");
		frmASimplePhone.setBounds(800, 400, 337, 329);
		frmASimplePhone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmASimplePhone.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblName = new JLabel("Name");
		frmASimplePhone.getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				lookForNumber(txtName.getText());
			}
		});
		frmASimplePhone.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNumber = new JLabel("Phone Number");
		frmASimplePhone.getContentPane().add(lblNumber);
		
		txtPhonenumber = new JTextField();
		txtPhonenumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				lookForName(txtPhonenumber.getText());
			}
		});
		frmASimplePhone.getContentPane().add(txtPhonenumber);
		txtPhonenumber.setColumns(10);
		
		JLabel lblSearchOptions = new JLabel("Search Options");
		frmASimplePhone.getContentPane().add(lblSearchOptions);
		
		chckbxIgnoreCase = new JCheckBox("Ignore Case");
		frmASimplePhone.getContentPane().add(chckbxIgnoreCase);
		
		rdbtnExactMatch = new JRadioButton("Exact Match");
		rdbtnExactMatch.setSelected(true);
		btnGrpMatch.add(rdbtnExactMatch);
		frmASimplePhone.getContentPane().add(rdbtnExactMatch);
		
		rdbtnStartsWith = new JRadioButton("Starts With");
		btnGrpMatch.add(rdbtnStartsWith);
		frmASimplePhone.getContentPane().add(rdbtnStartsWith);
		
		rdbtnEndsWith = new JRadioButton("Ends With");
		btnGrpMatch.add(rdbtnEndsWith);
		frmASimplePhone.getContentPane().add(rdbtnEndsWith);
	}

	protected void lookForName(String number) {
		for(int i = 0; i < phoneList.length; i++)
			if(phoneList[i][1].equals(number))
				txtName.setText(phoneList[i][0]);	
	}

	protected void lookForNumber(String searchString) {
		// Look for a name matching searchString 
		if(rdbtnExactMatch.isSelected()) {
			for(int i = 0; i < phoneList.length; i++)
				if(chckbxIgnoreCase.isSelected()) {
					if(phoneList[i][0].toLowerCase().equals(searchString.toLowerCase()))
						txtPhonenumber.setText(phoneList[i][1]);	
				}
				else if(phoneList[i][0].equals(searchString))
						txtPhonenumber.setText(phoneList[i][1]);	
		}
		
		// Look for a name starting with searchString
		else if(rdbtnStartsWith.isSelected()) {
			for(int i = 0; i < phoneList.length; i++)
				if(chckbxIgnoreCase.isSelected()) {
					if(phoneList[i][0].toLowerCase().startsWith(searchString.toLowerCase())) {
						txtName.setText(phoneList[i][0]);
						txtPhonenumber.setText(phoneList[i][1]);
					}
				}
				else if(phoneList[i][0].startsWith(searchString)) {
					txtName.setText(phoneList[i][0]);
					txtPhonenumber.setText(phoneList[i][1]);
				}
		}
		
		// Look for a name ending with searchString
		else {
			for(int i = 0; i < phoneList.length; i++)
				if(chckbxIgnoreCase.isSelected()) {
					if(phoneList[i][0].toLowerCase().endsWith(searchString.toLowerCase())) {
						txtName.setText(phoneList[i][0]);
						txtPhonenumber.setText(phoneList[i][1]);
					}
				}
				else if(phoneList[i][0].endsWith(searchString)) {
					txtName.setText(phoneList[i][0]);
					txtPhonenumber.setText(phoneList[i][1]);
				}
		}
	}

}
