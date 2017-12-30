package gaddisChallenges14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HouseApplet extends JApplet
{
	private boolean leftOpen;
	private boolean rightOpen;
	private boolean doorOpen;

	private final int HOUSE_WIDTH = 200;
	private final int HOUSE_HEIGHT = 80;
	private final int HOUSE_X = 20;
	private final int HOUSE_Y = 30;
	private final int ROOF_TOP = 5;
	private final int WINDOW_WIDTH = 50;
	private final int WINDOW_HEIGHT = 30;
	private final int DOOR_WIDTH = 40;
	private final int DOOR_HEIGHT = 70;
	private final int DOOR_Y = 40;
	private final int DOOR_X = (((HOUSE_WIDTH/2)+ HOUSE_X) - (DOOR_WIDTH/2));
	private final int LEFT_WINDOW_X = ((HOUSE_WIDTH/4)+ HOUSE_X) - (WINDOW_WIDTH/2);
	private final int LEFT_WINDOW_Y = 40;
	private final int RIGHT_WINDOW_X = (((HOUSE_WIDTH/4) * 3) + HOUSE_X) - (WINDOW_WIDTH/2);
	private final int RIGHT_WINDOW_Y = LEFT_WINDOW_Y;
	private final int KNOB_WIDTH = 7;
	private final int KNOB_HEIGHT = KNOB_WIDTH;



	public void init()
	{
		// Set the background color to white.
		getContentPane().setBackground(Color.white);
		setSize(280,120);
		// Add mouse listener
		addMouseListener(new aMouseListener());
	}

	/**
      paint method
      @param g The applet's Graphics object.
	 */

	public void paint(Graphics g)
	{
		// Call the superclass paint method.
		super.paint(g);
		// Call method to draw the house
		drawHouse(g);

		// Draw windows and door
		if (leftOpen)
			drawOpenWindow(g, LEFT_WINDOW_X, LEFT_WINDOW_Y);
		else
			drawClosedWindow(g, LEFT_WINDOW_X, LEFT_WINDOW_Y);

		if (rightOpen)
			drawOpenWindow(g, RIGHT_WINDOW_X, RIGHT_WINDOW_Y);
		else
			drawClosedWindow(g, RIGHT_WINDOW_X, RIGHT_WINDOW_Y);

		if (doorOpen)
			drawOpenDoor(g, DOOR_X, DOOR_Y);
		else
			drawClosedDoor(g, DOOR_X, DOOR_Y);

	}

	private void drawClosedDoor(Graphics g, int x, int y) {
		// Create the door with knob
		g.setColor(Color.DARK_GRAY);
		g.drawRect(x,  y,  DOOR_WIDTH, DOOR_HEIGHT);
		
		// door knob
		g.fillOval(((x + DOOR_WIDTH) - KNOB_WIDTH), (y + (DOOR_HEIGHT/2)), KNOB_WIDTH, KNOB_HEIGHT);
	}

	private void drawOpenDoor(Graphics g, int x, int y) {
		// Create the shaded door
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, DOOR_WIDTH, DOOR_HEIGHT);
		// draw door knob
		g.fillOval(((x + DOOR_WIDTH) - KNOB_WIDTH), (y + (DOOR_HEIGHT/2)), KNOB_WIDTH, KNOB_HEIGHT);
	}

	private void drawClosedWindow(Graphics g, int x, int y) {
		// This method draws the closed window with mullions
		g.setColor(Color.DARK_GRAY);
		// Outline
		g.drawRect(x, y,  WINDOW_WIDTH, WINDOW_HEIGHT);
		// Horizontal line
		g.drawLine(x,  (y + (WINDOW_HEIGHT/2)), (x + WINDOW_WIDTH), (y + (WINDOW_HEIGHT/2)));
		// Vertical line
		g.drawLine((x + (WINDOW_WIDTH/2)), (y + WINDOW_HEIGHT), (x + (WINDOW_WIDTH/2)), y);
	}

	private void drawOpenWindow(Graphics g, int x, int y) {
		// This method draws a filled rectangle to represent an open window.
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y,  WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	private void drawHouse(Graphics g) {
		g.setColor(Color.BLACK);
		// Draw the house rectangle
		g.drawRect(HOUSE_X, HOUSE_Y, HOUSE_WIDTH, HOUSE_HEIGHT);
		
		// Draw the triangular roof
		g.drawLine((HOUSE_X - 10), HOUSE_Y, (HOUSE_WIDTH + 30), HOUSE_Y);
		g.drawLine((HOUSE_X - 10), HOUSE_Y, ((HOUSE_WIDTH/2) + HOUSE_X), ROOF_TOP);
		g.drawLine(((HOUSE_WIDTH/2) + HOUSE_X),  ROOF_TOP, (HOUSE_WIDTH + 30), HOUSE_Y);
	}

	private class aMouseListener extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e){
			if (mouseLeftWindow(e.getX(), e.getY()))
				leftOpen = !leftOpen;
			else if (mouseRightWindow(e.getX(), e.getY()))
				rightOpen = !rightOpen;
			else if (mouseInDoor(e.getX(), e.getY()))
				doorOpen = !doorOpen;
			
			repaint();
		}

		private boolean mouseInDoor(int x, int y) {
			boolean status = false;
			// check if mouse position is within the door
			if (x >= DOOR_X && (x < (DOOR_X + DOOR_WIDTH)) &&
				y >= DOOR_Y && (y < (DOOR_Y + DOOR_HEIGHT)))
				status = true;
			
			return status;
		}

		private boolean mouseLeftWindow(int x, int y) {
			boolean status = false;
			// check if mouse position is within the left window
			if (x >= LEFT_WINDOW_X && x < (LEFT_WINDOW_X + WINDOW_WIDTH) &&
				y >= LEFT_WINDOW_Y && y < (LEFT_WINDOW_Y + WINDOW_HEIGHT))
				status = true;
			
			return status;
		}
		
		private boolean mouseRightWindow(int x, int y) {
			boolean status = false;
			// check if mouse position is within the right window
			if (x >= RIGHT_WINDOW_X && x < (RIGHT_WINDOW_X + WINDOW_WIDTH) &&
				y >= RIGHT_WINDOW_Y && y < (RIGHT_WINDOW_Y + WINDOW_HEIGHT))
				status = true;
			
			return status;
		}

	}


}
