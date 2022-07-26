package mngmnt.service;


import mngmnt.model.Job;

import java.util.List;

public interface JobService {
    void add_job(Job job);
    Job get_job(long id);
    List<Job> all_job();
    void update_job(long id);
    void delete_job(long id);
    void delete_all();
}
