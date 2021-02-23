/* Author: Kevin Waters
 * Date: 20 Oct 2020
 * Description: The CommissionEmployee class provides an implementation of the Employee abstract class and represents an employee who is 
 * 	paid commission only. Also provides overridden earnings and string methods. 
 */

package Employee;

public class CommissionEmployee extends Employee { // Class extends the abstract Employee class
	private double grossSales; // Gross weekly sales
	private double commissionRate; // Commission percentage
	
	// Class constructor
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double grossSales, double commissionRate) {
		super(firstName, lastName, socialSecurityNumber, birthDate);
		
		if (commissionRate <= 0.0 || commissionRate >= 1.0) { // Validates commission rate input
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		
		if (grossSales < 0.0) { // Validates gross sales input
			throw new IllegalArgumentException("Gross sales must be > 0.0");
		}
		
		this.commissionRate = commissionRate;
		this.grossSales = grossSales;
	}
	
	// Set gross sales amount
	public void setGrossSales(double grossSales) {
		if(grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0"); // Validates gross sales input
		}
		
		this.grossSales = grossSales;
	}
	
	// Return gross sales amount
	public double getGrossSales() {
		return grossSales;
	}
	
	// Set commission rate
	public void setCommissionRate(double commissionRate) {
		if(commissionRate <= 0.0 || commissionRate > 1.0) {
			throw new IllegalArgumentException("Commission rate must be >= 0.0 and <= 1.0"); // Validates commission rate input
			}
		this.commissionRate = commissionRate;	
		}
	
	// Return commission rate
	public double getCommissionRate() {
		return commissionRate;
	}
	
	// Calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	}
	
	// Return String representation of CommisionEmployee object
	@Override
	public String toString() {
		return String.format("%s: %s%n%s: $%,.2f%n%s: %.2f", "Commission employee", super.toString(), "Gross sales", getGrossSales(), "Commission rate", getCommissionRate());
	}
}
