package mngmnt.controller;


import mngmnt.ServiceImp.*;
import mngmnt.dto.AdminDTO;
import mngmnt.exception.InvalidAdminException;
import mngmnt.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author   million sharbe
 * Description: This class is used as the controller for the Admin module
 * Created Date: 18 April, 2022
 * Version : v1.0.0
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
	@Autowired
	AdminServiceImp adminService;
	@Autowired
	FreelancerServiceImp freelancerServiceImp;
	@Autowired
	CustomerServiceImp customerServiceImp;
	@Autowired
	JobServiceImp jobServiceImp;
	@Autowired
	JobApplicationServiceImp jobApplicationServiceImp;

	/**
	 *
	 * @param        id,admin
	 * @return       Response Entity of Object type
	 * Description : This method Updates the entry in Admin.
	 * @PutMapping: Handles HTTP Put Requests
	 *
	 */

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> adminUpdate(@PathVariable Long id, @RequestBody AdminDTO adminDto) {

		try {
			Admin admin = Admin.builder().build();
			adminService.update_admin(id, admin);
			return new ResponseEntity<>("Admin Successfully", HttpStatus.ACCEPTED);

		} catch (InvalidAdminException exception) {
			throw new InvalidAdminException("Admin with given id not found");
		}
	}

	/**
	 *
	 * @param        id
	 * @return       Response Entity of type Admin
	 * Description : This method finds Admin by id
	 * @GetMapping: Annotation for mapping HTTP GET requests onto specific handler methods.
	 *
	 */

	@GetMapping(value = "/find/id")
	public Admin findById(@PathVariable Long id) {
		try {
			return adminService.get_admin(2l);
		} catch (InvalidAdminException exception) {
			throw new InvalidAdminException("Id not found");
		}
	}

	/**
	 *
	 * @param        userName
	 * @return       Response Entity of type Admin
	 * Description: This method finds Admin by userName
	 * @GetMapping: Annotation for mapping HTTP GET requests onto specific handler methods.
	 *
	 */
//
//	@GetMapping(value = "/find/{userName}")
//	public Admin findByUserName(@PathVariable String userName) {
//		try {
//			return adminService.get_admin(userName);
//		} catch (InvalidAdminException exception) {
//			throw new InvalidAdminException("Admin with userName not found");
//		}
//	}
}