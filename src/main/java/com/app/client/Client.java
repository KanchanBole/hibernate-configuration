package com.app.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Customer;
import com.app.utility.hibernateUtility;

public class Client {

	public static void main(String[] args) {

		Customer customer=new Customer();
		customer.setName("swami");
		customer.setMobile("9874568512");
	    customer.setAddress("nashik");	
		
	    SessionFactory sf=hibernateUtility.getConnection();
	    Session session=sf.openSession();
	    
	    Transaction tx=session.beginTransaction();
	    session.save(customer);
	    tx.commit();
	    
	    if (tx.wasCommitted()) {
			System.out.println("success");
		}else {
			System.out.println("failure");
		}
	}

}
