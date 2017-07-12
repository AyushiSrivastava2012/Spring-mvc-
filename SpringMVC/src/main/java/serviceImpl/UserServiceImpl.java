package serviceImpl;

import org.apache.log4j.Logger;
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

	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	public String SetDetails(User user) throws BusinessException{
		String methodname="SetDetails";
		logger.info(methodname+" starts");
		return userRepository.SetDetails(user);
	}

}
