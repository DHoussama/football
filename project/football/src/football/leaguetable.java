package football;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.System.Logger;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class leaguetable extends JFrame {
    File f = new File("leagueteams.txt");

	  JTextField JT_NameofTeam,JT_Numberofpoints,JT_numberofvotes,JT_money,JT_yearoffoundation;

	    JButton btn_add,btn_update,btn_delete;

	    JTable table = new JTable();

	    JScrollPane pane;

	   Object[] cols = null;
/** 
 * @author 1bestcsharp.blogspot.com
 * @throws ClassNotFoundException 
 */ 
leaguetable() {   

		JT_NameofTeam = new JTextField(20);
		JT_Numberofpoints = new JTextField(20);
		JT_yearoffoundation =  new JTextField(20) ;
		JT_numberofvotes = new JTextField(20);
		JT_money = new JTextField(20);

		   JT_NameofTeam.setBounds(130,20,150,20);
		   JT_Numberofpoints.setBounds(130, 40, 150, 20);
		   JT_yearoffoundation.setBounds(130,60,150,20) ;
		   JT_numberofvotes.setBounds(130, 80, 150, 20);
		   JT_money.setBounds(130, 100, 150, 20);
		   JLabel userLabel = new JLabel("Name");
		   userLabel.setBounds(30,20,150,15);
		   add(userLabel);
		   JLabel user = new JLabel("Yearoffoundation");
		   user.setBounds(30,40,150,15);
		   add(user);
		   JLabel use = new JLabel("Numberofpoints");
		   use.setBounds(30,60,150,15);
		   add(use);
		   JLabel userL = new JLabel("votes");
		   userL.setBounds(30,80,150,15);
		   add(userL);
		   JLabel money = new JLabel("Money");
		   money.setBounds(30,100,150,15);
		   add(money);
		   
		   
		   
		   
		     btn_add = new JButton("ADD");
		     btn_add.setBounds(300, 30, 100, 20);

		     btn_delete = new JButton("DELETE");
		     btn_delete.setBounds(300,60,100,20);
		     
		     btn_update = new JButton("UPDATE");
		     btn_update.setBounds(300,90,100,20);

		       cols = new String[]{"Name","Yearoffoundation","Points","Votes","Money"};
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            model.setColumnIdentifiers(cols);
		      
		            ArrayList<team> t = new ArrayList<team>();
		            String a="";
		            int b=0;
		            int c=0;
		           
		             try
		            {
		                FileInputStream fis = new FileInputStream(f);
		                ObjectInputStream ois = new ObjectInputStream(fis);
		                a = (String)ois.readObject(); 
		                b = (Integer)ois.readObject(); 
		                c = (Integer)ois.readObject(); 
		                t = (ArrayList)ois.readObject();  
		                ois.close();
		                fis.close();
		            } 
		            catch(IOException e){
		            } 
		             catch (ClassNotFoundException ex) {
		                 
		             }
		             league l=new league(a,b,c,t) ;
		             l.displayleague();
		            
		            for(int i=0;i<l.getteams().size();i++)
		            {
		                String rowData[] = {(l.getteams().get(i).getname()) ,Integer.toString(l.getteams().get(i).getyearoffoundation()), Integer.toString(l.getteams().get(i).getpoints()) ,Integer.toString(l.getteams().get(i).getvotes()),Integer.toString(l.getteams().get(i).getmoney()) ,};
		                model.addRow(rowData);
		            }
		           ArrayList<team> h=t;
		//Add A Row To JTable From JTextfields
		       btn_add.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	 l.numberofteams++ ;
                    
                     String ous=JT_NameofTeam.getText();
                     int op=Integer.valueOf( JT_yearoffoundation.getText());
                     int os=Integer.valueOf(JT_Numberofpoints.getText());
            		 int om=Integer.valueOf(JT_numberofvotes.getText());
            			int ol=	 Integer.valueOf(JT_money.getText()) ;
            			 team s=new team (ous,op,os,om,ol) ;
            			 h.add(s) ;
            			 try
            			    {
            			    	  FileOutputStream fos = new FileOutputStream(f);
            			          ObjectOutputStream oos = new ObjectOutputStream(fos);
            			          oos.writeObject(l.name) ;
            			          oos.writeObject(l.yearoffoundation)  ;
            			          
            			          oos.writeObject(l.numberofteams)  ;
            			          oos.writeObject(h);
            			    }
            			 catch (FileNotFoundException  ex) {
            			         
            			     }
            			     catch(IOException osd){
            			     } 
            			    
            			 
		              model.addRow(new Object[]{
		            		  JT_NameofTeam.getText(), JT_yearoffoundation.getText(),JT_Numberofpoints.getText(),
		            		  JT_numberofvotes.getText(),JT_money.getText()
		                                       });
		                  }
		             });
		       
		     //delete A Row To JTable From JTextfields
		      table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		       btn_delete.addActionListener(new ActionListener() {
			         @Override
			         public void actionPerformed(ActionEvent e) {
			        	 String am=JT_NameofTeam.getText();
			        	int i=0;
			        	 for(i=0;i<h.size();i++)
				            {
				                if (h.get(i).getname().equals(am)) {
				                	h.remove(i);
				                	l.numberofteams--;
				                	 break ;
				                }
				               
				                
				            }
			        	 if (i==h.size()) {
			        		 JOptionPane.showMessageDialog(null, "There is no team with this name");
			        	 }
			        	 else {
			        		 try
	            			    {
	            			    	  FileOutputStream fos = new FileOutputStream(f);
	            			          ObjectOutputStream oos = new ObjectOutputStream(fos);
	            			          oos.writeObject(l.name) ;
	            			          oos.writeObject(l.yearoffoundation)  ;
	            			          
	            			          oos.writeObject(l.numberofteams)  ;
	            			          oos.writeObject(h);
	            			    }
	            			 catch (FileNotFoundException  ex) {
	            			         
	            			     }
	            			     catch(IOException osd){
	            			     } 
			        		 setVisible(false);
			        		 new leaguetable();
			        	 }
	            	         }
			             });
			       
		       // Get Selected Row Values From JTable Into JTextfields
		          table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
		          @Override
		          public void valueChanged(ListSelectionEvent e) {
		          
		                int i = table.getSelectedRow();
		                JT_NameofTeam.setText((String)model.getValueAt(i, 0));
		                JT_yearoffoundation.setText((String)model.getValueAt(i, 1));
		                JT_Numberofpoints.setText((String)model.getValueAt(i, 2));
		                JT_numberofvotes.setText((String)model.getValueAt(i, 3));
		                JT_money.setText((String)model.getValueAt(i, 4));
		            }
		        });
		       
		// Update A  JTable Row Using JTextfield
		      btn_update.addActionListener(new ActionListener(){
		      
		      @Override
		      public void actionPerformed(ActionEvent e){
		          
		          int i = table.getSelectedRow();
		          model.setValueAt(JT_NameofTeam.getText(), i, 0);
		          model.setValueAt(JT_yearoffoundation.getText(), i, 1);
		          model.setValueAt(JT_Numberofpoints.getText(), i, 2);
		          model.setValueAt(JT_numberofvotes.getText(), i, 3);
		          model.setValueAt(JT_money.getText(), i, 4);
		          if (JT_NameofTeam.getText()!="") {
		          h.get(i).name=JT_NameofTeam.getText();
		          }
		          if (JT_yearoffoundation.getText()!="") {
		          h.get(i).yearoffoundation=Integer.valueOf(JT_yearoffoundation.getText()); }
		          if (JT_Numberofpoints.getText()!="") {
		          h.get(i).points=Integer.valueOf(JT_Numberofpoints.getText());}
		          if (JT_numberofvotes.getText()!="") {
		          h.get(i).numberofvotes=Integer.valueOf(JT_numberofvotes.getText());}
		          if (JT_money.getText()!="") {
		         h.get(i).money=Integer.valueOf(JT_money.getText()); }
		       try
  			    {
  			    	  FileOutputStream fos = new FileOutputStream(f);
  			          ObjectOutputStream oos = new ObjectOutputStream(fos);
  			          oos.writeObject(l.name) ;
  			          oos.writeObject(l.yearoffoundation)  ;
  			          
  			          oos.writeObject(l.numberofteams)  ;
  			          oos.writeObject(h);
  			    }
  			 catch (FileNotFoundException  ex) {
  			         
  			     }
  			     catch(IOException osd){
  			     } 
		          
		      }
		      });    
		       
		     pane = new JScrollPane(table);
		     pane.setBounds(0,150,500,300);
		     setLayout(null);
		  
		     add(pane);
		     add(JT_NameofTeam);
		     add(JT_Numberofpoints);
		     add(JT_yearoffoundation) ;
		     add(JT_numberofvotes);
		     add(JT_money);
		     add(btn_add);
		     add(btn_update);
		     add(btn_delete);

		     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     setVisible(true);
		     Color x = Color.decode("#bdb76b");
		     getContentPane().setBackground(x);
		     setLocationRelativeTo(null);
		     setSize(500,500);
		    
		 }
		   public static void main(String[] args){
		       //new  leaguetable();
		   }
		
}