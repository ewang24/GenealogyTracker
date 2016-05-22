/**
Evan Wang
 */

package GenealogyView;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlPanel extends JPanel
{
	ControlPanel(JFrame frame)
	{
		this.setSize(new Dimension(70,frame.getHeight()));
		this.setBackground(new Color(216, 228, 248));
	}
}
