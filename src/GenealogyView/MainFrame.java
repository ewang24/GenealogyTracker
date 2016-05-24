/**
Evan Wang
*/

package GenealogyView;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import GenealogyController.Genealogy;


public class MainFrame extends JFrame
{
	public Genealogy reference;
	JScrollPane viewPane;
	
	public MainFrame(Genealogy reference)
	{
		this.reference = reference;
		setUp();		
	}
	
	private void setUp()
	{
		try
		{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Fatal Error");
			System.exit(1);
		}
		
		this.addWindowListener(new WindowAdapter() 
		{
		    @Override
		    public void windowClosing(WindowEvent windowEvent) 
		    {	
		          if (JOptionPane.showConfirmDialog(null, "Do you really want to exit the program?", "Exit?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
		           	  System.exit(0);
		    }
		});
		
		this.setTitle("Genealogy Tracker");
		this.setSize(new Dimension(500,500));
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		StartPanel tvp = new StartPanel(this);
		viewPane = new JScrollPane(tvp);
		ControlPanel c = new ControlPanel(this);
		this.add(viewPane,BorderLayout.CENTER);
		this.add(c,BorderLayout.WEST);
		viewPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		viewPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		this.setVisible(true);
		
	}
	
	public Genealogy getReference()
	{
		return reference;
	}
}
