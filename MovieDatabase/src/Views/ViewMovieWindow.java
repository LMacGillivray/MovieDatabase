package Views;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controllers.DatabaseController;
import Models.Movie;

public class ViewMovieWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	//private DatabaseController control;
	//private Movie movie;
	
	public ViewMovieWindow(DatabaseController control, Movie movie) {
		super(movie.getName());
		//this.control = control;
		//this.movie = movie;
		
		JPanel panel = new JPanel(new GridLayout(0,2));
		panel.add(new JLabel("Film:"));
		panel.add(new JLabel(movie.getName()));
		panel.add(new JLabel("Rating:"));
		panel.add(new JLabel(movie.getRating()));
		panel.add(new JLabel("Year of Release:"));
		panel.add(new JLabel(movie.getYear()));
		panel.add(new JLabel("Directpr:"));
		panel.add(new JLabel(movie.getDirector()));
		
		this.setSize(275,200);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.add(new JPanel(), BorderLayout.EAST);
		this.add(new JPanel(), BorderLayout.WEST);
		this.add(panel, BorderLayout.CENTER);

		this.setVisible(true);
	}
}
