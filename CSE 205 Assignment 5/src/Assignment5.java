// Assignment #: 5
//         Name: Richard Marquez Cortes
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
//  Description: The Assignment 5 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList

public class Assignment5
 {
  public static void main (String[] args)
   {
     // ArrayList object is used to store Employee objects
     ArrayList<Employee> employeeList = new ArrayList<Employee>();
     
     try
      {
       printMenu();     // print out menu

       // create a BufferedReader object to read input from a keyboard
       InputStreamReader isr = new InputStreamReader (System.in);
       BufferedReader stdin = new BufferedReader (isr);
          
       String line, inputInfo;
       boolean operation = false;	
       char input1;
       do
        {
         System.out.println("What action would you like to perform?");
         line = stdin.readLine().trim();
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)
          {
           switch (input1)
            {
             case 'A':   //Add Employee
               System.out.print("Please enter some employee information to add:\n");
               inputInfo = stdin.readLine().trim();
               
               employeeList.add(EmployeeParser.parseStringToEmployee(inputInfo));	//Adds a new employee
               break;
                   
             case 'C':   //Compute Pay Amount      
               for(int j = 0; j < employeeList.size(); j++)
               {
            	   employeeList.get(j).computePayAmount();	//computes pay amount for all current employees
               }
               
               System.out.print("pay amount computed\n");
               break;
             case 'D':   //Search for Employee
               System.out.print("Please enter an employeeID to search:\n");
               String id = stdin.readLine().trim();

               for(int j = 0; j < employeeList.size(); j++)
               {
            	  Employee flag = employeeList.get(j);	//creates a temporary copy of employee
            	  if(id.equals(flag.getEmployeeId()))
            	  {
            		  operation = true;	//scans employee objects to find ID
            	  }
               } 
                if (operation == true)
                 System.out.print("Employee found\n");	
                else
                 System.out.print("Employee not found\n");
                
                operation = false;	//resets boolean back to false
               break;
             case 'L':   //List Employees
            	 for(int j = 0; j < employeeList.size(); j++)
                 {
            		 Employee flag = employeeList.get(j);	//creates a temporary copy of employee
            		 System.out.println(flag.toString());	//prints out information
                 }
            	 if(employeeList.isEmpty())
            	 {
            		 System.out.println("no employee");	//if no employee exists, prints "no employee"
            	 } 
               break;
             case 'Q':   //Quit
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
         }
        else
         {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q'); // stop the loop when Q is read
      }
     catch (IOException exception)
      {
        System.out.println("IO Exception");
      }
  }
  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Employee\n" +
                      "C\t\tCompute Pay\n" +
                      "D\t\tSearch for Employee\n" +
                      "L\t\tList Employees\n" +
                      "Q\t\tQuit\n" +
                      "?\t\tDisplay Help\n\n");
  }
}