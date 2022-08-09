package football;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class league implements Serializable{
	
	String name ;
	int yearoffoundation ;
	int numberofteams ;
	ArrayList<team> teams ;

	public 
	league(String ch,int a,int b, ArrayList<team> h) {
		name=ch ;
		yearoffoundation=a ;
		numberofteams=b;
		teams=h ;
	}
	
	league() { }
	void addteamtoleague(team h) {
		numberofteams++;
		teams.add(h );
	}
	
	ArrayList<team> getteams() {
		return this.teams;
	}
	
	void deleteteam(team h) {
		numberofteams--;
		teams.remove(h);
	}
	
	
	Comparator<team> cmp = new Comparator<team>() {
	public int compare(team o1, team o2) {
		// TODO Auto-generated method stub
		if (o1.getpoints()<o2.getpoints()) {
			return 1;
		}
		else return -1 ;
	}
	} ;
	
	Comparator<team> cmp1 = new Comparator<team>() {
		public int compare(team o1, team o2) {
			// TODO Auto-generated method stub
			if (o1.getvotes()<o2.getvotes()) {
				return 1;
			}
			else return -1 ;
		}
		} ;
			
	void rankteamsbasedonpoints() {
		Collections.sort(teams, cmp) ;
			
	}
	
	void rankteamsbasedonvotes() {
		Collections.sort(teams, cmp1) ;
	}
	void displayleague() {
		System.out.printf("name:%s ",name);
		System.out.printf("yearoffoundation:%d ",yearoffoundation);
		System.out.printf("numberofteams:%d ",numberofteams);
		System.out.println();
		for (team i : teams) {
		      i.displayteam();
		      System.out.println();
		    }
		
	}
	
	void displaywinnerteam() {
		Collections.sort(teams, cmp1) ;
		(teams.get(0)).displayteam();
	}
	
	
}
