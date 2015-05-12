package nyna.swing.chapter3;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AudioPlayer implements ChangeListener {

	private JFrame frame;
	private final ButtonGroup btgrpSettings = new ButtonGroup();
	
	// Sliders variables
	private JSlider sldBass;
	private JSlider sldMidrange;
	private JSlider sldTrebble;
	private JSlider sldBalance;
	private JSlider sldVolume;
	
	// Slider's default and presets settings
	private JLabel lblSettings;
	private static final int[] defaultSettings = new int[] {2, -1, 4, 1, 5};
	private static final int[] preset1Settings = new int[] {0, 0, 0, 0, 5};
	private static final int[] preset2Settings = new int[] {0, 0, 0, 0, 5};
	
	// Radio Buttons variables
	private JRadioButton rdbtnDefaults;
	private JRadioButton rdbtnPreset1;
	private JRadioButton rdbtnPreset2;
	private JButton btnStoreSettings;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AudioPlayer window = new AudioPlayer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the Audio Player GUI.
	 */
	public AudioPlayer() {
		initializeGUI();
		addListeners();
	}

	/**
	 * Add the Sliders and Buttons Listeners.
	 */
	private void addListeners() {
		// Add Slider Listeners
		sldBass.addChangeListener(this);
		sldMidrange.addChangeListener(this);
		sldTrebble.addChangeListener(this);
		sldBalance.addChangeListener(this);
		sldVolume.addChangeListener(this);
		
		// Add Radio Button Listeners
		rdbtnDefaults.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				setSlidersSettings(defaultSettings);
			}
		});
		
		rdbtnPreset1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				setSlidersSettings(preset1Settings);
			}
		});
			
		rdbtnPreset2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				setSlidersSettings(preset2Settings);
			}
		});
		
		// Add Store Button Listener
		btnStoreSettings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(rdbtnPreset1.isSelected())
					storePreset("preset1");
				else if(rdbtnPreset2.isSelected())
					storePreset("preset2");
			}
		});
	}

	/**
	 * Stores the sliders settings inside preset1 or preset1.
	 * @param preset The name of the preset used to store the sliders settings.
	 */
	private void storePreset(String preset) {
		if(preset.equals("preset1")) {
			preset1Settings[0] = sldBass.getValue();
			preset1Settings[1] = sldMidrange.getValue();
			preset1Settings[2] = sldTrebble.getValue();
			preset1Settings[3] = sldBalance.getValue();
			preset1Settings[4] = sldVolume.getValue();
		} else if(preset.equals("preset2")) {
			preset2Settings[0] = sldBass.getValue();
			preset2Settings[1] = sldMidrange.getValue();
			preset2Settings[2] = sldTrebble.getValue();
			preset2Settings[3] = sldBalance.getValue();
			preset2Settings[4] = sldVolume.getValue();
		} 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeGUI() {
		frame = new JFrame("Audio Player");
		frame.setBounds(400, 100, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		initializeGUISliders();
		
		Component hrStrut1 = Box.createHorizontalStrut(400);
		hrStrut1.setPreferredSize(new Dimension(400, 20));
		frame.getContentPane().add(hrStrut1);
		
		initializeGUIButtons();
		
		Component hrStrut2 = Box.createHorizontalStrut(400);
		hrStrut2.setPreferredSize(new Dimension(400, 20));
		frame.getContentPane().add(hrStrut2);
		
		initializeGUISettings();
	}

	/**
	 * Retrieves the sliders settings and update the settings label.
	 * @return
	 */
	private String getSlidersSettings() {
		String settingsLabel = "<html>";
		
		settingsLabel += "Bass: " + sldBass.getValue();
		settingsLabel += "<br>Midrange: " + sldMidrange.getValue();
		settingsLabel += "<br>Trebble: " + sldTrebble.getValue();
		settingsLabel += "<br>Balance: " + sldBalance.getValue();
		settingsLabel += "<br>Volume: " + sldVolume.getValue();
		
		return settingsLabel;
	}

	/**
	 * Update the sliders settings based on one of the predefined settings.
	 * @param settings A predefined settings, being default, preset1 or preset2.
	 */
	private void setSlidersSettings(int[] settings) {
		sldBass.setValue(settings[0]);
		sldMidrange.setValue(settings[1]);
		sldTrebble.setValue(settings[2]);
		sldBalance.setValue(settings[3]);
		sldVolume.setValue(settings[4]);
	}

	/**
	 * Initializes the settings button and label.
	 */
	private void initializeGUISettings() {
		btnStoreSettings = new JButton("Store Settings");
		btnStoreSettings.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnStoreSettings);
		
		Component vrStrut = Box.createVerticalStrut(40);
		vrStrut.setPreferredSize(new Dimension(20, 80));
		frame.getContentPane().add(vrStrut);
		
		setSlidersSettings(defaultSettings);
		lblSettings = new JLabel(getSlidersSettings());
		lblSettings.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblSettings);
	}

	/**
	 * Initializes the radio buttons for default and user defined presets.
	 */
	private void initializeGUIButtons() {
		rdbtnDefaults = new JRadioButton("Defaults");
		rdbtnDefaults.setName("defaults");
		btgrpSettings.add(rdbtnDefaults);
		rdbtnDefaults.setPreferredSize(new Dimension(85, 25));
		rdbtnDefaults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnDefaults.setSelected(true);
		frame.getContentPane().add(rdbtnDefaults);
		
		rdbtnPreset1 = new JRadioButton("Preset 1");
		rdbtnPreset1.setName("preset1");
		btgrpSettings.add(rdbtnPreset1);
		rdbtnPreset1.setPreferredSize(new Dimension(85, 25));
		rdbtnPreset1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(rdbtnPreset1);
		
		rdbtnPreset2 = new JRadioButton("Preset 2");
		rdbtnPreset2.setName("preset2");
		btgrpSettings.add(rdbtnPreset2);
		rdbtnPreset2.setPreferredSize(new Dimension(85, 25));
		rdbtnPreset2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(rdbtnPreset2);
	}

	/**
	 * Initializes all sliders.
	 */
	private void initializeGUISliders() {
		JLabel lblBass = new JLabel("Bass");
		lblBass.setPreferredSize(new Dimension(60, 16));
		frame.getContentPane().add(lblBass);
		
		sldBass = new JSlider();
		sldBass.setPaintLabels(true);
		sldBass.setName("bass");
		sldBass.setPaintTicks(true);
		sldBass.setSnapToTicks(true);
		sldBass.setMinorTickSpacing(1);
		sldBass.setMajorTickSpacing(2);
		sldBass.setValue(0);
		sldBass.setMinimum(-10);
		sldBass.setMaximum(10);
		sldBass.setPreferredSize(new Dimension(300, 60));
		frame.getContentPane().add(sldBass);
		
		JLabel lblMidrange = new JLabel("Midrange");
		lblMidrange.setPreferredSize(new Dimension(60, 16));
		frame.getContentPane().add(lblMidrange);
		
		sldMidrange = new JSlider();
		sldMidrange.setName("midrange");
		sldMidrange.setValue(0);
		sldMidrange.setSnapToTicks(true);
		sldMidrange.setMajorTickSpacing(2);
		sldMidrange.setMinorTickSpacing(1);
		sldMidrange.setMinimum(-10);
		sldMidrange.setMaximum(10);
		sldMidrange.setPreferredSize(new Dimension(300, 60));
		sldMidrange.setPaintTicks(true);
		sldMidrange.setPaintLabels(true);
		frame.getContentPane().add(sldMidrange);
		
		JLabel lblTrebble = new JLabel("Trebble");
		lblTrebble.setPreferredSize(new Dimension(60, 16));
		frame.getContentPane().add(lblTrebble);
		
		sldTrebble = new JSlider();
		sldTrebble.setName("trebble");
		sldTrebble.setValue(0);
		sldTrebble.setMinorTickSpacing(1);
		sldTrebble.setMajorTickSpacing(2);
		sldTrebble.setMinimum(-10);
		sldTrebble.setMaximum(10);
		sldTrebble.setPreferredSize(new Dimension(300, 60));
		sldTrebble.setPaintTicks(true);
		sldTrebble.setPaintLabels(true);
		frame.getContentPane().add(sldTrebble);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setPreferredSize(new Dimension(60, 16));
		frame.getContentPane().add(lblBalance);
		
		sldBalance = new JSlider();
		sldBalance.setName("balance");
		sldBalance.setPreferredSize(new Dimension(300, 60));
		sldBalance.setValue(0);
		sldBalance.setPaintLabels(true);
		sldBalance.setPaintTicks(true);
		sldBalance.setMinimum(-5);
		sldBalance.setMaximum(5);
		sldBalance.setMajorTickSpacing(1);
		frame.getContentPane().add(sldBalance);
		
		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setPreferredSize(new Dimension(60, 16));
		frame.getContentPane().add(lblVolume);
		
		sldVolume = new JSlider();
		sldVolume.setPaintTicks(true);
		sldVolume.setPaintLabels(true);
		sldVolume.setValue(5);
		sldVolume.setMaximum(10);
		sldVolume.setMajorTickSpacing(1);
		sldVolume.setName("volume");
		sldVolume.setPreferredSize(new Dimension(300, 60));
		frame.getContentPane().add(sldVolume);
	}
	
	/**
	 * Updates settings label based when a sliders get moved. 
	 */
	@Override
	public void stateChanged(ChangeEvent ce) {
		lblSettings.setText(getSlidersSettings());
	}

}
