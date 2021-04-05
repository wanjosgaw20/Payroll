package Payroll.trans;

import Payroll.PaymentClassification;
import Payroll.Transaction;
import Payroll.classification.SalariedClassification;

public class AddSalariedEmployeeTransaction extends AddEmployeeTransaction implements Transaction {
	
	private double salary;

	public AddSalariedEmployeeTransaction(int empId, String name, String address, double salary) {
		
		super(empId, name, address);
			this.salary = salary;
	}

	protected PaymentClassification getPaymentClassification() {
		return new SalariedClassification(salary);
	}

}
