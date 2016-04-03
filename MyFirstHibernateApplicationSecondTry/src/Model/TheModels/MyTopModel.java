/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.TheModels;

/**
 *
 * @author didrik
 */
public class MyTopModel {
    
    private PersonModel personModel;
   
    public MyTopModel() {
        personModel = new PersonModel();
    }
    
    
    //Person get & set.
    public PersonModel getPersonModel() {
        return personModel;
    }
    
    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }
}
