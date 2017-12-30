package gaddisSourceCode14;

import javax.swing.*;
import java.awt.*;

public class FollowMe extends JApplet {
	@Override
	public void init()
	{
		JLabel label = new JLabel("Hello");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(label);
	}
}
