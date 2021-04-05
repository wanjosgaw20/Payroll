package Payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import Payroll.Employee;
import Payroll.PaymentClassification;
import Payroll.PayrollDatabase;
import Payroll.Transaction;
import Payroll.trans.AddHourlyEmployeeTransaction;

//用例3  登记时间卡。
//执行TimeCard操作时，系统会创建一条时间卡记录，并把该记录和对应的雇员记录关联起来。
//TimeCard EmpId date hours
//异常情况1：所选择的雇员不是钟点雇员。
//系统会打印一条错误信息，并且不进行进一步的处理。
//异常情况2：描述操作的结构中有错误。
//系统会打印一条错误信息，不进行进一步的处理。

public class TimeCardTest{

	//登记时间卡（一个时间卡，钟点工）
	//TimeCard EmpId date hours
	@Test
	public void testOneTimeCardToHourlyEmployee(){
		//添加一个钟点工，然后给钟点工登记一个时间卡
		int empId = 3001;
		new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 12.5)
				.execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));
		// 添加时间卡
		String date = "2013-06-01"; // 用字符串简化日期表示
		double hours = 8;
		
		Transaction t = new TimeCardTransaction(empId, date, hours);
		t.execute();
		
		// 验证时间卡
				Employee employee = PayrollDatabase.getEmployee(empId);
				PaymentClassification pc = employee.getPaymentClassification();
				assertTrue(pc instanceof HourlyClassification); // 应为钟点工
				HourlyClassification hc = (HourlyClassification) pc;
				TimeCard tc = hc.getTimeCardOfDate(date); // 取出当日时间卡
				assertNotNull(tc);  // 时间卡非空
				assertEquals(date, tc.getDate()); // 日期正确
				assertEquals(hours, tc.getHours(), 0.01); // 工作小时数正确
	}
	
	//登记时间卡（两个时间卡，钟点工）
	@Test
	public void testTwoTImeCardToHourlyEmployee(){
	}
	
	//登记时间卡（一个时间卡，月薪雇员，抛出异常）
	@Test
	public void testTimeCardToSalariedEmployee(){
	}
	//登记时间卡（一个时间卡，月薪加提成雇员，抛出异常）
	@Test
	public void testTimeCardToCommissionedEmployee(){
	}
	
	//登记时间卡（一个时间卡，不存在的雇员，抛出异常）
	@Test
	public void testTimeCardToNosuchEmployee(){
	}
	
}

