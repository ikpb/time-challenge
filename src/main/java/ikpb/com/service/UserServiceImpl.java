package ikpb.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ikpb.models.Users;
import com.ikpb.repository.UserRepository;

public class UserServiceImpl implements UserService {
	private UserRepository ur;
	
	
	@Autowired
	public UserServiceImpl(UserRepository ur) {
		this.ur = ur;
	}

	@Override
	public List<Users> getUsers() {
		
		return ur.findAll();
	}

	@Override
	public Optional<Users> getUserByUsername(String username) {
		
		return ur.getUserByUsername(username);
	}

	@Override
	public Users addUser(Users user) {
		
		return ur.save(user);
	}

	@Override
	public Users updateUser(Users user) {
		
		if(ur.existsById(user.getUsername())) {
			return ur.save(user);
		}else {
			return null;
		}
	}

	@Override
	public String deleteUserByUsername(String username) {
		
		if(ur.existsById(username)) {
			ur.deleteById(username);
			return "Deleted";
		}else {
			return null;
		}
	}

}
