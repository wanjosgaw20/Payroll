package Payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import Payroll.Employee;
import Payroll.PayrollDatabase;
import Payroll.Transaction;
import Payroll.trans.AddHourlyEmployeeTransaction;
import Payroll.trans.DeleteEmployeeTransaction;

//����2  ɾ����Ա��
//ʹ��DelEmp������ɾ����Ա��������ʽ��
//DelEmp EmpId
//��ִ�иò���ʱ����ɾ����Ӧ�Ĺ�Ա��¼��
//�쳣���1����Ч����δ֪��EmpId��
//���EmpId�ֶβ�������ȷ�Ľṹ��������û�����õ�һ����Ч�Ĺ�Ա��¼�����ӡһ������
//��Ϣ����������������

public class DeleteEmployeeTest {

	//ɾ����Ա���Ѵ��ڵģ�
	//DelEmp EmpId
	@Test
	public void testDeleteEmployeeExisted() {
		// �Ȳ���һ����Ա����ɾ��֮
		int empId = 2001;
		new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 12.5)
			.execute();
	// ɾ����Ա
		Transaction t = new DeleteEmployeeTransaction(empId);
		t.execute();
		
		// ��֤��Ա��ɾ��
		Employee e = PayrollDatabase.getEmployee(empId);
		assertNull(e); // ��Ա��ɾ��
	}
	//ɾ����Ա�������ڵģ�
		//DelEmp EmpId
		@Test
		public void testDeleteEmployeeNotExisted() {
			int empId = 2002; // �����ڵĹ�Ա���
			Employee employee = PayrollDatabase.getEmployee(empId);
			assertNull(employee); // ���ݿ��в����ڸù�Ա
			// ɾ����Ա
			Transaction t = new DeleteEmployeeTransaction(empId);
			t.execute();
		}

}