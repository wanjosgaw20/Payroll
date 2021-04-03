package Payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import Payroll.Employee;
import Payroll.PaymentClassification;
import Payroll.PayrollDatabase;
import Payroll.Transaction;
import Payroll.classification.HourlyClassification;
import Payroll.trans.AddHourlyEmployeeTransaction;

public class AddEmployeeTest {

	//���Сʱ���ʹ�Ա
	//AddEmp EmpId "name"	"address'	H hourly-rate
	@Test
	public void testAddhourlyEmployeeTransaction() {
		int empId =1001;
		String name ="Bill";
		String address ="Home";
		double hourlyRate =12.5;
		//�½�����ӵ㹤��������ִ��
		Transaction t= new AddHourlyEmployeeTransaction(empId,name,address,hourlyRate);
		t.execute();
		//��ִ֤�н��
		Employee e = PayrollDatabase.getEmployee(empId);//���ݹ�Ա��Ŷ�ȡ��Ա��¼
		assertNotNull(e);//��Ա��¼����
		assertEquals(empId,e.getEmpId());//�����ȷ
		assertEquals(name,e.getName());//������ȷ
		assertEquals(address,e.getAddress());//��ַ��ȷ
		PaymentClassification pc = e.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification);//�ӵ㹤
		HourlyClassification hc = (HourlyClassification) pc;
		asserEquals(hourlyRate,hc.getHourlyRate(),0.01);//Сʱ������ȷ
		PaymentMethod pm =e.getPaymentMethod();
		assertTure(pm instanceof HoldMethod);//֧����ʽĬ��Ϊ����֧Ʊ
	}

}
