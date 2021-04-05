package Payroll.exception;

public class NosuchEmployeeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NosuchEmployeeException(String message){
		super(message);
	}
}
