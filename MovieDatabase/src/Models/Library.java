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
	}

	public void addMovie(String name, String rating){
		library.add(new Movie(name,rating));
	}
	
	public void addMovie(Movie movie) {
		library.add(movie);
	}
	
	public void printLibrary(){
		for(int i = 0; i < library.size(); i++){
			Movie mov = library.get(i);
			System.out.println(mov.toString());
		}
	}
	
	public int getSize(){
		return library.size();
	}
	
	public Movie searchLibrary(String name){
		
		int index = -1;
		
		for(int i = 0; i < library.size(); i++){
			if(name.equals(library.get(i).getName())){
				index = i;
			}
		}
		
		//System.out.println(index);
		if(index == -1){
			return null;
		}
		return library.get(index);
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

	
	
}
