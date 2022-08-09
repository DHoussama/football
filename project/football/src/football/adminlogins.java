package football;

import java.io.*;
import java.util.*;
public class adminlogins {
	HashMap<String, String> hm ;
	
	 
    public adminlogins() {
        hm=new HashMap<String,String>();
        try {
	        File toRead=new File("adminlogins");
	        FileInputStream fis=new FileInputStream(toRead);
	        ObjectInputStream ois=new ObjectInputStream(fis);

	       // HashMap<String,String> mapInFile
	        hm=(HashMap<String,String>)ois.readObject();

	        ois.close();
	        fis.close();
	        //print All data in MAP
	       //mapInFile
	        for(Map.Entry<String,String> m :hm.entrySet()){
	            System.out.println(m.getKey()+" : "+m.getValue());
	        }
	        System.out.println(Arrays.asList(hm));
	    } catch(Exception e) {}

        
        getinformation();

    }




public void method2(HashMap<String,String> map) {
	//write to file : "fileone"
	 try {
	        File fileOne=new File("adminlogins");
	        FileOutputStream fos=new FileOutputStream(fileOne);
	        ObjectOutputStream oos=new ObjectOutputStream(fos);

	        oos.writeObject(map);
	        oos.flush();
	        oos.close();
	        fos.close();
	    } catch(Exception e) {}

   
  }

HashMap<String,String> getmap() {
	return hm;
}

void addtouserlogins(String x,String y) {
	
	hm.put(x, y) ;
	   //method2(hm) ;
	   
	
}

	void getinformation() {
		
		System.out.println(Arrays.asList(hm));
	}


}
