package mngmnt.ServiceImp;

import lombok.AllArgsConstructor;
import mngmnt.model.User;
import mngmnt.repository.UserRepository;
import mngmnt.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email)
    {
        User user = userRepository.findByEmail(email);
        System.out.println("finding user by email");
        System.out.println(user);
        if (user == null)
        {
            throw new UsernameNotFoundException(String.format("User with %s doesn't exist!", email));
        }
        return  user;
    }

    @Override
    public void saveUser(User user)
    {
        if (user.getId() == null)
        {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setActive(Boolean.TRUE);
        }
        userRepository.save(user);
    }

    @Override
    public Page<User> listUsers(Pageable pageable)
    {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> searchByTerm(String name, Pageable pageable)
    {
        return userRepository.searchByTerm(name, pageable);
    }

    @Override
    public Boolean removeAll()
    {
        userRepository.deleteAll();
        return Boolean.TRUE;
    }

    @Override
    public void removeById(Long id)
    {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id)
    {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> searchBy(String keyword, String criteria)
    {
        if ("fullName".equals(criteria)) {
            return userRepository.findByFullNameIgnoreCaseContaining(keyword);
        } else if ("phoneNumber".equals(criteria)) {
            return userRepository.findByPhoneNumberIgnoreCaseContaining(keyword);
        } else if ("email".equals(criteria)) {
            return userRepository.findByEmailIgnoreCaseContaining(keyword);
        }
        return new ArrayList<>();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return userRepository.findByEmail(username);
    }
}
