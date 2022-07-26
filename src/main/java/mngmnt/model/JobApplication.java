package mngmnt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column(nullable = false, unique = false, length = 20)
	private Date applicationDate;
	@Column(nullable = true, unique = false, length = 10)
	private Boolean accepted;
	@Column(nullable = true, unique = false, length = 100)
	private String  coverLetter;
	@ManyToOne
	private Job job;

}
