package repositoryImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import repository.UserRepository;
import vo.BusinessException;
import vo.User;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String SetDetails(User user) throws BusinessException{
		String methodname="SetDetails";
		System.out.println(methodname+" stats");
		return ""+jdbcTemplate.update((new StringBuilder("insert into SPRINGPROJECT.UserDetails(UserName,UserPassword) Values (?,?)")).toString(),new Object[]{user.getName(),user.getPassword()});
	}

	
}
