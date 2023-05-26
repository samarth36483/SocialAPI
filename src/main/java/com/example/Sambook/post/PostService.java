package com.example.Sambook.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Sambook.location.Location;
import com.example.Sambook.user.User;

@Service
public class PostService {
	
	User user1 = new User("01", 
			"Samarth", 
			"Raipuriya", 
			new Location("36","Beawar"), 
			"samarth@reddif.com");
	User user2 = new User("02", 
			"Prabhat", 
			"Kumar", 
			new Location("01","Delhi"), 
			"blacky@kaalu.com");
	
	Post post_1 = new Post("5423ter", "22-05-2023", user1, "Alone is what I have, alone makes me stronger.");
	
	Post post_2 = new Post("15634ytqt", "22-05-2023", user2, "One day it will be all worth it!");
	
	private List<Post> posts = new ArrayList<>(Arrays.asList(post_1, post_2));
	
	public List<Post> getAllPosts(){
		return posts;
	}
	
	public Post getPost(String id) {
		Post post = posts.stream()
				.filter(t -> id.equals(t.getId()))
				.findFirst()
				.orElse(null);
		
		return post;
	}
	
	public void addPost(Post post) {
		posts.add(post);
	}
	
	public void deletePost(String id) {
		posts.removeIf(t -> t.getId().equals(id));
	}
	
	public void updatePost(String id, Post post) {
		for(int i=0; i<posts.size(); i++) {
			Post p = posts.get(i);
			if(p.getId().equals(id)) {
				posts.set(i, post);
			}
		}
	}
}
