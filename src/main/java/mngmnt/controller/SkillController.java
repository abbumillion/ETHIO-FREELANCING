package mngmnt.controller;

import mngmnt.ServiceImp.SkillServiceImp;
import mngmnt.dto.SkillDTO;
import mngmnt.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SkillController {

	/**
	 *
	 */

    @Autowired
    private SkillServiceImp skillServiceImp;

	/**
	 *
	 * @param skillDTO
	 * @return model and view
	 */
	@RequestMapping("/addskill")
	public ModelAndView addSkill(SkillDTO skillDTO)
    {
        Skill skill = Skill.builder()
                .skillCategory(skillDTO.getCategory())
                .skillName(skillDTO.getName())
                .skillDescription(skillDTO.getDescription())
                .build();
        skillServiceImp.add_skill(skill);
        ModelAndView modelAndView = new ModelAndView("skills");
		return modelAndView;
	}

	/**
	 *
	 * @param id
	 * @return a single skill
	 */
	@RequestMapping("/getskill")
	public ModelAndView getSkill(long id)
    {
    	ModelAndView modelAndView = new ModelAndView("skill");
		return modelAndView;
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("/myskills")
	public String mySkill(int id)
    {
		return "addskill.jsp";
	}

	/**
	 *
	 * @return
	 */
	@RequestMapping("/skills")
	public String Skills()
    {
		return "skills.jsp";
	}

	/**
	 *
	 * @param skillDTO
	 * @return
	 */
	@RequestMapping("/editskill")
	public ModelAndView editSkill(SkillDTO skillDTO)
    {
        Skill skill = Skill.builder()
                .skillCategory(skillDTO.getCategory())
                .skillName(skillDTO.getName())
                .skillDescription(skillDTO.getDescription())
                .build();
        skillServiceImp.add_skill(skill);
        ModelAndView modelAndView = new ModelAndView("skills");
        return modelAndView;
	}

	/**
	 *
	 * @param skillDTO
	 * @return
	 */
	@RequestMapping("/adeleteskill")
	public String deleteSkill(SkillDTO skillDTO)
    {
		return "addskill.jsp";
	}
}
