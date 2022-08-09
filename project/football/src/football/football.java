package football;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class football extends JFrame implements ActionListener  {
  
	JButton admin = new JButton("Admin");
    JButton user = new JButton("USER");
    
    JFrame frame = new JFrame("Login interface");
   
	football() {
		
	     // Setting the width and height of frame
	     frame.setSize(500, 200);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	     JPanel panel = new JPanel();    
	     frame.add(panel);
	    
	     panel.setLayout(null);

	  
	    
	    admin.setBounds(80, 60, 130, 25);
	    admin.addActionListener(this);
	    panel.add(admin);
	
	    user.setBounds(250, 60, 130, 25);
	   user.addActionListener(this);
	    panel.add(user);
	 
	    frame.setVisible(true); 
	   
	}
	
	@Override
	 
	public void actionPerformed(ActionEvent e) {
		
	
		if (e.getSource()==admin) {
			
			 frame.setVisible(false); 
			new frameadmin();
		}
		
if (e.getSource()==user) {
	 frame.setVisible(false); 
	 new Myframe();
		}
	
	}

public static void main(String args[])   {  
	 
	
	
	
	new football() ;
	
	
}
	
}

/*
 * 	team t1= new team("oussa",12,6,20,300);
	team t2= new team("lili",20,12,30,2000);
	team t3= new team("lili",9,3,25,4100);
	
	
	ArrayList<team> teams = new ArrayList<team>();
	teams.add(t1);
	teams.add(t3);
	
	
	league l1=new league("spain",12,3,teams) ;
	
	
	
    File f = new File("leagueteams.txt");
     try
    {
    	  FileOutputStream fos = new FileOutputStream(f);
          ObjectOutputStream oos = new ObjectOutputStream(fos);
          oos.writeObject(l1.name) ;
          oos.writeObject(l1.yearoffoundation)  ;
          
          oos.writeObject(l1.numberofteams)  ;
          oos.writeObject(l1.getteams());
    }
 catch (FileNotFoundException  ex) {
         
     }
     catch(IOException e){
     } 
    
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
}
	
 */
	
	
	/*team t1= new team("oussa",12,6,20,300);
	team t2= new team("lili",20,12,30,2000);
	team t3= new team("lili",9,3,25,4100);
	
	
	ArrayList<team> teams = new ArrayList<team>();
	teams.add(t1);
	teams.add(t3);
	
	
	league l1=new league("spain",12,3,teams) ;
	l1.addteamtoleague(t2);
	
	l1.displayleague();
	l1.rankteams();
	l1.displayleague();
	l1.displaywinnerteam(); 

	

} */
