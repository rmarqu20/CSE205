import java.text.NumberFormat;
public abstract class Employee 
{
	protected String firstName; 
	protected String lastName;
	protected String employeeId; 
	protected double payAmount; 
	
	NumberFormat nf = NumberFormat.getCurrencyInstance();	//formats money into $##.## 
	
	public Employee()	//default constructor
	{
		firstName = "";
		lastName = "";
		employeeId = "";
		payAmount = 0.0;
	}
	public Employee(String firstName, String lastName, String employeeId)	//regular constructor
	{
		this.firstName = firstName;
		this.lastName = lastName; 
		this.employeeId = employeeId;
		this.payAmount = 0.0;
	}
	public String getEmployeeId()	//gets ID from object
	{
		return employeeId;
	}
	public abstract void computePayAmount();	//calculates pay amount
	public String toString()
	{
		return "\n" + "First name:" + "\t\t" + firstName + "\n"
				+ "Last name:" + "\t\t" + lastName + "\n" + 
				"Employee ID:" + "\t\t" + employeeId + "\n" + 
				"Pay Amount:" + "\t\t" + nf.format(payAmount) + "\n"; 
	}
}
