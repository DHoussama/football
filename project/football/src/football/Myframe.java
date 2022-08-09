package football;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Myframe extends JFrame implements ActionListener {
	String x="ousa";
	 String y;
	  JButton loginButton = new JButton("login");
	     JButton resetpasswordButton = new JButton("reset password");
	     JButton registerButton = new JButton("register "); 
	     JButton registerButton2 = new JButton("register "); 
	     JFrame frame = new JFrame("Login interface");
	     JTextField userText = new JTextField(20);
	     JLabel passwordLabel = new JLabel("Password");
	     JPasswordField passwordText = new JPasswordField(20);
	     
	Myframe() {
		
	     // Setting the width and height of frame
	     frame.setSize(500, 200);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	     JPanel panel = new JPanel();    
	     frame.add(panel);
	    
	     panel.setLayout(null);


	    JLabel userLabel = new JLabel("User");
	    
	    userLabel.setBounds(40,20,80,25);
	    panel.add(userLabel);
	  
	   
	  
	    userText.setBounds(140,20,165,25);
	    panel.add(userText);

	    
	   
	    passwordLabel.setBounds(40,50,80,25);
	    panel.add(passwordLabel);



	
	    passwordText.setBounds(140,50,165,25);
	    panel.add(passwordText);
	  
	    
	    loginButton.setBounds(10, 80, 130, 25);
	    loginButton.addActionListener(this);
	    panel.add(loginButton);
	
	    resetpasswordButton.setBounds(150, 80, 130, 25);
	    resetpasswordButton.addActionListener(this);
	    panel.add(resetpasswordButton);
	  
	    registerButton.setBounds(290, 80, 130, 25);
	    registerButton.addActionListener(this);
	    panel.add(registerButton); 
	    frame.setVisible(true); 
	   
		
	}
	   JTextField userText1 = new JTextField(20);
	   JPasswordField passwordText1 = new JPasswordField(20);
	@Override
 
	public void actionPerformed(ActionEvent e) {
		JLabel messageLabel = new JLabel();
		JFrame frame1 = new JFrame("registration interface");
		JPanel panel = new JPanel(); 
	
		if (e.getSource()==registerButton) {
			
			 frame.setVisible(false); 
		     // Setting the width and height of frame
		     frame1.setSize(500, 200);
		     frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		     
		     frame1.add(panel);
		    
		     panel.setLayout(null);


		    JLabel userLabel = new JLabel("User");
		    
		    userLabel.setBounds(40,20,80,25);
		    panel.add(userLabel);
		   
		   
		   
		    userText1.setBounds(140,20,165,25);
		    panel.add(userText1);
		    x=userText1.getText();
		    System.out.println(x);
		    
		    JLabel passwordLabel = new JLabel("Password");
		    passwordLabel.setBounds(40,50,80,25);
		    panel.add(passwordLabel);



		   
		    passwordText1.setBounds(140,50,165,25);
		    panel.add(passwordText1);
		  
		  
		
		 
		  registerButton2.setBounds(10, 80, 130, 25);
			registerButton2.addActionListener(this);
			    panel.add(registerButton2);
			 
				
				

		    frame1.setVisible(true); 
		
				  
				    
				 
			}
		
		   if (e.getSource()==registerButton2) {
			   frame1.setVisible(false);
			    frame1.setSize(500, 200);
			    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    frame1.add(panel);
			    panel.setLayout(null);
		        frame1.add(messageLabel);
		        messageLabel.setText("account created successfully please quit and sign in");
				frame1.dispose();	 
				frame1.setVisible(true); 		
			        x=userText1.getText();
						 y=String.valueOf(passwordText1.getPassword())  ;
						 userlogins userlogin =new userlogins() ;
				 userlogin.addtouserlogins(x, y);
				userlogin.method2(userlogin.getmap());
		    
		}
		
		
		   if (e.getSource()==resetpasswordButton) {
			   x=userText.getText();
			   userlogins userlogin =new userlogins() ;
			   
			 int s=0;
			   for (String i : userlogin.getmap().keySet()) {
				  if (i.equals(x)) {
					  s=1;
					   
				       // messageLabel.setText("Your password is " + userlogin.getmap().get(i) );
				        JOptionPane.showMessageDialog(null, "Your Password is " + userlogin.getmap().get(i));
							
					   break ;
				   }
			   }
				  if (s==0) {
					  JOptionPane.showMessageDialog(null, "There is no account with this name please register!");
				  }
					   
				   
				   
				 }
			   
			   
		   
		   
		   if (e.getSource()==loginButton) {
			   x=userText.getText();
			   y=String.valueOf(passwordText.getPassword())  ;
			   userlogins userlogin =new userlogins() ;
			   int s=0;
			   for (String i : userlogin.getmap().keySet()) {
					  if (i.equals(x)) {
						  s=1;
						  if (y.equals(userlogin.getmap().get(i)) ) {
							  frame.setVisible(false);
						 new leaguetableuser() ;
					   }
						  else {
							  JOptionPane.showMessageDialog(null, "Wrong password ! You can reset it using reset password");
						  }
							  
						  
						  }
					  
						  }
					  if (s==0) {
						  JOptionPane.showMessageDialog(null, "There is no account with this name please register!");
					  }
						   
			    
			   
		   }
		
	}
	

		
		
		
	}


