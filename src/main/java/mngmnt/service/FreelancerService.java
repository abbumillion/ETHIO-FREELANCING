package mngmnt.service;


import mngmnt.model.Freelancer;
import mngmnt.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FreelancerService {
    void add_freelancer(Freelancer freelancer);
    Freelancer get_freelancer(long id);
    List<Freelancer> all_freelancer();
    Page<Freelancer> listFreelancer(Pageable pageable);
    void update_freelancer(long id);
    void delete_freelancer(long id);
    void delete_all();
}
