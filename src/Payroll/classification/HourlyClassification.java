package Payroll.classification;

import Payroll.PaymentClassification;

public class HourlyClassification extends PaymentClassification{

	private double hourlyRate;

	public HourlyClassification(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}


	public double getHourlyRate() {
		return hourlyRate;
	}

}
