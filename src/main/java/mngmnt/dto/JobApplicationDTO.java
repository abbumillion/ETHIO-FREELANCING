package mngmnt.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mngmnt.model.Job;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobApplicationDTO {
	private Long jobId;
	private String coverLetter;
	private Long freelancerId;
	private Job job;
	private Date applicationDate;
}
