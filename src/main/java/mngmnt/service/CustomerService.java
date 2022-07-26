package mngmnt.service;


import mngmnt.model.Customer;

import java.util.List;

public interface CustomerService {
    void add_customer(Customer customerModel);
    Customer get_customer(long id);
    List<Customer> all_customer();
    void update_customer(long id);
    void delete_customer(long id);
    void delete_all();
}
