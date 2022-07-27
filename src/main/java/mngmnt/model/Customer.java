package mngmnt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {
	/**************************************************************************************
	 * Description : This is a customer bean.
	 * Created Date: 22 jun, 2022
	 * Version     : v1.0.0
	 * Author      : Million Sharbe
	 *************************************************************************************/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@OneToMany
	private List<Job> job;
	@OneToOne
	private User user;
	@OneToMany
	private List<Feedback> feedback;
}
