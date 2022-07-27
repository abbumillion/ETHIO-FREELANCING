//package mngmnt.ServiceImp;
//
//
//import mngmnt.model.User;
//import mngmnt.model.UserAdapter;
//import mngmnt.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service("customUserDetailsService")
//public class CustomUserDetailsService implements UserDetailsService {
//
//	private final UserRepository userRepository;
//
//	@Autowired
//	public CustomUserDetailsService(@Qualifier("userRepository") UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
//	{
//		User user = userRepository.findByEmail(username);
//		System.out.println("finding user by email");
//		System.out.println(user);
//		if (user == null)
//		{
//			throw new UsernameNotFoundException(String.format("User with %s doesn't exist!", username));
//		}
//		return  user;
//	}
//
//	public User saveUser(User user)
//	{
//
//		/**
//		 * param user
//		 * adding user to the databse through userrepository dao
//		 */
//		return userRepository.save(user);
//	}
//}
