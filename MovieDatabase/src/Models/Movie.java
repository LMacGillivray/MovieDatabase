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
		//this.year = year;
		//if(!(rated == null)){
			//this.setRating(rated);
		//} else {
			//this.setRating("NR");
		//}
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
	
	public int getYear(){
		return year;
	}
	
	public String getRating(){
		return rating;
	}
	
	public void setRating(String newRating){
		String[] ratings = {"G","PG","PG-13","14A","18A","R"};
		Boolean rated = false;
		for(int i = 0; i < ratings.length; i++){
			if(newRating.equals(ratings[i])){
				rating = newRating;
				rated = true;
			} else if(!rated){
				rating = "NR";
			}
		}
	}

	public String getDirector(){
		return director;
	}
	
	public void setDirector(String newDirector){
		director = newDirector;
	}
	
	public String toString(){
		String string = "\n   Name: " + name;
		if(year != 0){
			string += " (" + year + ")";
		}
		string += "\n   Rating: " + rating + "\n";
		if(!director.equals("Unknown")){
			string += "   director: " + director + "\n";
		}
		return string;
	}
}
