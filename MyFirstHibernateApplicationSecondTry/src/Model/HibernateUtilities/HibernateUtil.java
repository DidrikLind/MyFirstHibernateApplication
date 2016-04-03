/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.HibernateUtilities;

import Model.Beans.Person;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author didrik
 */
public class HibernateUtil {
    
    private static final SessionFactory factory;
    
    static {
        factory = new Configuration().configure("hibernate.cfg.xml") // could name cfg.xml prefix differently!
                                     .addAnnotatedClass(Person.class)
                                     .buildSessionFactory();
    }
        
    public static SessionFactory getSessionFactory() {
        return factory;
    }  
}
