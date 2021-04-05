package Payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import Payroll.Employee;
import Payroll.PaymentClassification;
import Payroll.PaymentMethod;
import Payroll.PayrollDatabase;
import Payroll.Transaction;
import Payroll.classification.HourlyClassification;
import Payroll.classification.SalariedClassification;
import Payroll.method.HoldMethod;
import Payroll.trans.AddHourlyEmployeeTransaction;
import Payroll.trans.AddSalariedEmployeeTransaction;

public class AddEmployeeTest {

	//添加小时工资雇员
	//AddEmp EmpId "name"	"address'	H hourly-rate
	@Test
	public void testAddhourlyEmployeeTransaction() {
		int empId =1001;
		String name ="Bill";
		String address ="Home";
		double hourlyRate =12.5;
		//新建添加钟点工操作，并执行
		Transaction t= new AddHourlyEmployeeTransaction(empId,name,address,hourlyRate);
		t.execute();
		//验证执行结果
		Employee e = PayrollDatabase.getEmployee(empId);//根据雇员编号读取雇员记录
		assertNotNull(e);//雇员记录存在
		assertEquals(empId,e.getEmpId());//编号正确
		assertEquals(name,e.getName());//名字正确
		assertEquals(address,e.getAddress());//地址正确
		PaymentClassification pc = e.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification);//钟点工
		HourlyClassification hc = (HourlyClassification) pc;
		assertEquals(hourlyRate,hc.getHourlyRate(),0.01);//小时工资正确
		PaymentMethod pm =e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);//支付方式默认为保存支票
	}
	//添加月薪雇员
		//AddEmp EmpId “name" “address” S monthly-salary
		@Test
		public void testAddSalariedEmployee() {
			int empId = 1002;
			String name = "Bill";
			String address = "Home";
			double salary = 2410.0;
			
			Transaction t = new AddSalariedEmployeeTransaction(empId,name,address,salary);
			t.execute();
			
			Employee e = PayrollDatabase.getEmployee(empId);
			assertNotNull(e);
			assertEquals(name, e.getName());
			assertEquals(address, e.getAddress());
			PaymentClassification pc = e.getPaymentClassification();
			assertTrue(pc instanceof SalariedClassification); // 月薪方式
			SalariedClassification sc = (SalariedClassification) pc;
			assertEquals(salary, sc.getSalary(), 0.01); // 月薪正确
			PaymentMethod pm = e.getPaymentMethod();
			assertTrue(pm instanceof HoldMethod);
		
	
	}
}
