package football;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class leagueTest {

	@Test
	public void testAddteamtoleague() {
		 team t1= new team("oussa",12,6,20,300);
			team t2= new team("lili",20,12,30,2000);
			team t3= new team("lili",9,3,25,4100);
			ArrayList<team> teams = new ArrayList<team>();
			
			
			
		league l=new league("spain",1930,3,teams) ;
		  l.addteamtoleague(t1);
		  l.addteamtoleague(t2);
		  l.addteamtoleague(t3);
		 
		    assertEquals(t1, l.getteams().get(0));
		    assertEquals(t2,  l.getteams().get(1));
		    assertEquals(t3,  l.getteams().get(2));
		   

		    assertEquals("second attempt", t1, l.getteams().get(0));   // make sure I can get them a second time
		    assertEquals("second attempt", t3, l.getteams().get(2));
	}

	@Test
	public void testDeleteteam() {
		 
		 team t1= new team("oussa",12,6,20,300);
			team t2= new team("lili",20,12,30,2000);
			team t3= new team("lili",9,3,25,4100);
			ArrayList<team> teams = new ArrayList<team>();
			
			
			
		league l=new league("spain",1930,0,teams) ;
		  l.addteamtoleague(t1);
		  l.addteamtoleague(t2);
		  l.addteamtoleague(t3);
		  
		  assertEquals(l.numberofteams, l.getteams().size());
		    l.deleteteam(t3);
		   
		    l.deleteteam(t2);
		    assertEquals(l.numberofteams, l.getteams().size()) ;
		  
		   
		    assertEquals(l.numberofteams, l.getteams().size()) ;// make sure I can get them a second time
		    
		
	}

	@Test
	public void testRankteamsbasedonpoints() {
		 team t1= new team("oussa",12,6,20,300);
			team t2= new team("lili",20,12,30,2000);
			team t3= new team("lili",9,3,25,4100);
			ArrayList<team> teams = new ArrayList<team>();
			
			
			
		league l=new league("spain",1930,3,teams) ;
		  l.addteamtoleague(t1);
		  l.addteamtoleague(t2);
		  l.addteamtoleague(t3);
		  l.rankteamsbasedonpoints();
		  assertEquals(t2, l.getteams().get(0));
		   
		    assertEquals(t1, l.getteams().get(1)) ;
		  
		   
		    assertEquals(t3, l.getteams().get(2)) ;
		  
	}

	@Test
	public void testRankteamsbasedonvotes() {
		 team t1= new team("oussa",12,6,20,300);
			team t2= new team("lili",20,12,30,2000);
			team t3= new team("lili",9,3,25,4100);
			ArrayList<team> teams = new ArrayList<team>();
			
			
			
		league l=new league("spain",1930,3,teams) ;
		  l.addteamtoleague(t1);
		  l.addteamtoleague(t2);
		  l.addteamtoleague(t3);
		  l.rankteamsbasedonvotes();
		  assertEquals(t2, l.getteams().get(0));
		   
		    assertEquals(t3, l.getteams().get(1)) ;
		  
		   
		    assertEquals(t1, l.getteams().get(2)) ;
		  
	}

}
