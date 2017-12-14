package Views;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controllers.DatabaseController;


public class DatabaseWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private DatabaseController control;


	public DatabaseWindow(){
		super("My Movie Database");
		
		control = new DatabaseController();
		
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUpMenu();
		this.setVisible(true);
	}
	
	private void setUpMenu(){
		JMenuBar mainMenu = new JMenuBar();
		this.setJMenuBar(mainMenu);
		
		JMenu fileMenu = new JMenu("File");
		mainMenu.add(fileMenu);
		
		JMenuItem addMenuItem = new JMenuItem("Add");
		addMenuItem.addActionListener(control);
		fileMenu.add(addMenuItem);
		
		JMenuItem editMenuItem = new JMenuItem("Edit");
		editMenuItem.addActionListener(control);
		fileMenu.add(editMenuItem);
	}
}
