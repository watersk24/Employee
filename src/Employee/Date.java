/* Author: Kevin Waters
 * Date: 20 Oct 2020
 * Description: The Date class creates a Date object for use in the abstract class Employee to represent an employees birth date.
 */

package Employee;

public class Date {
	private int month; // 1-12
	private int day; // 1-31 based on month
	private int year; // Any year
	
	private static final int[] daysPerMonth =
		{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	// Class constructor
	public Date(int month, int day, int year) {
		// Validates month input
		if (month <= 0 || month > 12) {
			throw new IllegalArgumentException("month ("+ month +") must be 1-12.");
		}
		
		// Validating day input
		if (day <= 0 ||
				(day > daysPerMonth[month] && !(month == 2 && day == 29))) {
			throw new IllegalArgumentException("day ("+ day +") out of range for specified month and year.");
		}
		
		// Checking if it is a leap year
		if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
			throw new IllegalArgumentException("day ("+ day +") out of range for specified month and year.");
		}
		
		this.month = month;
		this.day = day;
		this.year = year;
		
		//System.out.printf("Date object constructor for date %s%n", this);
	}
	
	// Get method for day
	public int getDay() {
		return day;
	}

	// Get method for month
	public int getMonth() {
		return month;
	}
	
	// Get method for year
	public int getYear() {
		return year;
	}
	
	public String toString() {
		return String.format("%d/%d/%d", getMonth(), getDay(), getYear());
	}
}
