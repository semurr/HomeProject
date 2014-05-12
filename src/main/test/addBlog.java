import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.semurr.dao.BlogDAO;
import com.semurr.dao.impl.BlogDAOImpl;
import com.semurr.model.Blog;


public class addBlog {
	
	BlogDAO blogTestDao = new BlogDAOImpl();

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addBlogTest() {
		
		Blog blog = new Blog();
		
		/* it works	
			
			blog.setTitle("test Title " + i);
			blog.setSubject("test subject " + i);
			blog.setAuthor("test author" + i);
			
			BlogDAO blogTestDao = new BlogDAOImpl();
			
			blogTestDao.addBlog(blog);
		*/	
	}
	
	@Test
	public void getBlogById(){
		
		
		
		Blog testBlog = blogTestDao.getBlogById(1);
		
		System.out.println(testBlog.getBlog_id());
		System.out.println(testBlog.getTitle());
		System.out.println(testBlog.getSubject());
		System.out.println(testBlog.getAuthor());		
		
	}
	
	@Test
	public void getBlogByTitle(){
		
		Blog testBlog = blogTestDao.getBlogByTitle("test Title 1");
		
		System.out.println(testBlog.getBlog_id());
		System.out.println(testBlog.getTitle());
		System.out.println(testBlog.getSubject());
		System.out.println(testBlog.getAuthor());		
	}
	
	@Test
	public void getAllBlogs(){
		
		List<Blog> blogs = blogTestDao.getAllBlogs();
		
		for(Blog b : blogs){
			System.out.println(b.getBlog_id());
			System.out.println(b.getTitle());
			System.out.println(b.getSubject());
			System.out.println(b.getAuthor());						
		}
		
	}

}
