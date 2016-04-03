/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.TheModels;

import Model.Beans.Person;
import Model.DAOService.PersonService;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author didrik
 */
public class PersonModel {
    
    private PersonService personService;
    private DefaultTableModel dm;
    
    public PersonModel() {
        personService = new PersonService();
        
        //Customize table.
        dm = new DefaultTableModel();
        String[] colonTitles = new String[]{"Data ID","First name","Last name","Age"};       
        for(int i=0; i<colonTitles.length;i++)
            dm.addColumn(colonTitles[i]);
    }
    
    public void addPerson(String fName, String lName, int age) {
        personService.add(new Person(fName, lName, age));
    }
    
    public void updatePerson(int id, String fName, String lName, int age) {
        //personService.update(new Person(id, fName, lName, age));
        Person p = personService.findById(id);
        if(!fName.equals(p.getfName()))
            p.setfName(fName);
        if(!lName.equals(p.getlName()))
            p.setlName(lName);
        if(age!=p.getAge())
            p.setAge(age);
        personService.update(p);
    }
    
    public void deletePerson(int id) {
        personService.delete(id);
    }
    
    public DefaultTableModel getPersonTable() {
        //TODO, return DefaultTableModel.
        Object[] rowData = null;
        List<Person> classList = personService.getAllPersons();

        rowData = new Object[4];
        for(int i=0; i<classList.size(); i++) {
            rowData[0] = classList.get(i).getId(); 
            rowData[1] = classList.get(i).getfName();
            rowData[2] = classList.get(i).getlName();
            rowData[3] = classList.get(i).getAge();
            dm.insertRow(i, rowData);
        }
        return dm;
    }
}
