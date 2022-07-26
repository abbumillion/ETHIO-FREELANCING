package mngmnt.ServiceImp;

import mngmnt.model.Freelancer;
import mngmnt.repository.FreelancerRepo;
import mngmnt.service.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreelancerServiceImp implements FreelancerService {
    private FreelancerRepo freelancerRepo;
    @Autowired
    public FreelancerServiceImp(FreelancerRepo freelancerRepo)
    {
        this.freelancerRepo = freelancerRepo;
    }
    @Override
    public void add_freelancer(Freelancer freelancer) {
        freelancerRepo.save(freelancer);
    }
    @Override
    public Freelancer get_freelancer(long id) {
        return null;
    }
    @Override
    public List<Freelancer> all_freelancer() {
        return null;
    }
    @Override
    public void update_freelancer(long id) {

    }
    @Override
    public void delete_freelancer(long id) {
        freelancerRepo.deleteById(id);
    }
    @Override
    public void delete_all() {
        freelancerRepo.deleteAll();
    }
}
