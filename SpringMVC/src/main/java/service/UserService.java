package service;

import vo.BusinessException;
import vo.User;

public interface UserService {

	String SetDetails(User user) throws BusinessException;
}
