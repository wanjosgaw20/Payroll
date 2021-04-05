package Payroll.classification;

import Payroll.PaymentClassification;
import Payroll.TimeCard;

public class HourlyClassification extends PaymentClassification{

	private double hourlyRate;

	public HourlyClassification(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}


	public double getHourlyRate() {
		return hourlyRate;
	}


	public TimeCard getTimeCardOfDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

}
