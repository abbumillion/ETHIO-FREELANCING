package mngmnt.ServiceImp;

import mngmnt.model.Customer;
import mngmnt.repository.CustomerRepo;
import mngmnt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    private CustomerRepo customerRepo;
    @Autowired
    public CustomerServiceImp(CustomerRepo customerRepo)
    {
        this.customerRepo = customerRepo;
    }
    @Override
    public void add_customer(Customer customerModel) {
       // customerRepo.save(ModelToEntityConverter.);
    }
    @Override
    public Customer get_customer(long id) {
        return null;
    }
    @Override
    public List<Customer> all_customer() {
        return null;
    }
    @Override
    public void update_customer(long id) {
    }
    @Override
    public void delete_customer(long id) {
        customerRepo.deleteById(id);
    }
    @Override
    public void delete_all() {
        customerRepo.deleteAll();
    }
}
