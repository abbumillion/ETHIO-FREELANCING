package mngmnt.ServiceImp;

import mngmnt.model.Freelancer;
import mngmnt.repository.FreelancerRepo;
import mngmnt.service.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreelancerServiceImp implements FreelancerService {
    @Autowired
    private FreelancerRepo freelancerRepo;

    /**
     *
     * @param freelancer
     */
    @Override
    public void add_freelancer(Freelancer freelancer) {
        freelancerRepo.save(freelancer);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Freelancer get_freelancer(long id) {
        return freelancerRepo.getReferenceById(id);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Freelancer> all_freelancer() {
        return freelancerRepo.findAll();
    }

    /**
     *
     * @param pageable
     * @return
     */
    @Override
    public Page<Freelancer> listFreelancer(Pageable pageable) {
        return freelancerRepo.findAll(pageable);
    }

    /**
     *
     * @param id
     */
    @Override
    public void update_freelancer(long id) {
    }
    @Override
    public void delete_freelancer(long id) {
        freelancerRepo.deleteById(id);
    }

    /**
     *
     */
    @Override
    public void delete_all() {
        freelancerRepo.deleteAll();
    }
}
