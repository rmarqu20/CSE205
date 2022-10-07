// Assignment #: 4
// Arizona State University - CSE205
// Name: Richard Marquez Cortes
// StudentID: 1214775731
// Lecture: TTh 1:30-2:45pm
// Description: Assignment 4 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//        enter the next choice until the choice of 'Q' (Quit) is entered.

public class Movie 
{
	//Instance Variables
	private String movieTitle;
	private int year; 
	private int length;
	private Production prodCompany;
	
	//Default Constructor 
	public Movie()
	{
		movieTitle = "";
		year = 0; 
		length = 0; 
		prodCompany = new Production(); 
	}
	
	//Regular Constructor
	public Movie(String movieTitle, int year, int length, Production prodCompany)
	{
		this.movieTitle = movieTitle;
		this.year = year; 
		this.length = length; 
		this.prodCompany = prodCompany; 
	}
	
	//Get Methods, retrieves information
	public String getMovieTitle()
	{
		return movieTitle;
	}
	public int getYear()
	{
		return year;
	}
	public int getLength()
	{
		return length;
	}
	public Production getProdCompany()
	{
		return prodCompany;	
	}
	
	//Set Methods, sets values provided by the user
	public void setMovieTitle(String movieTitle)
	{
		this.movieTitle =  movieTitle;
	}
	public void setYear(int year)
	{
		this.year = year; 
	}
	public void setLength(int length)
	{
		this.length = length;
	}
	public void setProdCompany(String companyName, String locationCity, String locationState) 
	{
		prodCompany.setCompanyName(companyName);
		prodCompany.setLocationCity(locationCity);
		prodCompany.setLocationState(locationState);
	}
	
	//String Method, used to print out results 
	public String toString()
	{
		String movString = ("\n" + "Movie Title:" + "\t\t" + movieTitle + "\n" +
							"Movie Length:" + "\t\t" + length + "\n" + 
							"Movie Year:" + "\t\t"+ year + "\n" + 
							"Movie Production:" + "\t" + prodCompany.toString() + "\n\n");
		return movString;
	}
}
