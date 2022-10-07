import java.util.Comparator;

// Assignment #: 8
//         Name: Richard Marquez Cortes
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
//  Description: This class sorts movies by year.

public class MovieYearComparator implements Comparator<Movie> 
{
	//compares movies' years
	public int compare(Movie first, Movie second)
	{
		if(first.getYear() < second.getYear())
		{
			return -1; 
		}
		if(first.getYear() > second.getYear())
		{
			return 1; 
		}
		else
		{
			return 0;
		}	
	}
}