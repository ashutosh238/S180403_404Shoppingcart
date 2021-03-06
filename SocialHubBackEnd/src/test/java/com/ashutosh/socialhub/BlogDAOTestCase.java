package com.ashutosh.socialhub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ashutosh.socialhub.dao.BlogDAO;
import com.ashutosh.socialhub.domain.Blog;

import junit.framework.Assert;

public class BlogDAOTestCase {
	

private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static BlogDAO blogDAO;
	
	@Autowired
private static Blog blog;
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.ashutosh");
		context.refresh();
		
		blogDAO = (BlogDAO) context.getBean("blogDAO");
		
		blog = (Blog) context.getBean("blog");
		
}
	
	
	 
	@Test
	public void addBlogTestCase()
	{	//blog.setBlogId(0);
		blog.setBolgContent("Springis a framwork of frameworks");
		blog.setBolgName("Spring");
		blog.setDislikes(100);
		blog.setLikes(2);
		blog.setLoginName("Shrinivas");
		blog.setStatus("NA");
		
		//boolean actual = userDAO.save(user);
		Assert.assertEquals("Add Blog Test Case" , true  , blogDAO.save(blog));
		
	}

	 
@Test
public void deleteBlogTest()
{
	Blog blog=blogDAO.get(5);
	assertTrue("Problem in Deleting:",blogDAO.delete(blog));
}
	 
	@Test
	public void UpdateBlogTest()
	{
		Blog blog=blogDAO.get(4);
		blog.setStatus("A");
		blog.setBolgContent("Spring handels the infrastructure due to which develoger imphesises on buiseness logic");
		assertTrue("Problem in Updateing:",blogDAO.update(blog));
	}
	
	@Test
	public void getAllBlogs()
	{
		int size = blogDAO.list().size();
		
		Assert.assertEquals(5, size);
	}

}
