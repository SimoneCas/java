package it.simonecasamassa.spring.restsample.repository;

import it.simonecasamassa.spring.restsample.model.User;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

 
/*
 * ritorna la lista di N utenti (N=count) con id massimo uguale a max 
 */
@Repository
public interface UserRepository {
	List<User> findUsers(long max, int count); 
	
	User findOneByName(String name);
	
	User findOneById(Long id);
	
	User save(User user);
}
