package Payroll.trans;

import Payroll.Transaction;

public class DeleteEmployeeTransaction implements Transaction {

	private int empId;

	public DeleteEmployeeTransaction(int empId) {
		this.empId = empId;
	}

	@Override
	public void execute() {
		

	}

}
