/* Author: Kevin Waters
 * Date: 20 Oct 2020
 * Description: The HourlyEmployee class provides an implementation of the Employee abstract class and represents an employee who is 
 * 	paid by the hour. Also provides overridden earnings and string methods. 
 */

package Employee;

public class HourlyEmployee extends Employee { // Class extends abstract class Employee
	private double wage; // Wage per hour
	private double hours; // Hours worked for week
	
	// Class constructor
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber, birthDate);
		
		if (wage < 0.0) { // Validates wage input when creating new HourlyEmployee object
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}
		
		if((hours < 0.0) || (hours > 168.0)) { // Validates hours input when creating new HourlyEmployee object
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}
		
		this.wage = wage;
		this.hours = hours;
	}
	
	// Set wage
	public void setWage(double wage) {
		if(wage < 0.0) {
			throw new IllegalArgumentException("Hourly wage must be >= 0.0"); // Validates wage input when creating new HourlyEmployee object
		}
		this.wage = wage;
	}
	
	// Return wage
	public double getWage() {
		return wage;
	}
	
	// Set hours worked
	public void setHours(double hours) {
		if((hours < 0.0) || (hours > 168.0)) {
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0"); // Validates hours input when creating new HourlyEmployee object
			}
		this.hours = hours;
	}
	
	// Return hours worked
	public double getHours() {
		return hours;
	}
	
	// Calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings() {
		if(getHours() <= 40) { // No overtime worked
			return getWage() * getHours();
		}
		
		else {
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5; // Worked more than 40 hours
		}
	}
	
	// Return String representation of HourlyEmployee object
	@Override
	public String toString() {
		return String.format("Hourly employee: %s%n%s: $%,.2f%n%s: %,.2f", super.toString(), "Hourly wage", getWage(), "Hours worked", getHours());
	}
}
