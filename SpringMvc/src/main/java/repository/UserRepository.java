package repository;

import vo.BusinessException;
import vo.User;

public interface UserRepository {

	String SetDetails(User user) throws BusinessException;
}
