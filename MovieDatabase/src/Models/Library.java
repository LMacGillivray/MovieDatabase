/* MovieDatabase.Models.Library
 * Last Updated: Oct 2, 2017
 * Library object
 * Stores an ArrayList of Movie objects
 * © lucky-mac11
 */
package Models;
import java.util.*;

public class Library {
	private ArrayList<Movie> library;
	
	public Library(){
		library = new ArrayList<Movie>();
		
		Movie pulpFiction = new Movie("Pulp Fiction", "R");
		pulpFiction.setYear("1994");
		pulpFiction.setDirector("Quentin Tarantino");
		this.addMovie(pulpFiction);
	}

	public void addMovie(String name, String rating){
		library.add(new Movie(name,rating));
	}
	
	public void addMovie(Movie movie) {
		library.add(movie);
	}
	
	public String[] getRelevantData() {
		String[] str = new String[library.size()];
		int i = 0;
		for(Movie movie : library) {
			str[i] = movie.getRelevantData();
			i++;
		}
		return str;
	}
	
	public void printLibrary(){
		for(int i = 0; i < library.size(); i++){
			System.out.println(library.get(i).toString());
		}
	}

	public Movie find(String trim) {
		for (Movie mov : library) {
			if (mov.getName().equals(trim))
				return mov;
		}
		return null;
	}
}
