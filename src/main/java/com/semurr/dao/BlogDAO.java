package com.semurr.dao;

import java.util.List;

import com.semurr.model.Blog;

public interface BlogDAO {

	/**
	 * Adds a blog into the database
	 * 
	 * @param blog
	 *            The blog you want to add
	 */
	public void addBlog(Blog blog);

	/**
	 * Get the blog by the ID value
	 * 
	 * @param Id
	 *            the blog_id of the blog
	 * @return the Blog
	 */
	public Blog getBlogById(int id);
	
	public Blog getBlogByTitle(String title);

	public List<Blog> getAllBlogs();

}
