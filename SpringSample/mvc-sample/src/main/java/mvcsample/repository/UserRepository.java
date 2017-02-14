package mvcsample.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import mvcsample.model.*;
 

@Component
public interface UserRepository {
	List<User> findUsers(long max, int count); 
	
	User findOneByName(String name);
	
	User save(User user);
}
