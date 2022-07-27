package mngmnt.controller;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mngmnt.ServiceImp.CustomerServiceImp;
import mngmnt.ServiceImp.FreelancerServiceImp;
import mngmnt.ServiceImp.JobApplicationServiceImp;
import mngmnt.ServiceImp.JobServiceImp;
import mngmnt.helpers.ROLE;
import mngmnt.model.Customer;
import mngmnt.model.Freelancer;
import mngmnt.model.Skill;
import mngmnt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
@AllArgsConstructor
@NoArgsConstructor

public class CustomerController {
    /**
     * this customer a rest end point
     * definitions with crud and some business logic
     * Author Thomas Fasil
     * Date jul 12 , 2022
     */
    @Autowired
    private CustomerServiceImp customerServiceImp;
    @Autowired
    private FreelancerServiceImp freelancerServiceImp;
    @Autowired
    private JobServiceImp jobServiceImp;
    @Autowired
    private JobApplicationServiceImp jobApplicationServiceImp;

    /**
     * method get all customers
     * @return ModelAndView
     */
    @RequestMapping("/customer/customers")
    public ModelAndView getAllCustomers()
    {
        ModelAndView modelAndView =
                new ModelAndView("customers");
        modelAndView.addObject(customerServiceImp.all_customer());
        return modelAndView;
    }

    /**
     *
     * @param page
     * @param size
     * @param request
     * @param response
     * @return customer home page
     */
    @RequestMapping("/customer/home")
    public ModelAndView home(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                             @RequestParam(value = "size", defaultValue = "4", required = false) Integer size,
                             HttpServletRequest request, HttpServletResponse response) {
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        List<String> list = new ArrayList<>();
        authorities.forEach(e -> {
            list.add(e.getAuthority());
        });

        ModelAndView modelAndView = new ModelAndView();
        if (list.contains(ROLE.CUSTOMER.name())) {
            modelAndView.setViewName("home");
            Page<Freelancer> allUsers = freelancerServiceImp.listFreelancer(PageRequest.of(page, size, Sort.by("fullName")));
            modelAndView.addObject("allUsers", allUsers);
            modelAndView.addObject("maxTraySize", size);
            modelAndView.addObject("currentPage", page);
        }
//        } else {
//            modelAndView.setViewName("user-home");
//            User user = userService.findUserByEmail(request.getUserPrincipal().getName());
//            modelAndView.addObject("currentUser", user);
//        }

        return modelAndView;
    }

    /**
     *
     * @param id
     * @return Customer
     */
    @RequestMapping("/customer/customer")
    public Customer getAdmin(long id)
    {
        return customerServiceImp.get_customer(id);
    }

}
