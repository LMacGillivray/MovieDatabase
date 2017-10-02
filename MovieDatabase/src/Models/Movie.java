package Models;

public class Movie {
	private String name;
	private String year;
	private String rating;
	private String format;
	
	public Movie(String name){
		new Movie(name, null);
	}
	
	public Movie(String name, String rated){
		this.name = name;
		//this.year = year;
		if(!(rated == null)){
			this.setRating(rated);
		} else {
			this.setRating("NR");
		}
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public void setYear(String newYear){
		year = newYear;
	}
	
	public String getYear(){
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

	public String getFormat(){
		return format;
	}
	
	public void setFormat(String newFormat){
		format = newFormat;
	}
	
	public String toString(){
		String string = "\n   Name: " + name;
		if(year != null){
			string += " (" + year + ")";
		}
		string += "\n   Rating: " + rating + "\n";
		if(format != null){
			string += "   Format: " + format + "\n";
		}
		return string;
	}
}
