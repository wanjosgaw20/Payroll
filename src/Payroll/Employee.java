package Payroll;

public class Employee {
	private int empId;
	private String name;
	private String address;
	private PaymentClassification PaymentClassification;
	private PaymentMethod paymentMethod;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Employee(int empId, String name, String address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	public PaymentClassification getPaymentClassification() {
		return PaymentClassification;
	}
	public void setPaymentClassification(PaymentClassification paymentClassification) {
		PaymentClassification = paymentClassification;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
