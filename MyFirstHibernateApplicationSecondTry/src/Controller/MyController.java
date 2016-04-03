/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TheModels.MyTopModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import View.MyView;

/**
 *
 * @author didrik
 */
public class MyController {
    
    private MyView view;
    private MyTopModel topModel;
    
    //TODO, model reference somehow here asewll.
    
    public MyController() {
        
    }
    
    public MyController(MyView view, MyTopModel topModel) {
        this.view = view;
        this.topModel = topModel;
        
        view.addCRUDButtonListener(new CRUDButtonListener());
        view.addTheTableListener(new TheTableListener());
    }
    
    private class CRUDButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            JButton bObj = (JButton) ae.getSource();
            JTextField[] tObj = view.getTextFields();
            if(bObj.getText().equals("ADD")) {
                //System.out.println("HEllo add me ;)");
                topModel.getPersonModel().addPerson(tObj[1].getText(),
                                                    tObj[2].getText(),
                                                    Integer.parseInt(tObj[3].getText())); 
            }else if(bObj.getText().equals("UPDATE")) {
                //System.out.println("HEllo update me ;)");
                topModel.getPersonModel().updatePerson(Integer.parseInt(tObj[0].getText()),
                                                       tObj[1].getText(),
                                                       tObj[2].getText(),
                                                       Integer.parseInt(tObj[3].getText()));
            }else if(bObj.getText().equals("DELETE")) {
                //System.out.println("HEllo delete me ;)");
                topModel.getPersonModel().deletePerson(Integer.parseInt(tObj[0].getText()));
            }else {
                //refresh
                System.out.println("HEllo refresh me ;)");
                for(int i=0; i<tObj.length; i++)
                    tObj[i].setText("");                
            }
            view.clearMainTable();
            view.getMainTable().setModel(topModel.getPersonModel()
                                                 .getPersonTable());
        }
    }
    
    private class TheTableListener extends MouseAdapter {
        
        private JTable table;
        private JTextField[] txtFields;
        
        @Override
        public void mouseClicked(MouseEvent mevt) {
            table = view.getMainTable();
            txtFields = view.getTextFields();
            //changfe data in JTextFields to clicked row.
            if(table.getSelectedRow()!=-1) {
                for(int i=0; i<txtFields.length; i++) {      
                    try {
                        txtFields[i].setText(table.getValueAt(table.getSelectedRow(),i).toString());
                    }
                    catch(NullPointerException npe) {
                        txtFields[i].setText("");
                    }                    
                }   
            }	
        }
    }
    
    

}
