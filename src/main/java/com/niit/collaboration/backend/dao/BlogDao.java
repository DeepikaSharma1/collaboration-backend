package com.niit.collaboration.backend.dao;

import java.util.List;

import com.niit.collaboration.backend.model.Blog;

/**
 * 
 * @author Deepika
 *
 */
public interface BlogDao {

	void create(Blog blog);
	
	void update(Blog blog);
	
	void remove(Blog blog);
	
	Blog get(long blogId);
	
	List<Blog> getNewBlogs();
	
	List<Blog> getApprovedBlogs();
	
}
