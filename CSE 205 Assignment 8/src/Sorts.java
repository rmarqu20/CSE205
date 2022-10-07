import java.util.Comparator;

// Assignment #: 8
//         Name: Richard Marquez Cortes
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
//  Description: This class provides comparator classes with selection sorting method; utility class. 

public class Sorts
{
	//sorting method using selection sort algorithm
	public static void sort(Movie[] movieList, int size, Comparator<Movie> comp) 
	{
		int min;
	    for (int index = 0; index < movieList.length-1; index++)
	    {
	    	min = index;
	        for (int scan = index+1; scan < movieList.length; scan++)
	        {
	        	if (comp.compare(movieList[min], movieList[scan]) > 0)
	            {
	               min = scan;
	            }
	         }
	         swap(movieList, min, index);
	      }
	}
	   //swaps movie placement
	   private static void swap(Movie[] movieList, int index1, int index2)
	   {
	       Movie temp = movieList[index1];
	       movieList[index1] = movieList[index2];
	       movieList[index2] = temp;
	   }
}
