/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirsthibernateapplicationsecondtry;

import View.MyView;
import Controller.MyController;
import Model.TheModels.MyTopModel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author didrik
 */
public class MyFirstHibernateApplicationSecondTry {

    
    public MyFirstHibernateApplicationSecondTry() {
        MyView view = new MyView();
        MyTopModel model = new MyTopModel();
        MyController cont = new MyController(view, model);
        
        view.setLocationRelativeTo(null);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setResizable(false);
        view.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(() -> { 
            new MyFirstHibernateApplicationSecondTry();
        });
    }
    
}
