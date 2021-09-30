/*-------------------------------------------------------------------------
// AUTHOR: Augustus Crosby
// FILENAME: Assignment6.java
// SPECIFICATION:  This program allows the user to create employees' objects and performs operations for each employee.
// YOUR Lab: E  
// FOR: CSE 110- homework 6- 3:00 MWF
// TIME SPENT: 2.5 hours
//----------------------------------------------------------------------*/

/*1. The problem is that "str" is nothing (from being null). Printing out nothing I don't think is a problem, but when the 
 * it tries to call on str.length() I believe that's where the problem is because you can't count the length of nothing. 
 * "nullException in thread "main" 
java.lang.NullPointerException
	at Assignment6.main(Assignment6.java:20)"
  2. Instance data being public instead of private could make it so the encapsulation of the method doesn't properly work anymore. 
  This could maybe cause problems if a variable is named the same in a method and in the main method.
 */
import java.text.DecimalFormat;

public class Employee {
	private String name = "";
	private double salary = 0.0;
	private int yearsOfExperience = 0;
	private static int numberOfEmployees = 0;
	
	public Employee() {
		this.name = "???";
		this.salary = 0.0;
		this.yearsOfExperience = 0;
	}
	public Employee (String name, double salary, int years) {
		this.name = name;
		this.salary = salary;
		this.yearsOfExperience = years;
		numberOfEmployees++;
	}
	public Employee (String str) {
		String[] e = str.split(":");
		this.name = e[0];
		this.salary = Double.parseDouble(e[1]);
		this.yearsOfExperience = Integer.parseInt(e[2]);
		numberOfEmployees++;
	}
	public String getName( ) {
		return this.name;
	}
	public double getSalary( ) {
		return this.salary;
	}
	public int getYears() {
		return this.yearsOfExperience;
	}
	public String setName(String name) {
		this.name = name;
		return this.name;
	}
	public void addOneYear() {
		this.yearsOfExperience++;
	}
	public void addYears(int numYears) {
		this.yearsOfExperience += numYears;
	}
	public void raiseSalary(double byPercent) {
		this.salary *= (1 + byPercent/100);
	}
	public Employee moreExperience(Employee e) {
		if(yearsOfExperience >= e.yearsOfExperience) {
			return this;
		} else {
			return e;
		}
	}
	public static int getNumEmployees() {
		return numberOfEmployees;
	}
	public String toString( ) {
		DecimalFormat df = new DecimalFormat("0.00");
		return "\nName: " + name + "\n"
				+ "Salary: $" + df.format(salary) + "\n"
				+ "Years of Experience: " + yearsOfExperience;
	}
	
	
	
}