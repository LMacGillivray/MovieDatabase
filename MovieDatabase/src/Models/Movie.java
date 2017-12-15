/* MovieDatabase.Models.Movie
 * Last Updated: Oct 2, 2017
 * Movie object
 * Stores name, year, rating, and format
 * © lucky-mac11
 */

package Models;

public class Movie {
	private String name;
	private String rating;
	private int year;
	private String director;
	
	public Movie(String name){
		new Movie(name, null);
	}
	
	public Movie(String name, String rated){
		this.name = name;
		this.rating = rated;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public void setYear(String newYear){
		if(newYear.equals("")) {
			year = 0; 
		} else { 
			year = Integer.parseInt(newYear);
		}
	}
	
	public void setDirector(String newDirector){
		if(newDirector.equals("")) {
			this.director = "Unknown";
		} else {
			director = newDirector;
		}
	}
	
	public String getRelevantData() {
		String str = name;
		if(year != 0) { 
			str += "    (" + year + ")";
		}
		return str;
	}
}
