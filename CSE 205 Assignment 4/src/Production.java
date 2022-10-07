// Assignment #: 4
// Arizona State University - CSE205
// Name: Richard Marquez Cortes
// StudentID: 1214775731
// Lecture: TTh 1:30-2:45pm
// Description: Assignment 4 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//        enter the next choice until the choice of 'Q' (Quit) is entered.

public class Production 
{
	//Instance Variables
	private String companyName; 
	private String locationCity; 
	private String locationState; 
	
	//Default Constructor
	public Production()
	{
		companyName = ""; 
		locationCity = ""; 
		locationState = ""; 
	}
	
	//Regular Constructor
	public Production(String companyName, String locationCity, String locationState)
	{
		this.companyName = companyName; 
		this.locationCity = locationCity; 
		this.locationState = locationState; 
	}
	
	//Get Methods, retrieves information
	public String getCompanyName()
	{
		return companyName;
	}
	public String getLocationCity()
	{
		return locationCity;
	}
	public String getLocationState()
	{
		return locationState;
	}
	
	//Set Methods, sets values provided by the user
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName; 
	}
	public void setLocationCity(String locationCity)
	{
		this.locationCity = locationCity; 
	}
	public void setLocationState(String locationState)
	{
		this.locationState = locationState; 
	}
	
	//String Method, used to print out results
	public String toString()
	{
		String prodString = companyName + " at "+ locationCity + "," + locationState;
		return prodString;	
	}
	
}
