package Payroll.trans;

import Payroll.PaymentClassification;
import Payroll.classification.CommissionedClassification;

public class AddCommissionedEmployeeTransaction extends AddEmployeeTransaction {

	private double salary;
	private double commissionRate;

	public AddCommissionedEmployeeTransaction(int empId, String name, String address, double salary,
			double commissionRate) {
		super(empId, name, address);
		this.salary = salary;
		this.commissionRate = commissionRate;
	}

	@Override
	protected PaymentClassification getPaymentClassification() {
		// TODO Auto-generated method stub
		return new CommissionedClassification(salary,commissionRate);
	}

}
