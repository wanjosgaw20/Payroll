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
		//新建雇员
		Employee employee = new Employee(empId, name, address);
		//设置工资计算方式
		employee.setPaymentClassification(getPaymentClassification());
		//设置工资支付方法
		employee.setPaymentMethod(new HoldMethod());
		//保存到数据库
		PayrollDatabase.save(employee);
	}

	protected PaymentClassification getPaymentClassification() {
		return new HourlyClassification(hourlyRate);
	}

}
