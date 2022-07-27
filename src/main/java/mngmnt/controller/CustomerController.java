package mngmnt.controller;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mngmnt.ServiceImp.CustomerServiceImp;
import mngmnt.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@AllArgsConstructor
@NoArgsConstructor

public class CustomerController {
    private CustomerServiceImp customerServiceImp;
    @RequestMapping("/customer/customers")
    public ModelAndView getAllCustomers()
    {
        ModelAndView modelAndView =
                new ModelAndView("customers");
        modelAndView.addObject(customerServiceImp.all_customer());
        return modelAndView;
    }
    @RequestMapping("/api/customer")
    public Customer getAdmin(long id)
    {
        return customerServiceImp.get_customer(id);
    }

}
