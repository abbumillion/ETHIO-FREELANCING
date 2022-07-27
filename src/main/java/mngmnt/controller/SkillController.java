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

    @Autowired
    private SkillServiceImp skillServiceImp;

	@RequestMapping("/addskill")
	public ModelAndView addSkill(SkillDTO skillDTO)
    {
	    //------------------------------------------------------------------------------------------------------------//
        Skill skill = Skill.builder()
                .skillCategory(skillDTO.getCategory())
                .skillName(skillDTO.getName())
                .skillDescription(skillDTO.getDescription())
                .build();
        skillServiceImp.add_skill(skill);
        ModelAndView modelAndView = new ModelAndView("skills");
		return modelAndView;
		//------------------------------------------------------------------------------------------------------------//
	}

	@RequestMapping("/getskill")
	public String getSkill(int id)
    {
		return "addskill.jsp";
	}

	@RequestMapping("/myskills")
	public String mySkill(int id)
    {
		return "addskill.jsp";
	}

	@RequestMapping("/skills")
	public String Skills()
    {
		return "skills.jsp";
	}

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
	@RequestMapping("/adeleteskill")
	public String deleteSkill(SkillDTO skillDTO)
    {
		return "addskill.jsp";
	}
}
