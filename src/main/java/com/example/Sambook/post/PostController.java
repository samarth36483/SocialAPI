package com.example.Sambook.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/posts")
	public List<Post> getAllPosts(){
		
		return postService.getAllPosts();
	}
	
	@RequestMapping(value = "/posts/{id}")
	public Post getPost(@PathVariable String id) {
		return postService.getPost(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/posts")
	public void addPost(@RequestBody Post post) {
		postService.addPost(post);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/posts/{id}")
	public void deletePost(@PathVariable String id) {
		postService.deletePost(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/posts/{id}")
	public void updatePost(@RequestBody Post post, @PathVariable String id) {
		postService.updatePost(id, post);
	}
}
