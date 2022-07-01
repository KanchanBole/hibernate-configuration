package com.app.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.model.Customer;
import com.app.utility.hibernateUtility;

public class CURD {
	
	public void create() {
		
		Customer customer=new Customer();
		customer.setName("kanchan");
		customer.setMobile("7456985212");
	    customer.setAddress("pune");	
		
	   	
		
	    SessionFactory sf=hibernateUtility.getConnection();
	    Session session=sf.openSession();
	    
	    Transaction tx=session.beginTransaction();
	    
	    session.persist(customer);
	    
	    tx.commit();
	    
	    if (tx.wasCommitted()) {
			System.out.println("success");
		}else {
			tx.rollback();
			System.out.println("failure");
		}
	}
		
	
   public void updateRecords() {
	   
	    SessionFactory sf=hibernateUtility.getConnection();
	    Session session=sf.openSession();
	    Customer customer=(Customer) session.get(Customer.class, 10);
        customer.setAddress("pune");
        customer.setMobile("9874562145");
	    
	    Transaction tx=session.beginTransaction();
	    
	    session.update(customer);
	    
	    tx.commit();
	    
	    if (tx.wasCommitted()) {
			System.out.println("success");
		}else {
			tx.rollback();
			System.out.println("failure");
		}
	}
	   
	  
   public void readByIdUsingGet() {
	    
	    SessionFactory sf=hibernateUtility.getConnection();
	    Session session=sf.openSession();

	    Customer customer=(Customer) session.get(Customer.class, 10);
	    System.out.println(customer);
	   
   }
   public void readByIdUsingLoad() {
	   SessionFactory sf=hibernateUtility.getConnection();
	    Session session=sf.openSession();

	    Customer customer=(Customer) session.get(Customer.class, 10);
	    System.out.println(customer);
	   
   }
   public void deleteRecord() {
	   SessionFactory sf=hibernateUtility.getConnection();
	    Session session=sf.openSession();
	    
	    Transaction tx=session.beginTransaction();
	    
	    Customer customer=(Customer) session.get(Customer.class, 10);

	    if (customer != null) {
			session.delete(customer);
			tx.commit();
			if (tx.wasCommitted()) {
				System.out.println("success");
			} else {
				tx.rollback();
				System.out.println("failure");
			}
		} else {
			System.out.println("customer not found in db");
		}
	   
	   
	   
   }
   
   
   public static void main(String[] args) {
	   
	   CURD curd=new CURD();
	   //curd.create();
	   //curd.updateRecords();
	//  curd.readByIdUsingGet();
	   curd.readByIdUsingLoad();
	//curd.deleteRecord();
   }
}
