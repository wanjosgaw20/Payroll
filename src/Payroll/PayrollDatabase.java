package Payroll;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {
	private static Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	public static Employee getEmployee(int empId) {
		
		return employees.get(empId);
	}

}
