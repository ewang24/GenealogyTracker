/**
Evan Wang
*/

package GenealogyController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;

import GenealogyView.MainFrame;


public class Genealogy
{
	
	Connection c = null;
	Statement statement;
	MainFrame mf;
	
	public Genealogy()
	{
		mf = new MainFrame(this);
	}
	
	public void loadGenealogy(String location)
	{
		createConnection(location);
	}
	
	public void newGenealogy(String location)
	{
		loadGenealogy(location);
	}
	
	/**
	 * @param path: path to create a connection too
	 */
	private void createConnection(String path)
	{
		try
		{
			c = DriverManager.getConnection("jdbc:sqlite:" + path);
			statement = c.createStatement();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * called at close of program. Closes connection and statements and exits.
	 */
	public void cleanAndExit()
	{
		try
		{
			statement.close();
			c.close();
		}
		catch (Exception e)
		{
			System.out.println("exited with errors:");
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	
}
