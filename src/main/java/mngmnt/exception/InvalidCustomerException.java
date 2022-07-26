package mngmnt.exception;

/**************************************************************************************
 * Description : Invalid Recruiter Exception class.
 * Created Date: 22 April, 2021 
 * Version     : v1.0.0
 *************************************************************************************/
public class InvalidCustomerException extends RuntimeException {
	
	private static final long serialVersionUID = -1319886001655231121L;

	public InvalidCustomerException() {
		super();
	}

	public InvalidCustomerException(String msg) {
		super(msg);
	}
}
