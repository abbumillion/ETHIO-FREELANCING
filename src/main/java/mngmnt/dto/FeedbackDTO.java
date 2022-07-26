package mngmnt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mngmnt.model.User;

import java.util.Date;

/**************************************************************************************
 * @author       yordanos
 * Description : This is the DTO class for Feedback module. 
 * Created Date: 21 April, 2021 
 * Version     : v1.0.0
 *************************************************************************************/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedbackDTO {
	private String comments;
	private Date date;
}
