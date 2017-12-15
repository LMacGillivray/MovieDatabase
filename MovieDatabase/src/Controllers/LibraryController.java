/* MovieDatabase.Controllers.MovieLibrary
 * © lucky-mac11
 * Last Updated: Oct 2, 2017
 * Controls basic user input and how it affects the library
 */
package Controllers;
import java.util.*;
import Models.*;
import Views.*;

public class LibraryController {
	private Scanner scan = new Scanner(System.in);
	private Library library;
	private Boolean keepGoing;
	
	/* LibraryController Constructor
	 * Creates a library to be searched or manipulated
	 */
	public LibraryController(){
		library = new Library();	// Library object, the item that is manipulated
	}
	
	/* Main controller for library, runs a loop while 
	 * taking user input for how to manipulate the
	 * library.
	 */
	public void LibraryView(){
		// Boolean object to check if user requested to quit
		new DatabaseWindow();
		keepGoing = true;
		while(keepGoing){
			System.out.println("Hello, what would you like to do?");
			
			// User response, split at every '--' 
			String[] response = scan.nextLine().split("--");
			
			if(response[0].equalsIgnoreCase("Help")){
				// Calls HelpView object to output the options menu
				new HelpView();
				
			} else if((response[0].equalsIgnoreCase("Quit"))||(response[0].equalsIgnoreCase("Exit"))){
				/* Set loop Boolean to false so the 
				 * program can quit
				 */
				keepGoing = false;
				
			} else if(response[0].equalsIgnoreCase("Print")){
				// Outputs the movie and its contents
				printMovie();
				
			} else if (response[0].equalsIgnoreCase("Add")){
				// Adds a movie to the library
				//new AddMovieController(response, library, scan);
				
			}  else if (response[0].equalsIgnoreCase("Search")){
				// Search for, and output movie details
				Movie movie = search(response[0]); 
				if(movie != null){
					System.out.println(movie.toString());
				}
				
			} else if((response[0].equalsIgnoreCase("Edit"))&&(response.length>1)){
				Movie movie = search(response[1]);
				if(movie != null){
					if(response.length != 4){
						System.out.println("Please enter a property to change");
						response[0] = scan.nextLine();
						
						System.out.println("Please enter the new value");
						response[1] = scan.nextLine();
						edit(movie, response[0], response[1]);
					} else {
						edit(movie, response[2], response[3]);
					}
					System.out.println(movie.toString());
				}
			} else {
				System.out.println("Error - invalid command");
				System.out.println("Type 'Help' for assistance.");
			}
			
		}
		
		System.out.println("Goodbye");
		scan.close();
	}
	
	private void printMovie(){
		if(library.getSize() == 0){
			System.out.println("You have no movies");
		} else {
			library.printLibrary();
		}
	}
	
	private Movie search(String name){
		Movie wanted = library.searchLibrary(name);
		if(wanted == null){
			System.out.println("The movie does not exist in your library");
		}
		
		return wanted;
	}

	private void edit(Movie movie, String property, String newValue){
		if(property.equalsIgnoreCase("Name")){
			movie.setName(newValue);
		} else if(property.equalsIgnoreCase("Rating")){
			movie.setRating(newValue);
		} else if(property.equalsIgnoreCase("Format")){
			//movie.setFormat(newValue);
		} else if(property.equalsIgnoreCase("Year")){
			movie.setYear(newValue);
		}
	}
}
