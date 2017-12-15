package Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import Models.Movie;
import Views.AddMovieWindow;

public class AddMovieController implements ActionListener{
	private AddMovieWindow window;
	
	public AddMovieController(AddMovieWindow window){
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JTextField[] fields = window.getFields();
		if(fields[0].getText().equals("")) {
			// Send error message
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
