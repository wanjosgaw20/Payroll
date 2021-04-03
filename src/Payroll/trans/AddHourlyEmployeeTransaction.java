package Payroll.trans;

import Payroll.Transaction;

public class AddHourlyEmployeeTransaction implements Transaction {

	private int empId;
	private String name;
	private String address;
	private double hourlyRate;

	public AddHourlyEmployeeTransaction(int empId, String name, String address, double hourlyRate) {
		this.empId = empId;
		// TODO Auto-generated constructor stub
		this.name = name;
		this.address = address;
		this.hourlyRate = hourlyRate;
	}

}
