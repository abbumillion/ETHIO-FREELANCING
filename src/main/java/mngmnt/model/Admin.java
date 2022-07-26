package mngmnt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
	//user's id for primary key
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	private int level;
	@OneToOne
	private User user;
}
