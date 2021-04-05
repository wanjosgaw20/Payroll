package Payroll.trans;

import Payroll.Employee;
import Payroll.PaymentClassification;
import Payroll.PayrollDatabase;
import Payroll.Transaction;
import Payroll.classification.HourlyClassification;
import Payroll.method.HoldMethod;

public abstract class AddEmployeeTransaction implements Transaction{

	public AddEmployeeTransaction(int empId, String name, String address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	protected int empId;

	protected abstract PaymentClassification getPaymentClassification();

	protected String name;
	protected String address;

	public AddEmployeeTransaction() {
		super();
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

}