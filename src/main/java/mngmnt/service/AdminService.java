package mngmnt.service;


import mngmnt.model.Admin;
import java.util.List;


/**************************************************************************************
 * Description : interface for admin services
 * Created Date: 22 jun, 2022
 * Version     : v1.0.0
 * Author      : Million Sharbe
 *************************************************************************************/

public interface AdminService {
    void add_admin(Admin admin);
    Admin get_admin(long id);
    List<Admin> all_admin();
    Admin update_admin(long id,Admin admin);
    void delete_admin(long id);
    void delete_all();

}
