public class PartTimeEmployee extends Employee
{
	private double hourlyRate;
	private int hours; 
	
	public PartTimeEmployee()	//default constructor
	{
		super();
		hourlyRate = 0.0; 
		hours = 0;
	}
	public PartTimeEmployee(String firstName, String lastName, String employeeId, double hourlyRate, int hours)	//regular constructor
	{
		super(firstName,lastName,employeeId);
		this.hourlyRate = hourlyRate;
		this.hours = hours; 
	}
	public String toString()	//prints information using toString from Employee class plus more
	{
		return "\n" + "Part Time Employee:" + 
				super.toString() + "HourlyRate:" + "\t\t" + nf.format(hourlyRate) + "\n"
				+ "Hours:" + "\t\t\t" + hours + "\n"; 
	} 
	public void computePayAmount()	//calculates pay amount
	{
		super.payAmount = hourlyRate * hours; 
	}
}
