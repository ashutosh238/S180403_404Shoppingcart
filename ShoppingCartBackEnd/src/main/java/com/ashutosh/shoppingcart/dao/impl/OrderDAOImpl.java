package com.ashutosh.shoppingcart.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashutosh.shoppingcart.dao.OrderDAO;
import com.ashutosh.shoppingcart.domain.OrderDetail;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean receiptGenerate(OrderDetail orderDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean updateCartItemStatus(String emailID) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("update CartItem set status='P' where emailID=:emailID");
		query.setParameter("username", emailID);
		int row_eff=query.executeUpdate();
		return row_eff>0;
	}

}
