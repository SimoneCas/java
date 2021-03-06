package mvcsample.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import mvcsample.exception.DuplicateUserSaveException;
import mvcsample.model.User;
import mvcsample.repository.UserRepository;

@Component
public class UserCabledRepository implements UserRepository{

	List<User> userPreList;
	
	public UserCabledRepository(){
		this.userPreList = new ArrayList<User>();
		userPreList.add(new User("Mario","Rossi", new Date(), 180d, 80d));
		userPreList.add(new User("Federico","Verdi", new Date(), 190d, 85d));
		userPreList.add(new User("Claudio","Bianchi", new Date(), 170d, 65d));
		userPreList.add(new User("Simone","Neri", new Date(), 182d, 84d));
	}
	
	public List<User> findUsers(long max, int count) {
		
		
		if (count < userPreList.size()){
			List<User> userList = new ArrayList<User>();
			for(int i=0; i<count; i++){
				userList.add(userPreList.get(i));
			}
			return userList;
		} else
		return userPreList;
	}
	
	public User findOneByName(String name){
		
		for(User user : userPreList){
			if(user.getName().equals(name)){
				return user;
			}
		}
		return null;
	}
	 
	
	public User save(User user){
		if(dbContainsName(user.getName()))
			throw new DuplicateUserSaveException();
		this.userPreList.add(user);
		return user;
	}
	
	private boolean dbContainsName(String name){
		for(User user: userPreList){
			if(user.getName().equals(name))
				return true;
		}
		return false;
	}
}
