package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import Models.Movie;
import Views.AddMovieWindow;
import Views.AddMovieWindow.errorType;

public class AddMovieController implements ActionListener{
	private AddMovieWindow window;		// The JFrame that called the function, 
										// used in the actionPerformed class
	
	/** This constructor creates the controller, as well as sets up the
	 *  variable window
	 * 
	 * @param window - The AddMovieWindow that called the controller
	 */
	public AddMovieController(AddMovieWindow window){
		this.window = window;
	}

	/** This function listens for a JMenuItem selection from the 
	 *  AddMovieWindow
	 * 
	 * @author Logan James
	 * 
	 * @param arg0 - The ActionEvent that triggers this method
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTextField[] fields = window.getFields();
		if(fields[0].getText().equals("")) {
			window.sendError(errorType.NO_NAME_ERROR);
		} else if (!fields[2].getText().matches("[-+]?\\d*\\.?\\d+")) {
			window.sendError(errorType.YEAR_INPUT_ERROR);
		} else { 
			if(fields[1].getText().equals("")) {
				fields[1].setText("UK");
			}
			
			Movie movie = new Movie(fields[0].getText(), fields[1].getText());
			movie.setYear(fields[2].getText());
			movie.setDirector(fields[3].getText());
			
			window.addToLibrary(movie);
		}
		
	}
}