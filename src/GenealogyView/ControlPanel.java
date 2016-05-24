/**
Evan Wang
 */

package GenealogyView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlPanel extends JPanel
{
	private final int WIDTH = 50;
	ControlPanel(JFrame frame)
	{
		FlowLayout p = new FlowLayout();
		p.setAlignment(FlowLayout.CENTER);
		this.setLayout(p);
		this.setPreferredSize(new Dimension(WIDTH,frame.getHeight()));
		this.setBackground(new Color(216, 228, 248));
		for(int i = 0; i < 10; i ++)
			this.add(new JButton("hi"));
		
		int i = true ? 1 : 2;
	}
}
