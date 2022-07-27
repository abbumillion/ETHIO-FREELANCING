package mngmnt.controller;

import mngmnt.ServiceImp.AdminServiceImp;
import mngmnt.ServiceImp.CustomerServiceImp;
import mngmnt.ServiceImp.FreelancerServiceImp;
import mngmnt.ServiceImp.UserServiceImpl;
import mngmnt.constants.AppConstant;
import mngmnt.dto.Response;
import mngmnt.dto.SearchDTO;
import mngmnt.dto.SignUpDTO;
import mngmnt.model.Admin;
import mngmnt.model.Customer;
import mngmnt.model.Freelancer;
import mngmnt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
public class UserController {
    /**
     * this is a class for user rest end points
     * for user crud operations and some user business logic
     */
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private FreelancerServiceImp freelancerServiceImp;
    @Autowired
    private CustomerServiceImp customerServiceImp;
    @Autowired
    private AdminServiceImp adminServiceImp;

    @Value("${max.result.per.page}")
    private int maxResults;

    @Value("${max.card.display.on.pagination.tray}")
    private int maxPaginationTraySize;


    /**
     *
     * @return index page request
     */
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    /**
     *
     * @return sign up page
     */
    @RequestMapping("/signup")
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView("create-user");
        return modelAndView;
    }

    /**
     *
     * @param page
     * @param size
     * @param searchTerm
     * @return
     */
    @RequestMapping("/searchBox")
    public ModelAndView searchByTerm(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                                     @RequestParam(value = "size", defaultValue = "4", required = false) Integer size,
                                     @RequestParam(value = "searchTerm", required = false) String searchTerm) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        Page<User> allUsers = userService.searchByTerm(searchTerm.trim(), PageRequest.of(page, size, Sort.by("firstName")));
        modelAndView.addObject("allUsers", allUsers);
        modelAndView.addObject("maxTraySize", size);
        modelAndView.addObject("currentPage", page);
        return modelAndView;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/search")
    public ModelAndView search() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        return modelAndView;
    }

    /**
     *
     * @param searchDto
     * @return
     */
    @RequestMapping("/searchSubmit")
    public ModelAndView searchSubmit(@ModelAttribute SearchDTO searchDto) {
        List<User> result = userService.searchBy(searchDto.getSearchKeyword(), searchDto.getCriteria());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/profile")
    public ModelAndView addNewUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        return modelAndView;
    }

    /**
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/save")
    public Response update(@RequestBody User user) {
        User dbUser = userService.findById(user.getId());
        dbUser.setFullName(user.getFullName());
        dbUser.setEmail(user.getEmail());
        dbUser.setPassword(user.getPassword());
        userService.saveUser(dbUser);
        return new Response(302, AppConstant.SUCCESS, "/");
    }
    /**
     * method for registering users to the system
     *  param sign up data transfer object
     *  author million sharbe
     */
    @RequestMapping("/register")
    public ModelAndView register(@ModelAttribute SignUpDTO signUpDTO) {
        ModelAndView modelAndView = new ModelAndView();
        String result = "redirect:/";
        if (signUpDTO.getFullName() == null || signUpDTO.getFullName().trim().isEmpty()) {
            result = "redirect:/addNewUser?error=Enter valid fist name";
        } else if (signUpDTO.getPhoneNumber() == null || signUpDTO.getPhoneNumber().trim().isEmpty()) {
            result = "redirect:/addNewUser?error=Enter valid phone number";
        } else if (signUpDTO.getEmail() == null || signUpDTO.getEmail().trim().isEmpty()) {
            result = "redirect:/addNewUser?error=Enter valid email";
        } else if (signUpDTO.getPassword() == null || signUpDTO.getPassword().trim().isEmpty()) {
            result = "redirect:/addNewUser?error=Enter valid password";
        } else if (signUpDTO.getPassword().equals(signUpDTO.getConfirmPassword())) {
            result = "redirect:/addNewUser?error=Password mis-match";
        } else if (StringUtils.isEmpty(signUpDTO.getRole())) {
            result = "redirect:/addNewUser?error=Select a valid Role";
        }
        System.out.println(signUpDTO.getFullName());
        System.out.println(signUpDTO.getEmail());
        System.out.println(signUpDTO.getPhoneNumber());
        System.out.println(signUpDTO.getRole());
        System.out.println(signUpDTO.getPassword());
        System.out.println(signUpDTO.getConfirmPassword());
        User user = User.builder()
                .fullName(signUpDTO.getFullName())
                .phoneNumber(signUpDTO.getPhoneNumber())
                .email(signUpDTO.getEmail())
                .isActive(true)
                .password(signUpDTO.getPassword())
                .role(signUpDTO.getRole())
                .build();
        userService.saveUser(user);
        System.out.println(user);
        System.out.println(customerServiceImp);
        switch (user.getRole()) {
            case "FREELANCER":
                /**
                 * saving customer using customer service
                 * with user and customer object
                 */
                Freelancer freelancer = Freelancer.builder()
                        .user(user)
                        .build();
                freelancerServiceImp.add_freelancer(freelancer);
//                modelAndView.setViewName("freelancerhome");
                break;
            case "CUSTOMER":
                /**
                 * saving customer using customer service
                 * with user and customer object
                 */
                System.out.println(user);
                System.out.println(userService);
                Customer customer = Customer.builder()
                        .user(user)
                        .build();
                System.out.println(customer);
                System.out.println(customerServiceImp);
                customerServiceImp.add_customer(customer);
//                modelAndView.setViewName("customerhome");
                break;
            case "ADMIN":
                /**
                 * admin registration logic
                 * with user object
                 */
                Admin admin = Admin.builder()
                        .user(user)
                        .build();
                System.out.println(admin);
                System.out.println();
                adminServiceImp.add_admin(admin);
        }
        return modelAndView;
    }

    /**
     *
     * @param userId
     * @return delete a single user from database
     */
    @RequestMapping("/delete/{userId}")
    public String delete(@PathVariable Long userId) {
        userService.removeById(userId);
        return "redirect:/";
    }

    /**
     *
     * @return boolean for removing all users  from database
     */
    @ResponseBody
    @RequestMapping("/removeAll")
    public Boolean removeAll() {
        return userService.removeAll();
    }

    /**
     *
     * @return access denied page
     */
    @RequestMapping("/403")
    public ModelAndView accessDenied() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("403");
        return modelAndView;
    }

    /**
     *
     * @return about page
     */
    @RequestMapping("/about")
    public ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("about");
        return modelAndView;
    }

}
