package Payroll.trans;

import Payroll.PaymentClassification;
import Payroll.Transaction;
import Payroll.classification.SalariedClassification;

public class AddSalariedEmployeeTransaction extends AddEmployeeTransaction implements Transaction {
	
	private double salary;

	public AddSalariedEmployeeTransaction(int empId, String name, String address, double salary) {
		
			this.empId = empId;
			this.name = name;
			this.address = address;
			this.salary = salary;
	}

	protected PaymentClassification getPaymenClassification() {
		return new SalariedClassification(salary);
	}

	protected PaymentClassification getPaymentClassification() {
		return null;
	}

}
