package nyna.swing.chapter3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;

class ScrollBar implements AdjustmentListener {

	private JScrollBar jbar = new JScrollBar();
	
	private JLabel min = new JLabel();
	private JLabel max = new JLabel();
	private JLabel current = new JLabel();
	private JLabel extend = new JLabel();
	private JLabel unit = new JLabel();
	private JLabel block = new JLabel();

	private JProgressBar prb = new JProgressBar();
	
	ScrollBar() {
		JFrame frm = new JFrame();
		frm.setTitle("Simple Scroll Bar");
		frm.setBounds(800, 400, 337, 329);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add Scroll Bar & Listener
		frm.getContentPane().add(jbar, BorderLayout.EAST);
		jbar.addAdjustmentListener(this);
		
		// Add a GridLayout in center panel
		JPanel pnlLabels = new JPanel(new GridLayout(6,1));
		frm.getContentPane().add(pnlLabels, BorderLayout.CENTER);
		
		// Add Labels
		updateLabels();
		pnlLabels.add(min);
		pnlLabels.add(max);
		pnlLabels.add(current);
		pnlLabels.add(extend);
		pnlLabels.add(unit);
		pnlLabels.add(block);
		
		// Add progress bar to south region
		prb.setIndeterminate(true);
		frm.getContentPane().add(prb, BorderLayout.SOUTH);
		
		frm.setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ScrollBar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void updateLabels() {
		min.setText("Min value: " + jbar.getMinimum());
		max.setText("Max value: " + jbar.getMaximum());
		current.setText("Current value: " + jbar.getValue());
		extend.setText("Extent value: " + jbar.getVisibleAmount());
		unit.setText("Unit Increment value: " + jbar.getUnitIncrement());
		block.setText("Block Increment value: " + jbar.getBlockIncrement());
		prb.setIndeterminate(false);
		prb.setValue(jbar.getValue());
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent ae) {
		updateLabels();
	}
	
}
