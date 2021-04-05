package Payroll;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {
	private static Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	public static Employee getEmployee(int empId) {
		
		return employees.get(empId);
	}
	public static void save(Employee employee) {
		employees.put(employee.getEmpId(), employee);
	}
	public static void deleteEmployee(int empId) {
		employees.remove(empId);
		
	}

}
