import java.io.Serializable;

// Assignment #: 8
//         Name: Richard Marquez Cortes
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
//  Description: This class is in charge of creating movies, sorting and removing movies. 

public class MovieArrangement implements Serializable
{
	//important instance variables
	private Movie[] movieList; 
	private int currentMoviesCount; 
	private int maxSize; 	
	Movie movie; 
	Production production; 
	private MovieYearComparator yea = new MovieYearComparator();
	private MovieTitleComparator tit = new MovieTitleComparator();	//sorting objects
	private ProductionComparator pro = new ProductionComparator();
	
	//constructor method
	public MovieArrangement(int maxx)
	{		
		maxSize = maxx;
		movieList = new Movie[maxSize];
		for(int i = 0; i < maxSize; i++)
		{
			movieList[i] = null;		//sets all movies to null
		}
		currentMoviesCount = 0;		//begins at 0
	}
	//method checks if movie exists in array
	public int movieExists(String movieTitle, int year)
	{
		movie = new Movie();
		movie.setMovieTitle(movieTitle);		//creates temporary movie to compare with existing movies
		movie.setYear(year);
		for(int i=0; i <movieList.length - 1; i++)
		{
			if(movieList[i].getMovieTitle().contentEquals(movie.getMovieTitle()) && movieList[i].getYear() == movie.getYear())
			{
				return i;	//index found
			}
		}
		return -1;		//movie not found
	}
	//method checks if production company exists in array
	public int productionExists(String companyName, String locationCity, String locationState)
	{
		production = new Production(companyName, locationCity, locationState);	//creates temporary production to compare with existing productions
		for(int i=0; i <movieList.length; i++)
		{
			if(movieList[i].getProdCompany().getCompanyName().contentEquals(production.getCompanyName()) && movieList[i].getProdCompany().getLocationCity().contentEquals(production.getLocationCity()) && movieList[i].getProdCompany().getLocationState().contentEquals(production.getLocationState()))
			{
				return i;	//index found
			}
		}
		return -1;	//production not found
	}
	//method creates and adds movies to the array
	public boolean addMovie(String title, int length, int year, String companyName, String locationCity, String locationState)
	{
		boolean flag = false;
		for(int i=0; i <movieList.length - 1; i++)
		{
			if(i == movieList.length - 1 && movieList != null)
			{
				flag = false;	//no movie
			}
			if(movieList[i] == null && flag == false)
			{
				production = new Production(companyName, locationCity, locationState);	//creates movie
				movieList[i] = new Movie(title, length, year, production);		
				currentMoviesCount ++;	//increases movie count
				flag = true; 
			}
		}	
		return flag;	
	}
	//method removes existing movies
	public boolean removeMovie(String movieTitle, int year)	
	{
		boolean flag = false; 
		for(int i=0; i <movieList.length - 1; i++)
		{
			if(movieList[i].getMovieTitle() != movieTitle || movieList[i].getYear() != year)
			{
				flag = false;	//no movie found
			}
			else if(movieList[i].getMovieTitle() == movieTitle && movieList[i].getYear() == year)
			{
				movieList[i] = null;
				currentMoviesCount--;	//decreases movie count
				flag = true;
			}
		}
		return flag;		
	}
	//sorts movies by title
	public void sortByMovieTitles()
	{
		Sorts.sort(movieList, currentMoviesCount, tit);
	}
	//sorts movies by year
	public void sortByMovieYears()
	{
		Sorts.sort(movieList, currentMoviesCount, yea);
	}
	//sorts movies by production companies
	public void sortByProductions()
	{
		Sorts.sort(movieList, currentMoviesCount, pro);
	}
	//uses toString method to display current movies
	public String listMovies()
	{
		String list = "";
		for(int i = 0; i < movieList.length-1;i++)
		{
			if(movieList[i] != null)
			{
				list += movieList[i].toString();	//adds new movies
			}
			else if(movieList[i] == null && list.contentEquals(""))
			{
				list = "\nno movie\n\n";	//no movies exist
			}
		}	
		return list;
	}
	//wipes the array clean and sets everything to null
	public void closeMovieArrangement()
	{		
		for(int i = 0; i < maxSize; i++)
		{
			movieList[i] = null;	//deletes all movies
		}
		currentMoviesCount = 0;
	}
}