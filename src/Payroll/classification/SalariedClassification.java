package Payroll.classification;

import Payroll.PaymentClassification;

public class SalariedClassification extends PaymentClassification {

	private double salary;

	public SalariedClassification(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

}
