package Payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import Payroll.Employee;
import Payroll.PaymentClassification;
import Payroll.PayrollDatabase;
import Payroll.Transaction;
import Payroll.trans.AddHourlyEmployeeTransaction;

//����3  �Ǽ�ʱ�俨��
//ִ��TimeCard����ʱ��ϵͳ�ᴴ��һ��ʱ�俨��¼�����Ѹü�¼�Ͷ�Ӧ�Ĺ�Ա��¼����������
//TimeCard EmpId date hours
//�쳣���1����ѡ��Ĺ�Ա�����ӵ��Ա��
//ϵͳ���ӡһ��������Ϣ�����Ҳ����н�һ���Ĵ���
//�쳣���2�����������Ľṹ���д���
//ϵͳ���ӡһ��������Ϣ�������н�һ���Ĵ���

public class TimeCardTest{

	//�Ǽ�ʱ�俨��һ��ʱ�俨���ӵ㹤��
	//TimeCard EmpId date hours
	@Test
	public void testOneTimeCardToHourlyEmployee(){
		//���һ���ӵ㹤��Ȼ����ӵ㹤�Ǽ�һ��ʱ�俨
		int empId = 3001;
		new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 12.5)
				.execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));
		// ���ʱ�俨
		String date = "2013-06-01"; // ���ַ��������ڱ�ʾ
		double hours = 8;
		
		Transaction t = new TimeCardTransaction(empId, date, hours);
		t.execute();
		
		// ��֤ʱ�俨
				Employee employee = PayrollDatabase.getEmployee(empId);
				PaymentClassification pc = employee.getPaymentClassification();
				assertTrue(pc instanceof HourlyClassification); // ӦΪ�ӵ㹤
				HourlyClassification hc = (HourlyClassification) pc;
				TimeCard tc = hc.getTimeCardOfDate(date); // ȡ������ʱ�俨
				assertNotNull(tc);  // ʱ�俨�ǿ�
				assertEquals(date, tc.getDate()); // ������ȷ
				assertEquals(hours, tc.getHours(), 0.01); // ����Сʱ����ȷ
	}
	
	//�Ǽ�ʱ�俨������ʱ�俨���ӵ㹤��
	@Test
	public void testTwoTImeCardToHourlyEmployee(){
	}
	
	//�Ǽ�ʱ�俨��һ��ʱ�俨����н��Ա���׳��쳣��
	@Test
	public void testTimeCardToSalariedEmployee(){
	}
	//�Ǽ�ʱ�俨��һ��ʱ�俨����н����ɹ�Ա���׳��쳣��
	@Test
	public void testTimeCardToCommissionedEmployee(){
	}
	
	//�Ǽ�ʱ�俨��һ��ʱ�俨�������ڵĹ�Ա���׳��쳣��
	@Test
	public void testTimeCardToNosuchEmployee(){
	}
	
}

