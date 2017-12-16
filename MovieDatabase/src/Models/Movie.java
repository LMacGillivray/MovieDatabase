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
		this.year = 0;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public void setYear(String newYear){
		if(!newYear.equals("")) {
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
	
	public String toString() { 
		String str = name;
		if(year == 0)
			str += "   (" + year + ")";
		str += "   Rated:" + rating;
		if(director == null)
			str += "   Directed by: " + director;
		return str;
	}

	public String getRating() {
		return rating;
	}

	public String getYear() {
		if (year != 0) {
			return Integer.toString(year);
		}
		return "Unknown";
	}

	public String getDirector() {
		// TODO Auto-generated method stub
		return director;
	}
}
