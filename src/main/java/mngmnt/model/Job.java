package mngmnt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long jobId;
	@Column(nullable = false, unique = false, length = 10)
	private int vacancy;
	@Column(nullable = false, unique = false, length = 20)
	private String experience;
	@Column(nullable = false, unique = false, length = 100)
	private String description;
	@Column(nullable = false, unique = false, length = 30)
	private String title;
	@Column(nullable = false, unique = false, length = 20)
	private String type;
	@Column(nullable = false, unique = false, length = 20)
	private String category;
	@Column(nullable = false, unique = false, length = 20)
	private Date posted;
	@Column(nullable = false, unique = false, length = 20)
	private Date endDate;
	@Column(nullable = false, unique = false, length = 20)
	private double budget;
	@OneToMany
	private List<Skill> skill;
	@OneToMany
	private List<JobApplication> jobApplication;
	@OneToOne
	private Customer customer;
}
