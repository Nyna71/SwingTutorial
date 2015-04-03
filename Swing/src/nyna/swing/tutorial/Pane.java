package nyna.swing.tutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Pane extends JPanel {

	// Private variables
	private int squareX = 50;
	private int squareY = 50;
	private int squareW = 20;
	private int squareH = 20;
	
	public Pane() {
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		// Adding listeners
		addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                moveSquare(e.getX(),e.getY());
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                moveSquare(e.getX(),e.getY());
            }
        });
		
    }
	
	private void moveSquare(int x, int y) {
		int OFFSET = 1;
		if ((squareX!=x) || (squareY!=y)) {
			repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
			squareX=x;
			squareY=y;
			repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
		} 
	}

    public Dimension getPreferredSize() {
        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        // Draw Text
        g.drawString("This is my custom Panel!",10,20);
        g.setColor(Color.RED);
        g.fillRect(squareX,squareY,squareW,squareH);
        g.setColor(Color.BLACK);
        g.drawRect(squareX,squareY,squareW,squareH);
        g.drawLine(40, 60, 140, 60);
    }
}
