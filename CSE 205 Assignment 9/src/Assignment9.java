// Assignment #: 9
//         Name: Richard Marquez Cortes
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
//  Description: This main method reads in integers from the input until a zero is entered.  
// 				 It stores these integers in an array, and uses the recursive methods to do calculations

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Assignment9 
{
	public static void main(String[] args) 
	{
		int[] ar;
		String numStr;
		int num;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		try
		{
			//input and buffer reader
			InputStreamReader isr = new InputStreamReader(System.in);	
			BufferedReader buff = new BufferedReader(isr);			
			do
			{			
			numStr = buff.readLine().trim();	//saves numbers entered as a String
			num = Integer.parseInt(numStr);		//parses the String to an Integer
			arr.add(num);		//adds value to ArrayList
			} while(num != 0);		
		}
		catch(IOException ex)
		{
			System.out.println("IO Exception");		//catches IO exceptions
		}
		ar = new int[arr.size()];	//initializes regular Array with ArrayList size
		for(int i = 0; i < arr.size() - 1; i++)
		{			
			int temp = arr.get(i);		//copies values into appropriate indexes 
			ar[i] = temp;
		}
		//prints results
		System.out.print("The minimum number is " + findMin(ar, 0,ar.length-1)+ "\n");
		System.out.print("The smallest even integer in the sequence is " + computeSmallestEven(ar, 0,ar.length-1)+ "\n");
		System.out.print("The count of negative integers in the sequence is " + countNegativeNumbers(ar, 0,ar.length-1)+ "\n");
        System.out.print("The sum of numbers that are divisible by 3 is " + computeSumOfNumbersDivisibleBy3(ar, 0,ar.length-1)+ "\n");
	}
	//recursion methods.  
	//finds the minimum in an array using recursion.
	public static int findMin(int[] numbers, int startIndex, int endIndex)
	 {
		if(startIndex == endIndex)
		{
			return numbers[endIndex];	//returns value at last index
		}
		else 
		{
			int temp = findMin(numbers,startIndex, endIndex - 1);	//shortens the Array by 1 and calls the method again
			if(temp > numbers[endIndex])
			{
				return numbers[endIndex];	//value at last index is already the smallest, so it's returned
			}
			else 
			{
				return temp;	//new final index value is return because it's smaller than last index value 
			}
		}
	 }
	//finds the smallest even integer
	public static int computeSmallestEven(int[] elements, int startIndex, int endIndex)
	{
		if(startIndex == endIndex)
		{
			return 0;		//by default 0 is the smallest number because it is included in the Array
		}
		else 
		{
			int temp = computeSmallestEven(elements,startIndex, endIndex - 1);		//shortens the Array by 1 and calls the method again
			if(temp > elements[endIndex] && (elements[endIndex] % 2) == 0)
			{
				return elements[endIndex];		//value at last index is already the smallest AND its even, so it's returned
			}
			else 
			{
				return temp;	//new final index value is return because it's smaller than last index value 
			}			
		}
	}
	//uses recursion to count the number of negative integers 
	public static int countNegativeNumbers(int[] elements, int startIndex, int endIndex)
	{
		if(startIndex == endIndex)
		{
			if(elements[endIndex] < 0)
			{
				return 1;	//last value is negative, so one negative number exists
			}
			else 
			{
				return 0;	//no negative numbers exist
			}
		}
		else 
		{
			int neg = countNegativeNumbers(elements,startIndex, endIndex - 1);
			if(elements[endIndex] < 0)
			{
				return neg + 1;		//increases negative number count by 1
			}
			else 
			{
				return neg;		//returns negative number count
			}
		}
	}
	//computes the sum of elements that are divisible by 3 using recursion
	public static int computeSumOfNumbersDivisibleBy3(int[] elements, int startIndex, int endIndex)
	{
		if(startIndex == endIndex)
		{
			if((elements[endIndex] % 3) == 0)
			{
				return elements[endIndex];	//the last index value is returned 
			}
			else 
			{
				return 0;	//no numbers are divisible by 3, so by default 0 is returned
			}
		}
		else 
		{
			int sum = computeSumOfNumbersDivisibleBy3(elements,startIndex, endIndex - 1);	//shortens the Array by 1 and calls the method again
			if((elements[endIndex] % 3) == 0)
			{
				return sum += elements[endIndex];	//adds divisible value to total sum
			}
			else 
			{
				return sum;		//returns sum
			}
		}
	}
}
