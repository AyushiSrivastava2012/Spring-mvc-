package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.UserRepository;
import service.UserService;
import vo.BusinessException;
import vo.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	public String SetDetails(User user) throws BusinessException{
		String methodname="SetDetails";
		System.out.println(methodname+" starts");
		return userRepository.SetDetails(user);
	}

}
