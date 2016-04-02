/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyModel.TheModels;

/**
 *
 * @author didrik
 */
public class TopModel {
    
    private PersonModel personModel;
   
    public TopModel() {
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
