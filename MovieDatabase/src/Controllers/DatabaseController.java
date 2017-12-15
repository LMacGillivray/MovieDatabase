package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Library;
import Models.Movie;
import Views.AddMovieWindow;
import Views.DatabaseWindow;

public class DatabaseController implements ActionListener {
	private Library library;
	private DatabaseWindow window;
	
	public DatabaseController(Library library, DatabaseWindow window) {
		this.library = library;
		this.window = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Add")) {
			new AddMovieWindow(this);
		}

	}

	public void addToLibrary(Movie movie) {
		library.addMovie(movie);
		window.newScreen();
	}

}
