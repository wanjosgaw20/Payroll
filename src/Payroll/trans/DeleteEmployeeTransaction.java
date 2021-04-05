package Payroll.trans;

import Payroll.Employee;
import Payroll.PayrollDatabase;
import Payroll.Transaction;

public class DeleteEmployeeTransaction implements Transaction {

	private int empId;

	public DeleteEmployeeTransaction(int empId) {
		this.empId = empId;
	}

	@Override
	public void execute() {
		//���������ݿ����ҵ��ù�Ա
		Employee employee = PayrollDatabase.getEmployee(empId);
		//���ҵ���ɾ��
		if(employee!=null){
			PayrollDatabase.deleteEmployee(empId);
		}else{
		//�����׳��쳣����Ա�����ڣ�
			throw new NosuchEmployeeException("No such employee empId ="+empId);
		}
	}
}
