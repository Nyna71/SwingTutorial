package nyna.swing.tutorial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JPanel;

class FractalPanel extends JPanel {

	FractalPanel() {
		// Adding listeners
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(nbrClick < 3) {
					points[nbrClick] = new Point(e.getX(), e.getY());
					nbrClick++;
				}

				// On last click, remove MouseMotion Listener
				if(nbrClick == 3) {
					points[3] = points[0]; //Last line of triangle goes from last point to first point
					isTriangleVisible = true;
					repaint();
				}
				
				// Generate Circles
				if(nbrClick == 4) repaint();
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				if(!isTriangleVisible && nbrClick > 0) {
					points[nbrClick] = new Point(e.getX(), e.getY());
					repaint();
				}
			};
		});
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        for(int i = 0; i < nbrClick; i++) {
        	g.drawLine(points[i].x, points[i].y, points[i+1].x, points[i+1].y);
        }
        
        if(isTriangleVisible) {
        	currentPoint = points[r.nextInt(3)];
        	for(int i = 0; i < 500000; i++) {
        		currentPoint = getHalDistance(currentPoint, points[r.nextInt(3)]);
        		g.setColor(Color.BLUE);
        		g.drawOval(currentPoint.x, currentPoint.y, 2, 2);
        		g.fillOval(currentPoint.x, currentPoint.y, 2, 2);
        	}
        }
	}
	
    public Dimension getPreferredSize() {
        return new Dimension(800,600);
    }
	
	private Point getHalDistance(Point p1, Point p2) {
		Point point = new Point();
		double x = 0;
		double y = 0;

		x = p1.getX() + (p2.getX() - p1.getX()) / 2;
		y = p1.getY() + (p2.getY() - p1.getY()) / 2;
		
		point.setLocation(x, y);
		return point;
	}
	
	// Private Variables
	private int nbrClick = 0;
	private Point[] points = new Point[4];
	private Point currentPoint;
	private boolean isTriangleVisible = false;
	private Random r = new Random();
}
