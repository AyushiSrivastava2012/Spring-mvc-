package repositoryImpl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import repository.UserRepository;
import vo.BusinessException;
import vo.Status;
import vo.User;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	final static Logger logger = Logger.getLogger(UserRepositoryImpl.class);
	
	public String SetDetails(User user) throws BusinessException{
		String methodname="SetDetails";
		logger.info(methodname+" starts");
		try{
		if(jdbcTemplate.update((new StringBuilder("insert into SPRINGPROJECT.UserDetails(UserName,UserPassword) Values (?,?)")).toString(),new Object[]{user.getName(),user.getPassword()})==1)
			return "Successful Login";
		else{
			return "Not able to Login";
		}
		}
		catch(Exception e){
			throw new BusinessException(new Status("Something went wrong",500), e);	
		}
	}

	
}
