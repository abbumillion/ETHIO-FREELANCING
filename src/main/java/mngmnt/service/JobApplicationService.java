package mngmnt.service;


import mngmnt.model.JobApplication;

import java.util.List;

public interface JobApplicationService {
    void add_job_application(JobApplication jobApplicationModel);
    JobApplication get_job_application(long id);
    List<JobApplication> all_job_application();
    void update_job_application(long id);
    void delete_job_application(long id);
    void delete_all();
}
