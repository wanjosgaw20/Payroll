package Payroll.trans;

import Payroll.Employee;
import Payroll.PaymentClassification;
import Payroll.PayrollDatabase;
import Payroll.Transaction;
import Payroll.classification.HourlyClassification;
import Payroll.method.HoldMethod;

public abstract class AddEmployeeTransaction implements Transaction {

	private int empId;

	protected abstract PaymentClassification getPaymentClassification();

	public AddEmployeeTransaction(int empId, String name, String address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	private String name;
	private String address;

	public AddEmployeeTransaction() {
		super();
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

}