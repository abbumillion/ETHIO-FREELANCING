package mngmnt.ServiceImp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mngmnt.model.Customer;
import mngmnt.repository.CustomerRepo;
import mngmnt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    /**
     * This is a Customer service module
     * containing all customer crud operations along with
     * some business logics
     * Author Million Sharbe
     * Date jun 23 , 2022
     */
    private CustomerRepo customerRepo;
    @Autowired
    public CustomerServiceImp(CustomerRepo customerRepo)
    {
        this.customerRepo = customerRepo;
    }

    @Override
    public void add_customer(Customer customer) {
        /**
         * saving customer to database here
         *
         */

        System.out.println(customer);

        customerRepo.save(customer);
    }
    @Override
    public Customer get_customer(long id) {
        /**
         * get customer by id
         */
        return customerRepo.getReferenceById(id);
    }
    @Override
    public List<Customer> all_customer() {
        /**
         * get all customers as list
         */
        return customerRepo.findAll();
    }
    @Override
    public void update_customer(long id,Customer customer) {
        /**
         * update a customer
         */
        customerRepo.save(customer);
    }
    @Override
    public void delete_customer(long id) {
        /**
         * delete a single customer by id
         */
        customerRepo.deleteById(id);
    }
    @Override
    public void delete_all() {
        /**
         * delete all customers
         */
        customerRepo.deleteAll();
    }
}
