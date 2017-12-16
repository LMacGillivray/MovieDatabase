package Views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ListSelectionModel;

import Controllers.DatabaseController;
import Models.Library;
import Models.Movie;

public class DatabaseWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private DatabaseController control;
	private Library library;
	private JList<String> list;
	private JMenuItem viewMenuItem;
	
	public DatabaseWindow(){
		super("My Movie Database");
		
		library = new Library();
		control = new DatabaseController(library, this);
		
		
		
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setUpMenu();
		
		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(control);
		this.add(list, BorderLayout.CENTER);
		
		this.newScreen();
		this.setVisible(true);
	}
	
	private void setUpMenu(){
		JMenuBar mainMenu = new JMenuBar();
		this.add(mainMenu, BorderLayout.NORTH);
		
		JMenu fileMenu = new JMenu("File");
		mainMenu.add(fileMenu);
		
		JMenuItem addMenuItem = new JMenuItem("Add");
		addMenuItem.addActionListener(control);
		fileMenu.add(addMenuItem);
		
		viewMenuItem = new JMenuItem("View");
		viewMenuItem.addActionListener(control);
		viewMenuItem.setEnabled(false);
		fileMenu.add(viewMenuItem);
	}
	
	public void newScreen() {
		list.setListData(library.getRelevantData());
	}
	
	public void setOptionsEnable() {
		viewMenuItem.setEnabled(true);
	}

	public static void main(String[] args) {
		new DatabaseWindow();
	}

	public Movie getSelectedMovie() {
		String str = list.getSelectedValue();
		str = str.substring(0, str.lastIndexOf('('));
		System.out.println(str);
		return library.find(str.trim());
	}
}
