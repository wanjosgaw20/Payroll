package Payroll.trans;

import Payroll.Employee;
import Payroll.Transaction;
import Payroll.classification.SalariedClassification;

public class AddSalariedEmployeeTransaction implements Transaction {
	
	private int empId;
	private String name;
	private String address;
	private double salary;

	public AddSalariedEmployeeTransaction(int empId, String name, String address, double salary) {
		
			this.empId = empId;
			this.name = name;
			this.address = address;
			this.salary = salary;
	}

	@Override
	public void execute() {
		//新建雇员
		Employee employee = new Employee(empId,name,address);
		//设置工资计算方式
		employee.setPaymentClassification(new SalariedClassification(salary));
		//设置工资支付方法
		//保存到数据库

	}

}
