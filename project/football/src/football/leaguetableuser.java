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
public class leaguetableuser extends JFrame {

	 File f = new File("leagueteams.txt");
	  JTextField JT_Money,JT_nameofteam;

	    JButton btn_vote,btn_money,btn_rankbypoints,btn_rankbyvotes;

	    JTable table = new JTable();

	    JScrollPane pane;

	   Object[] cols = null;
/** 
* @author 1bestcsharp.blogspot.com
* @throws ClassNotFoundException 
*/ 
leaguetableuser() {   

		JT_Money = new JTextField(20);
		JT_nameofteam=new JTextField(20);
		

		   JT_Money.setBounds(130,20,150,20);
		   JT_nameofteam.setBounds(130,50,150,20);
		   
		   JLabel userLabel = new JLabel("Donate money");
		   userLabel.setBounds(27,20,150,15);
		   add(userLabel);
		   JLabel userLab = new JLabel("Name of the team");
		   userLab.setBounds(27,50,150,15);
		   add(userLab);
		   
		   
		   
		   
		     btn_money = new JButton("Donate Money");
		     btn_money.setBounds(300, 20, 200, 20);
		     
		     btn_vote = new JButton("Vote");
		     btn_vote.setBounds(300, 40, 200, 20);

		     btn_rankbypoints = new JButton("Rankbypoints");
		     btn_rankbypoints.setBounds(50,80,150,40);
		     
		     btn_rankbyvotes = new JButton("Rankbyvotes");
		     btn_rankbyvotes.setBounds(300,80,150,40);

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
		//vote for your team
		       btn_vote.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	 
                  
                   String ous=JT_nameofteam.getText();
                   int i=0;
		        	 for(i=0;i<h.size();i++)
			            {
			                if (h.get(i).getname().equals(ous)) {
			                	h.get(i).numberofvotes++;
			                	
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
		        		 new leaguetableuser();
		        	 }
    	         }
             });
		       
		     //vote for your team
		       btn_money.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	 
                  
                   String ous=JT_nameofteam.getText();
                   int op=Integer.valueOf( JT_Money.getText());
                   int i=0;
		        	 for(i=0;i<h.size();i++)
			            {
			                if (h.get(i).getname().equals(ous)) {
			                	h.get(i).money=h.get(i).money+op;
			                	
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
		        		 new leaguetableuser();
		        	 }
    	         }
             });

		       //rankbyvotes for your team
		       btn_rankbyvotes.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	 
                  l.rankteamsbasedonvotes();
                  
                   try
		        		 {
          			    	  FileOutputStream fos = new FileOutputStream(f);
          			          ObjectOutputStream oos = new ObjectOutputStream(fos);
          			          oos.writeObject(l.name) ;
          			          oos.writeObject(l.yearoffoundation)  ;
          			          
          			          oos.writeObject(l.numberofteams)  ;
          			          oos.writeObject(l.getteams());
          			    }
          			 catch (FileNotFoundException  ex) {
          			         
          			     }
          			     catch(IOException osd){
          			     } 
		        		 setVisible(false);
		        		 new leaguetableuser();
		        	 }
    	         
             });
		       //rankbypoints for your team
		       btn_rankbypoints.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	 
                  l.rankteamsbasedonpoints();
                   
		        	
		        		 try
		        		 {
          			    	  FileOutputStream fos = new FileOutputStream(f);
          			          ObjectOutputStream oos = new ObjectOutputStream(fos);
          			          oos.writeObject(l.name) ;
          			          oos.writeObject(l.yearoffoundation)  ;
          			          
          			          oos.writeObject(l.numberofteams)  ;
          			          oos.writeObject(l.getteams());
          			    }
          			 catch (FileNotFoundException  ex) {
          			         
          			     }
          			     catch(IOException osd){
          			     } 
		        		 setVisible(false);
		        		 new leaguetableuser();
		        	 }
    	         
             });
		       
		     pane = new JScrollPane(table);
		     pane.setBounds(0,150,500,300);
		     setLayout(null);
		  
		     add(pane);
		     add(JT_Money);
		     add(JT_nameofteam);
		     
		     add(btn_money);
		     add(btn_vote);
		     add(btn_rankbypoints);
		     add(btn_rankbyvotes);

		     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     setVisible(true);
		     Color x = Color.decode("#bdb76b");
		     getContentPane().setBackground(x);
		     setLocationRelativeTo(null);
		     setSize(500,500); 
		    
		 }
		   public static void main(String[] args){
		     //  new  leaguetableuser();
		   }
		
	
	
	
	

}
