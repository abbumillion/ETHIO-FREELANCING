package mngmnt.service;


import mngmnt.model.Admin;

import java.util.List;

public interface AdminService {
    void add_admin(Admin admin);
    Admin get_admin(long id);
    List<Admin> all_admin();
    Admin update_admin(long id);
    void delete_admin(long id);
    void delete_all();
}
