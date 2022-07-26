package mngmnt.controller;

import mngmnt.ServiceImp.AdminServiceImp;
import mngmnt.ServiceImp.CustomerServiceImp;
import mngmnt.ServiceImp.FreelancerServiceImp;
import mngmnt.constants.AppConstant;
import mngmnt.dto.Response;
import mngmnt.dto.SearchDTO;
import mngmnt.dto.SignUpDTO;
import mngmnt.helpers.ROLE;
import mngmnt.model.Admin;
import mngmnt.model.Customer;
import mngmnt.model.Freelancer;
import mngmnt.model.User;
import mngmnt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AdminServiceImp adminServiceImp;
    @Autowired
    private FreelancerServiceImp freelancerServiceImp;
    @Autowired
    private CustomerServiceImp customerServiceImp;

    @Value("${max.result.per.page}")
    private int maxResults;

    @Value("${max.card.display.on.pagination.tray}")
    private int maxPaginationTraySize;



    @RequestMapping("/")
    public ModelAndView index()
    {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping("/signup")
    public ModelAndView signup()
    {
        ModelAndView modelAndView = new ModelAndView("create-user");
        return modelAndView;
    }



    @GetMapping("/home")
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
        if (list.contains(ROLE.ADMIN.name())) {
            modelAndView.setViewName("home");
            Page<User> allUsers = userService.listUsers(PageRequest.of(page, size, Sort.by("firstName")));
            modelAndView.addObject("allUsers", allUsers);
            modelAndView.addObject("maxTraySize", size);
            modelAndView.addObject("currentPage", page);
        } else {
            modelAndView.setViewName("user-home");
            User user = userService.findUserByEmail(request.getUserPrincipal().getName());
            modelAndView.addObject("currentUser", user);
        }

        return modelAndView;
    }


    @GetMapping("/searchBox")
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

    @GetMapping("/search")
    public ModelAndView search() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        return modelAndView;
    }

    @PostMapping("/searchSubmit")
    public ModelAndView searchSubmit(@ModelAttribute SearchDTO searchDto) {
        List<User> result = userService.searchBy(searchDto.getSearchKeyword(), searchDto.getCriteria());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        modelAndView.addObject("result", result);
        return modelAndView;
    }


    @GetMapping("/addNewUser")
    public ModelAndView addNewUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create-user");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping("/save")
    public Response update(@RequestBody User user) {
        User dbUser = userService.findById(user.getId());
        dbUser.setFirstName(user.getFirstName());
        dbUser.setLastName(user.getLastName());
        userService.saveUser(dbUser);
        return new Response(302, AppConstant.SUCCESS, "/");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute SignUpDTO signUpDTO) {

        String result = "redirect:/";
        User dbUser = userService.findUserByEmail(signUpDTO.getEmail());
        if (signUpDTO.getFirstName() == null || signUpDTO.getFirstName().trim().isEmpty()) {
            result = "redirect:/addNewUser?error=Enter valid fist name";
        }
        else if (signUpDTO.getLastName() == null || signUpDTO.getLastName().trim().isEmpty()) {
            result = "redirect:/addNewUser?error=Enter valid last name";
        }
        else if (signUpDTO.getEmail() == null || signUpDTO.getEmail().trim().isEmpty()) {
            result = "redirect:/addNewUser?error=Enter valid email";
        }
        else if (signUpDTO.getPassword() == null || signUpDTO.getPassword().trim().isEmpty()) {
            result = "redirect:/addNewUser?error=Enter valid password";
        }

        else if(signUpDTO.getPassword().equals(signUpDTO.getConfirmPassword()))
        {
            result = "redirect:/addNewUser?error=Password mis-match";
        }

        else if (StringUtils.isEmpty(signUpDTO.getRoleName())) {
            result = "redirect:/addNewUser?error=Select a valid Role";
        }
        if (dbUser == null) {
            //
            //
            //
            User user = User.builder()
                    .firstName(signUpDTO.getFirstName())
                    .lastName(signUpDTO.getLastName())
                    .email(signUpDTO.getEmail())
                    .isActive(signUpDTO.isActive())
                    .password(signUpDTO.getPassword())
                    .roleName(signUpDTO.getRoleName())
                    .build();

            userService.saveUser(user);
            //
            //
            //
            switch (signUpDTO.getRoleName())
            {
                case "ADMIN":
                    Admin admin = Admin.builder()
                            .user(user)
                            .build();
                    adminServiceImp.add_admin(admin);
                    break;
                case "FREELANCER":
                    Freelancer freelancer = Freelancer.builder()
                            .user(user)
                            .build();
                            freelancerServiceImp.add_freelancer(freelancer);
                    break;
                case "CUSTOMER":
                    Customer customer = Customer.builder()
                            .user(user)
                            .build();
                            customerServiceImp.add_customer(customer);
                    break;
                //
                //
                //
            }
            result = "redirect:/home";
        } else {
            result = "redirect:/addNewUser?error=User Already Exists!";
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/delete/{userId}")
    public String delete(@PathVariable Long userId) {
        userService.removeById(userId);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/removeAll")
    public Boolean removeAll() {
        return userService.removeAll();
    }

    @GetMapping("/403")
    public ModelAndView accessDenied() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("403");
        return modelAndView;
    }

    @GetMapping("/error")
    public ModelAndView error() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @GetMapping("/about")
    public ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("about");
        return modelAndView;
    }

}
