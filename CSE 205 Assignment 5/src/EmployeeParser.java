public class EmployeeParser 
{
	public static Employee parseStringToEmployee(String line)
	{
		String[] parse = new String[6];	//creates string array to store information
		parse = line.split(":");	//divides up the input
		
		if(parse[0].equals("FullTime"))	//decides whether employee is full-time or part-time
		{
			return new FullTimeEmployee(parse[1],parse[2],parse[3],Double.parseDouble(parse[4]),Double.parseDouble(parse[5]));
		}
		else
		{
			return new PartTimeEmployee(parse[1],parse[2],parse[3],Double.parseDouble(parse[4]),Integer.parseInt(parse[5]));
		}
	}
}
