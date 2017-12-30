/*
 * 	Stephen Adams
 * 	Spring 2018
 */

package gaddisChallenges14;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FollowMe extends JApplet {

	private final int WINDOW_WIDTH = 500;  // Window width
	private final int WINDOW_HEIGHT = 500; // Window height
	public String text = "Hello";			// Text to display
	private int x = 200;	// initial position of text
	private int y = 250;

	public void init()
	{
		// Add a mouse listeners.
		addMouseListener(new aMouseListener());
		addMouseMotionListener(new aMouseMotionListener());

		// Set the background color to white.
		setLayout(new FlowLayout());;
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	}
	// Draw "Hello" in the center
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("SansSerif", Font.BOLD, 36));
		g.drawString(text, x, y);
	}

	// Mouse Motion Listener Class
	public class aMouseMotionListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			repaint();
		}
	}
	
	// Mouse Listener Class
	public class aMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
		
	}


}