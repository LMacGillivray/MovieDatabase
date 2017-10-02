/* MovieDatabase.Controllers.MovieLibrary
 * © lucky-mac11
 * Last Updated: Oct 2, 2017
 * Controls basic user input and how it affects the library
 */
import java.util.*;

import Models.*;
import Views.HelpView;;

public class LibraryViewer {
	private Scanner scan = new Scanner(System.in);
	private Library myLibrary;
	private Boolean keepGoing;
	
	public LibraryViewer(){
		myLibrary = new Library();
		keepGoing = true;
	}
	
	public void LibraryView(){
		while(keepGoing){
			System.out.println("Hello, what would you like to do?");
			String response = scan.nextLine();
			String[] keywords = response.split("--");
			if(keywords[0].equalsIgnoreCase("Help")){
				new HelpView();
			} else if(keywords[0].equalsIgnoreCase("Quit")){
				keepGoing = false;
			} else if(keywords[0].equalsIgnoreCase("Print")){
				printMovie();
			} else if (keywords[0].equalsIgnoreCase("Add")){
				if(keywords.length == 3){
					myLibrary.addMovie(keywords[1],keywords[2]);
				} else {
					myLibrary.addMovie(keywords[1], null);
				}
			}  else if (keywords[0].equalsIgnoreCase("Search")){
				Movie movie = search(keywords[0]); 
				if(movie != null){
					System.out.println(movie.toString());
				}
			} else if((keywords[0].equalsIgnoreCase("Edit"))&&(keywords.length>1)){
				Movie movie = search(keywords[1]);
				if(movie != null){
					if(keywords.length != 4){
						System.out.println("Please enter a property to change");
						keywords[0] = scan.nextLine();
						
						System.out.println("Please enter the new value");
						keywords[1] = scan.nextLine();
						edit(movie, keywords[0], keywords[1]);
					} else {
						edit(movie, keywords[2], keywords[3]);
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
		if(myLibrary.getSize() == 0){
			System.out.println("You have no movies");
		} else {
			myLibrary.printLibrary();
		}
	}
	
	private Movie search(String name){
		Movie wanted = myLibrary.searchLibrary(name);
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
			movie.setFormat(newValue);
		} else if(property.equalsIgnoreCase("Year")){
			movie.setYear(newValue);
		}
	}
}
