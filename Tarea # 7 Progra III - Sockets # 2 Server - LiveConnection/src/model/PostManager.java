package model;

import java.util.ArrayList;

public class PostManager {
	
	private ArrayList<Post> postList;
	private int id;
	
	public PostManager() {
		postList = new ArrayList<Post>();
		id = 0;
	}
	
	public Post createPost(String tittle, String photoPhat, String description, int phone) {
		return new Post(id++, tittle, photoPhat, description, phone);
	}
	
	public void addPost(Post post) {
		postList.add(post);
	}
	
	public void deletePost(Post postTodelete) {
		for (Post post : postList) {
			if (post == postTodelete) {
				postList.remove(post);
			}
		}
	}
	
	public Post findPost(int id) {
		Post aux = null;
		for (Post post : postList) {
			if (id == post.getId()) {
				aux = post;
			}
		}
		return aux;
	}
	
	public ArrayList<Post> getPostList() {
		return postList;
	}
}
