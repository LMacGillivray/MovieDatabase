package Controllers;
import java.util.Scanner;
import Models.Library;

public class AddMovieController {
	public AddMovieController(String[] response, Library library, Scanner scan){
		if(response.length == 3){
			// Add a movie with a rating
			library.addMovie(response[1],response[2]);
		} else if (response.length == 2){
			// Add a movie with just the title
			library.addMovie(response[1], null);
		} else {
			// If no movie is entered, ask for a movie
			System.out.println("Please enter a movie title to add.");
			library.addMovie(scan.nextLine(),null);
		}

	}
}
