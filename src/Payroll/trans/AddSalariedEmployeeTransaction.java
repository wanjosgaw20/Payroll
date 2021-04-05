package Payroll.trans;

import Payroll.Transaction;

public class AddSalariedEmployeeTransaction implements Transaction {
	
	private int empId;
	private String name;
	private String address;
	private double salary;

	public AddSalariedEmployeeTransaction(int empId, String name, String address, double salary) {
		
			this.empId = empId;
			this.name = name;
			this.address = address;
			this.salary = salary;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
