package mngmnt.controller;


import mngmnt.ServiceImp.FreelancerServiceImp;
import mngmnt.dto.FreelancerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class FreelancerController {
    private FreelancerServiceImp freelancerServiceImp;
    @Autowired
    public FreelancerController(FreelancerServiceImp freelancerServiceImp)
    {
        this.freelancerServiceImp = freelancerServiceImp;
    }
    @RequestMapping("/api/get_freelancers")
    public List getAllFreelancers()
    {
        return freelancerServiceImp.all_freelancer();
    }
    @RequestMapping("/api/get_freelancer")
    public Object getFreelancer(long id)
    {
        return freelancerServiceImp.get_freelancer(id);
    }
    @RequestMapping("/api/add_customer")
    public String addFreelancer(FreelancerDTO freelancerDTO)
    {
        return "freelancer added";
    }
    @RequestMapping("api/edit_job")
    public String allJob()
    {
        return "jobs";
    }
    @RequestMapping("api/job_category")
    public String job_category()
    {
        return "job_category";
    }

}
