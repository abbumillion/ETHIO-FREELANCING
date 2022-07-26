package mngmnt.service;


import mngmnt.model.Freelancer;

import java.util.List;

public interface FreelancerService {
    void add_freelancer(Freelancer freelancer);
    Freelancer get_freelancer(long id);
    List<Freelancer> all_freelancer();
    void update_freelancer(long id);
    void delete_freelancer(long id);
    void delete_all();
}
