package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Models.Library;
import Models.Movie;
import Views.AddMovieWindow;
import Views.DatabaseWindow;
import Views.ViewMovieWindow;

public class DatabaseController implements ActionListener, ListSelectionListener {
	private Library library;
	private DatabaseWindow window;
	
	public DatabaseController(Library library, DatabaseWindow window) {
		this.library = library;
		this.window = window;
	}
	
	public void addToLibrary(Movie movie) {
		library.addMovie(movie);
		window.newScreen();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Add")) {
			new AddMovieWindow(this);
		} else if (arg0.getActionCommand().equals("View")) {
			new ViewMovieWindow(this, window.getSelectedMovie());
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		window.setOptionsEnable();
	}

}
