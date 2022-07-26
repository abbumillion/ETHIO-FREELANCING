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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@OneToMany
	private List<Job> job;
	@OneToOne
	private User user;
	@OneToMany
	private List<Feedback> feedback;
	@Column(nullable = true, unique = false, length = 2)
	private int rating;
}
