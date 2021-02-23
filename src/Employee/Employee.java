/* Author: Kevin Waters
 * Date: 20 Oct 2020
 * Description: The Employee abstract class provides a framework for constructing other classes of Employee that share common attributes.
 * 	A class constructor is provided to initialize the common attributes as well as an abstract earnings method for subclasses to define. 
 * 	Finally, the String method has been overridden to represent Employee objects as strings.
 */


package Employee;

public abstract class Employee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private final Date birthDate;
	
	// Class constructor
	public Employee(String firstName, String lastName, String socialSecurityNumber, Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthDate = birthDate;
	}
	
	// Return first name
	public String getFirstName() {
		return firstName;
				}
	// Return last name
	public String getLastName() {
		return lastName;
	}
	
	// Return social security number
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	// Return birth date
	public Date getBirthDate() {
		return birthDate;
	}
	
	// Overrides String method to represent Employee object as a string
	@Override
	public String toString() {
		return String.format("%s %s%nSocial Security Number: %s%nBirth date: %s", getFirstName(), getLastName(), getSocialSecurityNumber(), getBirthDate());
	}
	
	// Abstract method that is used in subclasses of Employee
	public abstract double earnings();
}
