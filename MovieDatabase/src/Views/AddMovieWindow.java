package Views;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Models.Library;

public class AddMovieWindow {
	
	public AddMovieWindow(Library library) {
		JPanel panel = new JPanel();
		
		JTextField movieName = new JTextField(15);
		panel.add(new JLabel("Movie Name"));
		panel.add(movieName);
		
		JTextField movieRating = new JTextField(5);
		panel.add(new JLabel("Rating"));
		panel.add(movieRating);
		
		int option = JOptionPane.showOptionDialog(null, panel, "Problem Creation", 
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
				new String[] {"Okay"}, "Okay");
		
		if(option == JOptionPane.OK_OPTION && !movieName.getText().equals("")){
			library.addMovie(movieName.getText(), movieRating.getText());
			library.printLibrary();
		} else if (option == JOptionPane.OK_OPTION) {
			panel = new JPanel();
			panel.add(new JLabel("Sorry, no name was given"));
			JOptionPane.showOptionDialog(null, panel, "No name given", 
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, 
					new String[] {"Okay"}, "Okay");
		}
	}

}
