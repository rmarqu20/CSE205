public class FullTimeEmployee extends Employee
{
	private double salary; 
	private double bonus; 
	
	public FullTimeEmployee()	//default constructor 
	{
		super();
		salary = 0.0;
		bonus = 0.0;	
	}
	public FullTimeEmployee(String firstName, String lastName, String employeeId, double salary, double bonus)	//regular constructor
	{
		super(firstName,lastName,employeeId);
		this.salary = salary; 
		this.bonus = bonus;
	}
	public String toString()	//prints information using toString from Employee class plus more
	{
		return "\n" + "Full Time Employee:" + 
				super.toString() + "Salary:" + "\t\t\t" + nf.format(salary) + "\n"
				+ "Bonus:" + "\t\t\t" + nf.format(bonus) + "\n"; 
	} 
	public void computePayAmount()	//calculates pay amount
	{
		super.payAmount = salary + bonus; 
	}
}
