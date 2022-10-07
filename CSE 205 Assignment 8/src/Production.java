import java.io.Serializable;

// Assignment #: 8
//         Name: Richard Marquez Cortes
//    StudentID: 1214775731
//      Lecture: TTh 1:30-2:45pm
//  Description: The Production class describes a Production.
//               It also provides their accessor, mutator methods,
//               and toString method.

public class Production implements Serializable
 {
 private String companyName;
 private String locationCity;
 private String locationState;

 //Constructor method to initialize intance variables.
 public Production()
  {
      companyName = new String("?");
      locationCity= new String("?");
      locationState = new String("?");
  }
 public Production(String companyName2, String locationCity2, String locationState2)
 {
     companyName = new String(companyName2);
     locationCity= new String(locationCity2);
     locationState = new String(locationState2);
 }

 //Accessor method for companyName
 public String getCompanyName()
  {
   return companyName;
  }

 //Accessor method for locationCity
 public String getLocationCity()
  {
   return locationCity;
  }

 //Accessor method for locationState
 public String getLocationState()
  {
    return locationState;
  }

 //Mutator method for companyName
 public void setCompanyName(String someCompanyName)
  {
   companyName = someCompanyName;
  }

 //Mutator method for locationCity
 public void setLocationCity(String someLocationCity)
  {
   locationCity = someLocationCity;
  }

 //Mutator method for locationState
 public void setLocationState(String someLocationState)
  {
    locationState = someLocationState;
  }

 //This method return a string containing the attribute information of a Production
 public String toString()
  {
   String result;

      result = companyName + " at " + locationCity + "," + locationState;

   return result;
  }
} 


