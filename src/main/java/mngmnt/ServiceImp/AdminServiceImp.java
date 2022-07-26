package mngmnt.ServiceImp;
import mngmnt.model.Admin;
import mngmnt.repository.AdminRepo;
import mngmnt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	public AdminServiceImp(AdminRepo adminRepo)
	{
		this.adminRepo = adminRepo;
	}
	@Override
	public void add_admin(Admin admin)
	{
		adminRepo.save(admin);
	}
	@Override
	public Admin get_admin(long id)
	{
		return null;
	}
	@Override
	public List<Admin> all_admin()
	{
		return adminRepo.findAll();
	}
	@Override
	public Admin update_admin(long id,Admin admin)
	{
		return adminRepo.save(admin);
	}
	@Override
	public void delete_admin(long id)
	{
		adminRepo.deleteById(id);
	}
	@Override
	public void delete_all()
	{
		adminRepo.deleteAll();
	}

}
