package mngmnt.ServiceImp;


import mngmnt.model.Job;
import mngmnt.repository.JobRepo;
import mngmnt.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImp implements JobService {

	private JobRepo jobRepo;

	@Autowired
	public JobServiceImp(JobRepo jobRepo)
	{
		this.jobRepo = jobRepo;
	}

	@Override
	public void add_job(Job jobModel)
	{
		//jobRepo.save(job);
	}

	@Override
	public Job get_job(long id)
	{
		//returns a jobModel by fetching a job entity from database and converting in to job model//
		return null;
	}

	@Override
	public List<Job> all_job() {
		List<Job> jobModels=new ArrayList<>();
		//

		//
		return null;
	}

	@Override
	public void update_job(long id) {

	}

	@Override
	public void delete_job(long id) {
		jobRepo.deleteById(id);
	}

	@Override
	public void delete_all() {
		jobRepo.deleteAll();
	}
}
