package mngmnt.ServiceImp;


import mngmnt.model.Skill;
import mngmnt.repository.SkillRepo;
import mngmnt.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImp implements SkillService {
	private SkillRepo skillRepo;
	@Autowired
	public SkillServiceImp(SkillRepo skillRepo)
	{
		this.skillRepo = skillRepo;
	}
	@Override
	public void add_skill(Skill skillModel)
	{
		//skillRepo.save(skill);
	}
	@Override
	public Skill get_skill(long id)
	{
		return null;
	}
	@Override
	public List<Skill> all_skill()
	{
		return null;
	}
	@Override
	public void update_skill(long id)
	{

	}
	@Override
	public void delete_skill(long id)
	{
		skillRepo.deleteById(id);
	}
	@Override
	public void delete_all()
	{
		skillRepo.deleteAll();
	}
}
