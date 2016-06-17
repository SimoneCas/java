package mvcsample.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import mvcsample.model.*;
 
/*
 * ritorna la lista di N utenti (N=count) con id massimo uguale a max 
 */
@Component
public interface UserRepository {
	List<User> findUsers(long max, int count); 
	
	User findOneByName(String name);
	
	User save(User user);
}
