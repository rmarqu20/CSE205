// Assignment #: 2
// Arizona State University - CSE205
//         Name: Richard Marquez Cortes  
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
//  Description: This class accepts integers provided by the user and returns the minimum integer,
//               smallest even integer, number of negative integers, and the sum of odd integers.

import java.util.Scanner;  // use the Scanner class located in the "java.util" directory
 
public class Assignment2 
 {
  public static void main (String[] args) 
   {
	 Scanner scan = new Scanner(System.in);
	 
	 int num = scan.nextInt();
	 int min = 0;				//default set to 0 because 0 is the integer that ends the program and should also be included 
	 int smallestEven = 0;		
	 int neg = 0;
	 int sumOdd = 0;
	 
	 while(num != 0) //program will run until user enters 0
	 {
		 int mod = num % 2;	//temporary int that will determine whether even or odd (0 = even, 1/-1 = odd)
		 if(num<min)
		 {
			 min = num; //any value lower than 0 will be restored as minimum value 
		 }
		 if(mod == 0)
		 {
			 if(num<smallestEven)
			 {
				 smallestEven = num; //same thing as step above, but with even integers only 
			 }
		 }
		 if(num>0)
		 {
			 neg++; //keeps track of the number of negative integers
		 }
		 if(mod == 1 || mod == -1)
		 {
			 sumOdd += num; //adds up all odd numbers
		 } 
		 num = scan.nextInt(); //updates integer and restarts the loop
	 }
	 System.out.println("The minimum integer is " + min + "\n" + 
	 		"The smallest even integer in the sequence is " + smallestEven + "\n" + 
	 		"The count of negative integers in the sequence is " + neg + "\n" + 
	 		"The sum of odd integers is "+ sumOdd);
	 scan.close();
	}
}
