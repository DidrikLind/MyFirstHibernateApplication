/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BeanDAOs;

import Model.Beans.Person;
import Model.HibernateUtilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author didrik
 */
public class PersonDAO {
    
    
    private Session activeSession; // active session, this is a light object.
    private Transaction activeTransaction;
    
//    public PersonDAO() {
//    
//    }
    
    public Session openActiveSession() {
        activeSession = HibernateUtil.getSessionFactory()
                                     .openSession();
        return activeSession;
    }
    
    public Session openActiveSessionWithTransaction() {
        activeSession = HibernateUtil.getSessionFactory()
                                     .openSession();
        activeTransaction = activeSession.beginTransaction();
        return activeSession;
    }
    
    public void closeActiveSession() {
        activeSession.close();
    }
    
    public void closeActiveSessionWithTransaction() {
        activeTransaction.commit();
        activeSession.close();
    }
    
    private static SessionFactory getSessionFactory() {
        //have done in another way!
        return null;
    }
    
    public Session getActiveSession() {
        return activeSession;
    }
    
    public void setActiveSession(Session activeSession) {
        this.activeSession = activeSession;
    }
    
    public Transaction getActiveTransaction() {
        return activeTransaction;
    }
    
    public void setActiveTransaction(Transaction activeTransaction) {
        this.activeTransaction = activeTransaction;
    }
    
    //crudish.
    public void add(Person p) {
        getActiveSession().save(p);
    }
    
    public void update(Person p) {
        getActiveSession().update(p);
    }
    
    public Person findById(int pkPersonId) {
        return (Person) getActiveSession().get(Person.class, pkPersonId);
    }
    
    public void delete(Person p) {
        getActiveSession().delete(p);
    }
    
    //TODO, fix a Table in sql "Person".
    public List<Person> getAllPersons() {
        return (List<Person>) getActiveSession().createQuery("from Person")
                                                .list();
    }
    
    
    
    
    
}
