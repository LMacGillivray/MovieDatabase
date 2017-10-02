package Views;

public class HelpView {
	public HelpView(){
		System.out.println("You can enter the following commands:");
		System.out.println("    Help - outputs this help message");
		System.out.println("    Search--name - search library for specific movie with name");
		System.out.println("    Add--film name--film rating - adds the specified movie to your library");
		System.out.println("    Print - prints out your library");
		System.out.println("    Edit--Name - edit a movie currently in your library");
		System.out.println("    Quit - quits the app");
	}
}
