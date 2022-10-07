// Assignment #: 10
//         Name: Richard Marquez Cortes
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
// 	Description: A linked list is a sequence of nodes with efficient
// 				 element insertion and removal.
// 				 This class contains a subset of the methods of the
// 				 standard java.util.LinkedList class.

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedList
{
   //nested class to represent a node
   private class Node
   {
          public Object data;
          public Node next;
   }

   //only instance variable that points to the first node.
   private Node first;

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
   }


   // Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex
             = new NoSuchElementException();
         throw ex;
       }
      else
         return first.data;
   }

   // Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex = new NoSuchElementException();
         throw ex;
       }
      else
       {
         Object element = first.data;
         first = first.next;  //change the reference since it's removed.
         return element;
       }
   }

   // Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      //create a new node
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      //change the first reference to the new node.
      first = newNode;
   }

   // Returns an iterator for iterating through this list.
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }
   
   //goes through linked list and counts the size 
   private int size()
   {
	   ListIterator it = this.listIterator();	
	   int count = 0;
	   while(it.hasNext())
	   {
		   count++; 	//for every object, adds one
		   it.next();
	   }   
	   return count;	   
   }
   
   //prints out strings in between { }
   public String toString()
   {
	   ListIterator it = this.listIterator();
	   String result = "{ ";
	   while(it.hasNext())
	   {
		   String current = (String)it.next();
		   result += current + " "; 			//concats into larger string
	   }
	   result += "}\n"; 
	   return result;
   }
   
   //checks to see if the linked list is empty
   public boolean isEmpty()
   {
	   ListIterator it = this.listIterator(); 
	   Boolean result = true; 
	   while(it.hasNext())
	   {
		   if((String)it.next() == null)	//list is empty
		   {
			   result = true;
		   }
		   else
		   {
			   result = false;		//list is not empty
		   }
	   }
	   return result;
   }
   
   //adds a string to the desired index
   public void addElementAt(Object o, int index)
   {
		ListIterator it = this.listIterator(); 
		int count = 0;
		while(it.hasNext() && count != index)
		{
			it.next();
			count++;
		}		
		if (index < 0 || index > count)		//if entered index is negative or larger than size
        {
         IndexOutOfBoundsException ex = new IndexOutOfBoundsException();	//throws IndexOutOfBounds object
         throw ex;
        }
		it.add(o);
   }
   
   //adds multiple strings to the desired index
   public void addSomeElementsAt(Object o, int index, int num)
   {
	   	ListIterator it = this.listIterator(); 
		int count = 0;
		while(it.hasNext() && count != index)
		{
			it.next();
			count++;
		}
		if (index < 0 || index > count)		//if entered index is negative or larger than size
        {
         IndexOutOfBoundsException ex = new IndexOutOfBoundsException();	//throws IndexOutOfBounds object
         throw ex;
        }
		for(int j = 0; j < num; j++)	//adds string the desired amount of times
		{
			it.add(o);
		}
   }
   
   //searches for string and returns it 
   public String getElement(int index)
   {
	   ListIterator it = this.listIterator();
	   String result = "";
	   int count = 0;
	   while(it.hasNext() && count != index)
	   {		   
		   it.next();
		   count = count + 1;
	   }
	   if(index < 0 || index > size()-1)	//if entered index is negative or larger than size
       {
        IndexOutOfBoundsException ex = new IndexOutOfBoundsException();		//throws IndexOutOfBounds object
        throw ex;
       }
	   result = (String)it.next();	//saves and returns string at index
	   return result;
   }
   
   //compares two strings using .compareTo and removes the largest one
   public String findLargestAndRemove()
   {
	   ListIterator it = listIterator();
	   String large = "";
	   String current;
	   if(!it.hasNext())
	   {
		   return null;
	   }
	   while(it.hasNext())
	   {	   
		   String temp = (String)it.next();
		   if((temp).compareTo(large) > 0)		//compares first string with next
		   {
			   large = temp; 	//if larger, string becomes largest
		   }		   
	   }
	   ListIterator it2 = listIterator();
	   while(it2.hasNext())
	   {
		   current = (String)it2.next();
		   if(current.equals(large))		//if the current object is equal to the largest
		   {
			   it2.remove();		//object gets removed
		   }
	   }
	   return large;
   }
   
   //counts how many times a string appears in list
   public int countHowMany(Object o)
   {
	   ListIterator it = this.listIterator();
	   int count = 0;
	   while(it.hasNext())
	   {
		   String first = (String)it.next();
		   String second = o.toString();
		   if(first.equals(second))		//if string is equal to object being searched for 
		   {
			   count++; 	//increases by one
		   }
	   }
	   return count;
   }
   
   //reverses the linked list up to a certain point starting from the back
   public void reverseLastSome(int howMany) 
   {   
	   ListIterator it = this.listIterator();
	   ListIterator it2 = this.listIterator();
	   int size = size();
	   int count = 0;
	   int count2 = 0;
	   ArrayList<String> reverse = new ArrayList<String>();		//temporary ArrayList to hold strings 
	   Node previous = null;
	   Node current = first;	//nodes
	   Node next;
	   if(howMany <=0)		//if entered number is negative or zero, nothing changes
	   {
		   return;
	   }
	   else if(howMany >= size)		//if entered number is larger or equal to size, reverses the entire list
	   {
		while (current != null) 
		{
			next = current.next;
			current.next = previous;	//moves node pointers 
			previous = current;
			current = next;
		}
		first = previous;
	   }
	   else if(howMany < size)		//if entered number is less than size, only reverses a portion of the list
	   {
		   	int dif = size - howMany;	
		   	while(it.hasNext() && count < dif)
		   	{
		   		it.next();		//moves iterator to where reversing will happen
		   		count++;
		   	}
		   	while(it.hasNext())
		   	{
		   		String str = (String)it.next();		//saves string
		   		reverse.add(str);		//adds string to ArrayList
		   	}	
		   	while(it2.hasNext() && count2 < dif)
		   	{
		   		it2.next();		//moves iterator to where reversing will happen
		   		count2++;
		   	}
		   	while(it2.hasNext())
		   	{
		   		for(int i = reverse.size()-1; i >= 0; i--)
			   	{
			   		it2.next();		//moves iterator to correct index
			   		it2.set(reverse.get(i));	//sets string that was stored in ArrayList back into linked list
			   	}
		   	}	
	   }
   }

   //nested class to define its iterator
   private class LinkedListIterator implements ListIterator
   {
      private Node position; //current position
      private Node previous; //it is used for remove() method

      // Constructs an iterator that points to the front
      // of the linked list.

      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Tests if there is an element after the iterator position.
     public boolean hasNext()
      {
         if (position == null) //not traversed yet
          {
             if (first != null)
                return true;
             else
                return false;
          }
         else
           {
              if (position.next != null)
                 return true;
              else
                 return false;
           }
      }

      // Moves the iterator past the next element, and returns
      // the traversed element's data.
      public Object next()
      {
         if (!hasNext())
          {
           NoSuchElementException ex = new NoSuchElementException();
           throw ex;
          }
         else
          {
            previous = position; // Remember for remove

            if (position == null)
               position = first;
            else
               position = position.next;

            return position.data;
          }
      }

      // Adds an element after the iterator position
      // and moves the iterator past the inserted element.
      public void add(Object element)
      {
         if (position == null) //never traversed yet
         {
            addFirst(element);
            position = first;
         }
         else
         {
            //making a new node to add
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            //change the link to insert the new node
            position.next = newNode;
            //move the position forward to the new node
            position = newNode;
         }
         //this means that we cannot call remove() right after add()
         previous = position;
      }

      // Removes the last traversed element. This method may
      // only be called after a call to the next() method.
      public void remove()
      {
         if (previous == position)  //not after next() is called
          {
            IllegalStateException ex = new IllegalStateException();
            throw ex;
          }
         else
          {
           if (position == first)
            {
              removeFirst();
            }
           else
            {
              previous.next = position.next; //removing
            }
           //stepping back
           //this also means that remove() cannot be called twice in a row.
           position = previous;
      }
      }

      // Sets the last traversed element to a different value.
      public void set(Object element)
      {
         if (position == null)
          {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
          }
         else
          position.data = element;
      }
   } //end of LinkedListIterator class
} //end of LinkedList class
