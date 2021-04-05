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
		//首先在数据库中找到该雇员
		Employee employee = PayrollDatabase.getEmployee(empId);
		//若找到则删除
		if(employee!=null){
			PayrollDatabase.deleteEmployee(empId);
		}else{
		//否则，抛出异常（雇员不存在）
			throw new NosuchEmployeeException("No such employee empId ="+empId);
		}
	}
}
