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
		//�½���Ա
		Employee employee = new Employee(empId,name,address);
		//���ù��ʼ��㷽ʽ
		employee.setPaymentClassification(new SalariedClassification(salary));
		//���ù���֧������
		//���浽���ݿ�

	}

}
