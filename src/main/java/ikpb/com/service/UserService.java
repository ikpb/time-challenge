package ikpb.com.service;

import java.util.List;
import java.util.Optional;

import com.ikpb.models.Users;
public interface UserService {

	public List<Users> getUsers();
	public Optional<Users> getUserByUsername(String username);
	public Users addUser(Users user);
	public Users updateUser(Users user);
	public String deleteUserByUsername(String username);
}
