package mngmnt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "FEEDBACK")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column(nullable = false, unique = false, length = 30)
	private String feedbackContent;
	@Column(nullable = true, unique = false, length = 30)
	private Date feedbackDate;
	public Feedback()
	{
		feedbackDate = new Date();
	}
}
