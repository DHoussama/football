package football;

import java.io.Serializable;

public class team implements Serializable{
	
	String name ;
	int yearoffoundation;
	int points ;
	int numberofvotes ;
	int money ;
	public 
	
	team(String ch,int a,int b) {
		name=ch ;
		yearoffoundation=a ;
		points=b ;
		numberofvotes=0;
		money=0;
	}
	
	team(String ch,Integer a,Integer b,Integer c ,Integer d) {
		name=ch ;
		yearoffoundation=a ;
		points=b ;
		numberofvotes=c;
		money=d;
	}
	
	String getname() {
		
		return name;
	}
   int getyearoffoundation() {
		
		return yearoffoundation;
	}
   int getmoney() {
		
		return money;
	}
	int getpoints() {
		
		return points;
	}
	int getvotes() {
		
		return numberofvotes;
	}
	void winthematch() {
		points=points+3;
	}
	void matchdraw() {
		points=points+1 ;
	}
	
	void displayteam()  {
		System.out.printf("name:%s ",name);
		System.out.printf("yearoffoundation:%d ",yearoffoundation);
		System.out.printf("points:%d ",points);
		System.out.printf("numberofvotes:%d ",numberofvotes);
		System.out.printf("money:%d ",money);
	}
	
	void displaymoneyteam() {
		System.out.println(money);
	}
	
	void displaynumberofvotes() {
		System.out.println(numberofvotes);
	}
	

}
