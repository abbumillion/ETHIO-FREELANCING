package mngmnt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mngmnt.model.Skill;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDTO {

	private int vacancy;
	private String experience;
	private String description;
	private String title;
	private String type;
	private String category;
	private Date posted;
	private Date endDate;
	private double budget;
	private List<Skill> skill;
	private CustomerDTO customerDTO;

}