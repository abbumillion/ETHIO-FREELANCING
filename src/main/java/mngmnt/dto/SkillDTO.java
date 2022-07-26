package mngmnt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mngmnt.helpers.SkillCategory;

/**************************************************************************************
 * Author thomas
 * Description : This is the DTO class for Skill module.
 * Created Date: 21 April, 2021 
 * Version     : v1.0.0
 *************************************************************************************/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkillDTO {
	private String name;
	private String description;
	private SkillCategory category;
}
