/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirsthibernateapplicationsecondtry;

import Controller.MyController;
import MyModel.TheModels.TopModel;

/**
 *
 * @author didrik
 */
public class MyFirstHibernateApplicationSecondTry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MyView view = new MyView();
        TopModel model = new TopModel();
        MyController cont = new MyController(view, model);
        
        view.setVisible(true);
    }
    
}
