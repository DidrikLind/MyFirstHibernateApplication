/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MyModel.TheModels.TopModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import myfirsthibernateapplicationsecondtry.MyView;

/**
 *
 * @author didrik
 */
public class MyController {
    
    private MyView view;
    private TopModel topModel;
    
    //TODO, model reference somehow here asewll.
    
    public MyController() {
        
    }
    
    public MyController(MyView view, TopModel topModel) {
        this.view = view;
        this.topModel = topModel;
        
        view.addTxtFieldListener(new TxtFieldListener());
        view.addCRUDButtonListener(new CRUDButtonListener());
        view.addTheTableListener(new TheTableListener());
    }
    /** @TODO might not need this, lets see what time tells us. */
    private class TxtFieldListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JTextField tObj = (JTextField) ae.getSource();

        }        
    }
    
    /** @TODO make it work with the future model! */
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
                
//                view.resetMainTable();
                view.getMainTable().setModel(topModel.getPersonModel()
                                                     .getPersonTable());                
            }
            
            view.getMainTable().revalidate();
            view.getMainTable().repaint();
        }
    }
    
    private class TheTableListener extends MouseAdapter {
        
        private JTable table;
        private JTextField[] txtFields;
        
        @Override
        public void mouseClicked(MouseEvent mevt) {
            table = view.getMainTable();
            txtFields = view.getTextFields();
            String text;
            //changfe data in JTextFields to clicked row.
            if(table.getSelectedRow()!=-1) {
                //weird problem fix l8r
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
