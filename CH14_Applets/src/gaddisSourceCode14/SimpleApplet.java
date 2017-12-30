package gaddisSourceCode14;

import javax.swing.*;
import java.awt.*;

public class SimpleApplet extends JApplet {
	public void init()
	{
		JLabel label = new JLabel("Text in Simple Applet");
		setLayout(new FlowLayout());
		add(label);
	}
}
