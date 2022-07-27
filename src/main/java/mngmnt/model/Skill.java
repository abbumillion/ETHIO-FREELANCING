package mngmnt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mngmnt.helpers.SkillCategory;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column(nullable = false, unique = false, length = 30)
	private String skillName;
	@Column(nullable = false, unique = false, length = 100)
	private String skillDescription;
	@Column(nullable = false, unique = false, length = 30)
	private SkillCategory skillCategory;
}
