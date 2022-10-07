import java.util.Scanner;
public class Scanner1
{
	public static void main(String[] args)
	{
		/*
      		//First Example to tokenize the string "http:/eas.asu/edu"
      		String line = "http:/eas.asu/edu";
      		Scanner scan = new Scanner(line).useDelimiter("/");
      		System.out.println("The input line is: " + line);
      		while (scan.hasNext())
      		{
				String word = scan.next();//scan the next token
				System.out.println(word + " with length " + word.length());
		    }
		    System.out.println();

		    //Second Example with "http:/eas.asu"
		    line = "http:/eas.asu/";
		    scan = new Scanner(line).useDelimiter("/");
		    while (scan.hasNext())
		    {
			     	String word = scan.next();
			        System.out.println(word + " with length " + word.length());
		   }
		   System.out.println();

           //Third example with "http://edu"
        	line = "http://edu";
        	scan = new Scanner(line).useDelimiter("/");
        	while (scan.hasNext())
        	{
        		String word = scan.next();
        		System.out.println(word + " with length " + word.length());
        	}
        	System.out.println();
	*/
        	//Forth example with "/eas.asu/edu"
			String type = "FullTime"; 
			String firstName = "Richard";
			String lastName = "Marquez"; 
			int employeeID = 6969;
			int salary = 10000000;
			int bonus = 200000; 
			String str1 = type + ":" + firstName + ":" + lastName + ":" + employeeID + ":" + salary + ":" + bonus;
        	String line = "/eas.asu/edu";
        	System.out.println(str1);
        	Scanner scan = new Scanner(str1).useDelimiter(":");
        	while (scan.hasNext())
        	{
        		String word = scan.next();
        		System.out.println(word);
        	}

        }
  }

