package mngmnt.controller;
import mngmnt.ServiceImp.CustomerServiceImp;
import mngmnt.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CustomerController {
    private CustomerServiceImp customerServiceImp;
    @Autowired
    public CustomerController(CustomerServiceImp customerServiceImp)
    {
        this.customerServiceImp = customerServiceImp;
    }
    @RequestMapping("/api/customers")
    public List<Customer> getAllCustomers()
    {
        return customerServiceImp.all_customer();
    }
    @RequestMapping("/api/customer")
    public Customer getAdmin(long id)
    {
        return customerServiceImp.get_customer(id);
    }

}
