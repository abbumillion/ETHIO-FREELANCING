package mngmnt.service;


import mngmnt.model.Skill;

import java.util.List;

public interface SkillService {
    void add_skill(Skill skillModel);
    Skill get_skill(long id);
    List<Skill> all_skill();
    void update_skill(long id);
    void delete_skill(long id);
    void delete_all();
}
