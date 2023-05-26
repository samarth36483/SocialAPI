package com.example.Sambook.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Sambook.location.Location;

@Service
public class UserService {
	
	User user_1 = new User("01", 
			"Samarth", 
			"Raipuriya", 
			new Location("36","Beawar"), 
			"samarth@reddif.com");
	User user_2 = new User("02", 
			"Prabhat", 
			"Kumar", 
			new Location("01","Delhi"), 
			"blacky@kaalu.com");
	User user_3 = new User("03", 
			"Rajeev", 
			"Ranjan", 
			new Location("69","Gopalganj"), 
			"devdas@darua.com");
	
	private List<User> users = new ArrayList<>(Arrays.asList(user_1, user_2, user_3));
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User getUser(String id) {
		User user = users.stream()
				.filter(t -> id.equals(t.getId()))
				.findFirst()
				.orElse(null);
		
		return user;
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void deleteUser(String id) {
		users.removeIf(t -> t.getId().equals(id));
	}
	
	public void updateUser(String id, User user) {
		for(int i=0; i<users.size(); i++) {
			User u = users.get(i);
			if(u.getId().equals(id)) {
				users.set(i, user);
			}
		}
	}
}
