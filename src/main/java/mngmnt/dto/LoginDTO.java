package mngmnt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
	/**
	 * this a login data transfer object
	 * transfer data from the view to spring security
	 * used for authentication
	 */
	private String email;
	private String password;
}
