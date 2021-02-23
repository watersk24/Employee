/* Author: Kevin Waters
 * Date: 20 Oct 2020
 * Description: The SalariedEmployee class provides an implementation of the Employee abstract class and represents an employee who is 
 * 	paid a weekly salary. Also provides overridden earnings and string methods. 
 */

package Employee;

public class SalariedEmployee extends Employee { // Class extends abstract class Employee
	private double weeklySalary; // Declaration of class variable that is unique to SalariedEmployee
	
	// Class constructor
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double weeklySalary) {
		super(firstName, lastName, socialSecurityNumber, birthDate); // Use of super class to instantiate class variables
		
		// Validates weeklySalary input when creating new SalariedEmployee object
		if (weeklySalary < 0.0) {
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}
		
		this.weeklySalary = weeklySalary;
	}
	
	// Set salary
	public void setWeeklySalary(double weeklySalary) {
		if (weeklySalary < 0.0) {
			throw new IllegalArgumentException("Weekly salary must be >= 0.0"); // Validates weeklySalary input
		}
		
		this.weeklySalary = weeklySalary;
	}
	
	// Return salary
	public double getWeeklySalary() {
		return weeklySalary;
	}
	
	// Calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings() {
		return getWeeklySalary();
	}
	
	// Return String representation of SalariedEmployee object
	@Override
	public String toString() {
		return String.format("Salaried employee: %s%n%s: $%,.2f", super.toString(), "Weekly salary", getWeeklySalary());
	}
}
