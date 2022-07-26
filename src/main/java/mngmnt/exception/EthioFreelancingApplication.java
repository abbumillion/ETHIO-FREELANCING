package mngmnt.exception;

import java.util.ArrayList;
import java.util.List;

/**************************************************************************************
 * Author Million Sharbe
 * Description : Bookmarked Freelancer Validation class.
 * Created Date: 22 jun, 2022
 * Version     : v1.0.0
 *************************************************************************************/
public class EthioFreelancingApplication extends RuntimeException {

	private static final long serialVersionUID = -5970913799468930325L;
	List<String> messages = new ArrayList<>();

	public EthioFreelancingApplication() {
		super();
	}

	public EthioFreelancingApplication(List<String> messages) {
		super();
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

}
