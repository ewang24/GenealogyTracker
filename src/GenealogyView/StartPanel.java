/**
Evan Wang
*/

package GenealogyView;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;


public class StartPanel extends JPanel
{
	MainFrame frame;
	JButton loadButton;
	JButton newButton;
	JFileChooser chooser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Genealogy File", "gen");
	
	public StartPanel(MainFrame frame)
	{
		this.frame = frame;
		loadButton = new JButton("Load Genealogy");
		newButton = new JButton("New Genealogy");
		chooser.setFileFilter(filter);
		load();
		addListeners();
	}
	
	private void load()
	{
		this.setLayout(new FlowLayout());
		this.add(loadButton);
	}
	
	private void addListeners()
	{
		loadButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				newGenealogy();
			}
		});
	}
	
	private void newGenealogy()
	{
		int returnVal = chooser.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			if(chooser.getSelectedFile().exists())
			{
				if(JOptionPane.showConfirmDialog(this, "File already exists. \nOverwrite?")==JOptionPane.OK_OPTION)
				{
					frame.getReference().newGenealogy(chooser.getSelectedFile().toString()+".gen");
					JOptionPane.showMessageDialog(this, "File overwritten");
				}
				else
					JOptionPane.showMessageDialog(this, "File not overwritten");
			}
			
		}	
	}
}
