package Payroll.trans;

import Payroll.Employee;
import Payroll.PayrollDatabase;
import Payroll.Transaction;
import Payroll.classification.SalariedClassification;
import Payroll.method.HoldMethod;

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
		//�½���Ա
		Employee employee = new Employee(empId,name,address);
		//���ù��ʼ��㷽ʽ
		employee.setPaymentClassification(getPaymenClassification());
		//���ù���֧������
		employee.setPaymentMethod(new HoldMethod());
		//���浽���ݿ�
		PayrollDatabase.save(employee);

	}

	protected SalariedClassification getPaymenClassification() {
		return new SalariedClassification(salary);
	}

}
