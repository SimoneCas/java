package mvcsample.repository;

import java.util.List;
import mvcsample.model.*;
 
/*
 * ritorna la lista di N utenti (N=count) con id massimo uguale a max 
 */
public interface UserRepository {
	List<User> findUsers(long max, int count); 
}
