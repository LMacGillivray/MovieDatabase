package Views;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controllers.DatabaseController;
import Models.Library;

public class DatabaseWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private DatabaseController control;
	private Library library;

	public DatabaseWindow(){
		super("My Movie Database");
		
		library = new Library();
		control = new DatabaseController(library, this);
		
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
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
