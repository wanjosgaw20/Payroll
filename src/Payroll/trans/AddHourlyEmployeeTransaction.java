package Payroll.trans;

import Payroll.PaymentClassification;
import Payroll.Transaction;
import Payroll.classification.HourlyClassification;

public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction implements Transaction {

	private double hourlyRate;

	public  AddHourlyEmployeeTransaction(int empId, String name, String address, double hourlyRate) {
		this.empId = empId;
		this.name =name;
		this.address = address;
		this.hourlyRate =hourlyRate;
	}

	@Override
	protected PaymentClassification getPaymentClassification() {
		return new HourlyClassification(hourlyRate);
	}

}
