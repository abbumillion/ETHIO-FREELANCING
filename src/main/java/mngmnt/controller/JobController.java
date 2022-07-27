package mngmnt.controller;

import mngmnt.ServiceImp.JobServiceImp;
import mngmnt.dto.JobDTO;
import mngmnt.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class JobController {

	@Autowired
	private JobServiceImp jobServiceImp;

//	@RequestMapping("/postjob")
//	public String postJob(JobDTO jobDTO) {
//
//		System.out.println(jobDTO);
////
////        Job job = Job.builder()
////                .budget(jobDTO.getBudget())
////                .category(jobDTO.getCategory())
////                .description(jobDTO.getDescription())
////                .endDate(jobDTO.getEndDate())
////                .experience(jobDTO.getExperience())
////                .posted(jobDTO.getPosted())
////                .title(jobDTO.getTitle())
////                .type(jobDTO.getType())
////                .vacancy(jobDTO.getVacancy())
////				.skill(jobDTO.getSkill())
//////				.customer(jobDTO.getCustomerDTO())
////                .build();
////		jobServiceImp.add_job(job);
//		return "jobs";
//	}

//	@RequestMapping("/post")
//	public ModelAndView post() {
//		ModelAndView modelAndView = new ModelAndView("jobform");
//		return modelAndView;
//	}

	/**
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("/api/myjobs")
	public String myJob(long id) {
		// getting all job posted by a single customer
		return "myjobs.jsp";
	}

	/**
	 *
	 * @return
	 */
	@RequestMapping("/api/jobs")
	public String allJobs() {
		 List<Job> jobs = jobServiceImp.all_job();
		return "jobs.jsp";
	}

	/**
	 *
	 * @param job
	 * @return
	 */
	@RequestMapping("/api/editjob")
	public String editJob(JobDTO job) {
		return "editjob.jsp";
	}

	/**
	 *
	 * @param job
	 * @return
	 */
	@RequestMapping("/api/deletejob")
	public String deleteJob(JobDTO job) {
		return "deletejob.jsp";
	}
//
}
