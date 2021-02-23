/* Author: Kevin Waters
 * Date: 20 Oct 2020
 * Description: PayrollSystemTest class tests the abstract Employee class and the implementation of all of its subclasses. This class uses 
 * 	polymorphism to to process each classes earnings method.
 */

package Employee;
import java.time.LocalDate;
import java.time.Month;

public class PayrollSystemTest {
	public static void main(String[] args) {
		// Create subclass objects
		SalariedEmployee salariedEmployee = 
				new SalariedEmployee("John", "Smith", "111-11-1111", new Date(4, 13, 1980), 800.00);
		HourlyEmployee hourlyEmployee = 
				new HourlyEmployee ("Karen", "Price", "222-22-2222", new Date(5, 22, 1958), 16.75, 40);
		CommissionEmployee commissionEmployee = 
				new CommissionEmployee ("Sue", "Jones", "333-33-3333", new Date(7, 24, 1995), 10000, .06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = 
				// Month 10 used to test the birthday bonus paid to employees whose birthday falls in the current month
				new BasePlusCommissionEmployee ("Bob", "Lewis", "444-44-4444", new Date(10, 2, 1990),  5000, .04, 300); 
				
		// Create a 4 element employee array
		Employee[] employees = new Employee[4];
		
		// Initialize array with employees
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;
				
		// Process each element in array employees
		for (Employee currentEmployee : employees) {
			System.out.println(currentEmployee);
			
			// Determine whether element is a BasePlusCommissionEmployee
			if (currentEmployee instanceof BasePlusCommissionEmployee) {
				// Downcast Employee reference to 
				// BasePlusCommissionEMployee
				BasePlusCommissionEmployee employee =
						(BasePlusCommissionEmployee) currentEmployee;
				
				employee.setBaseSalary(1.10 * employee.getBaseSalary());
				
				System.out.printf("New base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
			}
			
			System.out.printf("Earned $%,.2f%n%n", currentEmployee.earnings());
		
		LocalDate currentDate = LocalDate.now(); // Using LocalDate class to determine date
		Month currentMonth = currentDate.getMonth(); // Using Month class to create currentMonth variable to compare with employee birth month
		
		// Determine whether it is the employees birth month, if it is add $100 birthday bonus to their earnings for the month
		if (currentEmployee.getBirthDate().getMonth() == currentMonth.getValue()) {
			double bonus = 100;
				
			System.out.printf("Happy birthday %s, you get a $%,.2f bonus.%n", currentEmployee.getFirstName(), bonus);
			System.out.printf("New pay with birthday bonus: $%,.2f%n%n", currentEmployee.earnings() + bonus);
			}
		}
	}
}
