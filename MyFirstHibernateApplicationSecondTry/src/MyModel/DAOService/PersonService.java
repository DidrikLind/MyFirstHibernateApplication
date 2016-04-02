/*
http://programmers.stackexchange.com/questions/220909/service-layer-vs-dao-why-both
down vote
I am the writer of post in question. I have got my fair share of working 
on different technologies and different architectures. Based on above, 
I can safely say that having service layer and dao layer is always a good idea. 
DAO should be limited to only add/update/insert/select Entity objects into/from 
database and that's all. If you want to do anything extra in terms of logic, 
add it to service layer. This will help in making code modular and easily replaceable 
when database is replaced (for some part of data). This is specially applicable in applications 
involving reports which have heavy logics even after fetching data from database.

Also, in spring, security is applied at service layer ideally. You would not like to change this way.
 */
package MyModel.DAOService;

import MyModel.BeanDAOs.PersonDAO;
import MyModel.Beans.Person;
import java.util.List;

/**
 *
 * @author didrik
 */
public class PersonService {
    private static PersonDAO personDAO;
    
    public PersonService() {
        // so every instance of PersonService always has the same instance of PersonManager.
        personDAO = new PersonDAO(); 
    }
    
    public void add(Person p) {
        personDAO.openActiveSessionWithTransaction();
        personDAO.add(p);
        personDAO.closeActiveSessionWithTransaction();
    }
    
    public void update(Person p) {
        personDAO.openActiveSessionWithTransaction();
        personDAO.update(p);
        personDAO.closeActiveSessionWithTransaction();
    }
    
    public Person findById(int pkPersonId) {
        personDAO.openActiveSession();
        Person p = personDAO.findById(pkPersonId);
        personDAO.closeActiveSession();
        return p;
    }
    
    public void delete(int pkPersonId) {
        personDAO.openActiveSessionWithTransaction();
        personDAO.delete(findById(pkPersonId));
        personDAO.closeActiveSessionWithTransaction();
    }
    
    public List<Person> getAllPersons() {
        personDAO.openActiveSession();
        List<Person> p = personDAO.getAllPersons();
        personDAO.closeActiveSession();
        return p;
    }
}
