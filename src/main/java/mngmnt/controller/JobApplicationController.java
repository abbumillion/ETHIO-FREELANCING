package mngmnt.controller;


import mngmnt.ServiceImp.JobApplicationServiceImp;
import mngmnt.dto.JobApplicationDTO;
import mngmnt.model.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobApplicationController {

    private JobApplicationServiceImp jobApplicationServiceImp;

    @Autowired
    public JobApplicationController(JobApplicationServiceImp jobApplicationServiceImp)
    {
        this.jobApplicationServiceImp = jobApplicationServiceImp;
    }

    @RequestMapping("/applyforjob")
    public String addJobApplication(JobApplicationDTO jobApplicationDTO)
    {
        JobApplication jobApplication = JobApplication.builder()
                .coverLetter(jobApplicationDTO.getCoverLetter())
                .job(jobApplicationDTO.getJob())
                .applicationDate(jobApplicationDTO.getApplicationDate())
                .build();
        jobApplicationServiceImp.add_job_application(jobApplication);
        return "jobapplications";
    }

    @RequestMapping("/jobapplication{id}")
    public String getJobApplication(long id)
    {
        jobApplicationServiceImp.get_job_application(id);
        return "jobapplication.jsp";
    }

    @RequestMapping("/myjobapplications")
    public String myJob(int id)
    {
        return "myjobs.jsp";
    }

    @RequestMapping("/jobapplications")
    public String allJobs()
    {
        jobApplicationServiceImp.all_job_application();
        return "jobs.jsp";
    }

    @RequestMapping("/editjobapplication")
    public String editJob(JobApplicationDTO jobApplicationDTO)
    {
        return "editjob.jsp";
    }

    @RequestMapping("/api/deletejobapplication")
    public String deleteJobApplication(JobApplicationDTO jobApplication)
    {
        return "deletejob.jsp";
    }

}
