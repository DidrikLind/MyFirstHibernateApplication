/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author didrik
 */

@Entity
@Table(name="Person")// not needed, since same name in database, but to get away magic!
public class Person implements Serializable {
    
    @Id
    @Column(name="id") // not needed, since same name in database, but to get away magic!
    private int id;
    @Column(name="f_name")
    private String fName;
    @Column(name="l_name")
    private String lName;
    @Column(name="age")
    private int age;
    
    public Person() {
       
    }
    
    public Person(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }
    
    public Person(int id, String fName, String lName, int age) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }
    
    //getters and setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getfName() {
        return fName;
    }
    
    public void setfName(String fName) {
        this.fName = fName;
    }
    
    public String getlName() {
        return lName;
    }
    
    public void setlName(String lName) {
        this.lName = lName;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return id + " , " + fName + " , " + lName + " , " + age;
    }
}
