package com.ashutosh.socialhub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashutosh.socialhub.dao.FriendDAO;
import com.ashutosh.socialhub.domain.Friend;

public class FriendDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static FriendDAO friendDAO;
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.ashutosh");
		context.refresh();
		
		friendDAO = (FriendDAO) context.getBean("friendDAO");
		
		
}
	
	@Test
	public void addJob()
	
	{
		Friend friend=new Friend();
		friend.setFriendlogonname("Sunita");
		friend.setLoginname("Ashutosh");
		friend.setStatus("online");
		assertTrue("problem",friendDAO.save(friend));
		
	}
	
}
