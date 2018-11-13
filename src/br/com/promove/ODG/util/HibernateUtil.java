package br.com.promove.ODG.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf;

	static {
		if(sf == null || !sf.isOpen())
			sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public static Session getSession() {
		return sf.openSession();
	}

}
