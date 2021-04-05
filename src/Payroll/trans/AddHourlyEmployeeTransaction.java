package Payroll.trans;

import Payroll.Employee;
import Payroll.PaymentClassification;
import Payroll.PayrollDatabase;
import Payroll.Transaction;
import Payroll.classification.HourlyClassification;
import Payroll.method.HoldMethod;

public class AddHourlyEmployeeTransaction implements Transaction {

	private int empId;
	private String name;
	private String address;
	private double hourlyRate;

	public  AddHourlyEmployeeTransaction(int empId, String name, String address, double hourlyRate) {
		this.empId = empId;
		this.name =name;
		this.address = address;
		this.hourlyRate =hourlyRate;
	}

	@Override
	public void execute() {
		//�½���Ա
		Employee employee = new Employee(empId, name, address);
		//���ù��ʼ��㷽ʽ
		employee.setPaymentClassification(getPaymentClassification());
		//���ù���֧������
		employee.setPaymentMethod(new HoldMethod());
		//���浽���ݿ�
		PayrollDatabase.save(employee);
	}

	protected PaymentClassification getPaymentClassification() {
		return new HourlyClassification(hourlyRate);
	}

}
