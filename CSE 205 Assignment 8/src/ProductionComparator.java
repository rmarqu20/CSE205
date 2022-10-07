import java.util.Comparator;

// Assignment #: 8
//         Name: Richard Marquez Cortes
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
//  Description: This class sorts production companies. 

public class ProductionComparator implements Comparator<Movie> 
{
	//compares production company names
	public int compare(Movie first, Movie second)
	{
		char one = first.getProdCompany().getCompanyName().charAt(0);
		char two = second.getProdCompany().getCompanyName().charAt(0);
		if(one < two)
		{
			return -1; 
		}
		if(one > two)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}