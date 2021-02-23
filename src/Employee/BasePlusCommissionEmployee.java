/* Author: Kevin Waters
 * Date: 20 Oct 2020
 * Description: The BasePlusCommissionEmployee class provides an implementation of the Employee abstract class and represents an employee who is 
 * 	paid a base salary plus a commission on sales. Also provides overridden earnings and string methods. 
 */

package Employee;

public class BasePlusCommissionEmployee extends CommissionEmployee { // Extends abstract Employee class
	private double baseSalary; // Base salary per week
	
	// Class constructor
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, 
			Date birthDate, double grossSales, double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, birthDate, grossSales, commissionRate);
		
		if(baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0"); // Validates base salary input
		}
		this.baseSalary = baseSalary;
	}
	
	// Set base salary
	public void setBaseSalary(double baseSalary) {
		if(baseSalary < 0.0) { 
			throw new IllegalArgumentException("Base salary must be >= 0.0"); // Validates base salary
		}
		this.baseSalary = baseSalary;
		
	}
	// Return base salary
	public double getBaseSalary() {
		return baseSalary;
	}
	
	//Calculate earnings; override method earnings in CommissionEmployee
	@Override
	public double earnings() {
		return getBaseSalary() + super.earnings();
	}
	
	// Return String representation of BasePlusCommissionEmployee object
	@Override
	public String toString() {
		return String.format("%s %s%n%s: $%,.2f", "Base-salaried", super.toString(), "Base salary", getBaseSalary());
	}
}
