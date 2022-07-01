package com.app.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class hibernateUtility {
	
	public static SessionFactory getConnection() {
		
		Configuration cfg=new Configuration();
		cfg.configure();
		
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		builder.applySettings(cfg.getProperties());
		
		
		
		return cfg.buildSessionFactory(builder.build());
		
	}

}
