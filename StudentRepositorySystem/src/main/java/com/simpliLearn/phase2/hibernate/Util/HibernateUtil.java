package com.simpliLearn.phase2.hibernate.Util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.simpliLearn.phase2.hibernate.model.Admin;


/**
 * Java based configuration
 * @author Chaithra B
 *
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
    	System.out.println("HibernateUtil: getSessionFactory");
        if (sessionFactory == null) {
            try {
            	System.out.println("HibernateUtil: getSessionFactory sessionFactory null");
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
            	System.out.println("HibernateUtil: getSessionFactory settings DRIVER");
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            	System.out.println("HibernateUtil: getSessionFactory settings URL");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/student_repo");
            	System.out.println("HibernateUtil: getSessionFactory settings USER");
                settings.put(Environment.USER, "root");
            	System.out.println("HibernateUtil: getSessionFactory settings PASS");
                settings.put(Environment.PASS, "password");
            	System.out.println("HibernateUtil: getSessionFactory settings DIALECT");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            	System.out.println("HibernateUtil: getSessionFactory settings SHOW_SQL");

                settings.put(Environment.SHOW_SQL, "true");
            	System.out.println("HibernateUtil: getSessionFactory settings CURRENT_SESSION_CONTEXT_CLASS");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            	System.out.println("HibernateUtil: getSessionFactory settings HBM2DDL_AUTO");

                settings.put(Environment.HBM2DDL_AUTO, "update");
                
            	System.out.println("HibernateUtil: getSessionFactory set properties");

                configuration.setProperties(settings);
            	System.out.println("HibernateUtil: getSessionFactory addAnnotatedClass");
                configuration.addAnnotatedClass(Admin.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}