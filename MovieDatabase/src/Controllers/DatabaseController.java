package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Library;
import Views.AddMovieWindow;

public class DatabaseController implements ActionListener {
	private Library library;
	
	public DatabaseController() {
		library = new Library();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Add")) {
			new AddMovieWindow(library);
		}

	}

}
