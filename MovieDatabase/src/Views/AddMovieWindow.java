package Views;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controllers.AddMovieController;
import Controllers.DatabaseController;
import Models.Movie;

public class AddMovieWindow extends JFrame{
	private final String[] PROPERTIES = {"Movie Name", "Rating", "Year", "Director"};
	private DatabaseController controller;
	private JTextField[] fields;
	
	/** This constructor sets up a JFrame that gets user input and creates a
	 *  Movie object from it
	 *  
	 *  @author Logan James
	 * 
	 * @param control - The controller which this class will add a Movie to
	 */
	public AddMovieWindow(DatabaseController control) {
		super("Add Movie");
		controller = control;
		JPanel panel = new JPanel(new GridLayout(0,2));
		fields= new JTextField[PROPERTIES.length];
		JButton button = new JButton("Enter");
		button.addActionListener(new AddMovieController(this));
		
		for(int i = 0; i < PROPERTIES.length; i++) {
			panel.add(new JLabel(PROPERTIES[i]));
			panel.add(fields[i] = new JTextField());
		}
		
		this.setSize(225,200);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.add(new JPanel(), BorderLayout.EAST);
		this.add(new JPanel(), BorderLayout.WEST);
		this.add(panel, BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);

		this.setVisible(true);
	}
	
	/** This method complete the purpose of this window.  After this, the window will
	 *  be closed and the user will return to the main database window.
	 * 
	 * @author Logan James
	 * 
	 * @param movie - The Movie object to be added to the Library in DatabaseWindow
	 */
	public void addToLibrary(Movie movie) {
		controller.addToLibrary(movie);
		this.close();
	}
	
	/** This function servers as an access point for the AddMovieController to see what is
	 *  in the JTextFields.  This allows the controller to make a Movie object.
	 *  
	 *  @author Logan James
	 * 
	 * @return The array of JTextFields used in the window is returned.
	 */
	public JTextField[] getFields() {
		return fields;
	}
	
	/** This function closes the current window as it is no longer required.
	 * 
	 *  @author Logan James
	 * 
	 */
	public void close() {
		this.dispose();
	}

}
