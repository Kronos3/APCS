/**
 * @author Andrei Tumbar
 * Tests the Employee class
 */
public class EmployeeTester {
	public static void main(String[] args) {
		Employee harry = new Employee("Hacker, Harry", 50000);
		System.out.println(harry);
		
		harry.raiseSalary(10.5);
		System.out.println(harry);
	}
}
