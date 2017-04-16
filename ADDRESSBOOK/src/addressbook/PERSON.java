package addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PERSON {
   String name;
   String email;
   String phone;
   String company;
   Boolean isindex;
   
   public PERSON() {}
      
   public PERSON(String name, String email, String phone, String company){
	      this.name = name;
	      this.email = email;
	      this.phone = phone;
	      this.company = company;
	      this.isindex=false;
   }

}

class PERSON_LIST {

	public TreeMap <String, List<PERSON > > tree = new TreeMap<String, List<PERSON> >();
	
	public void Add(String name, String email, String phone, String company){
		  PERSON NEW = new PERSON(name, email, phone, company);
	      if(this.tree.containsKey(name))
	           this.tree.get(name).add(NEW); 
	      else{
	           List <PERSON> Dup=new ArrayList<PERSON>();
	           Dup.add(NEW);
	           this.tree.put(name,Dup);
	       }
	 }
	   
	 public void Print(){
	      for(Map.Entry<String, List<PERSON>> entry : this.tree.entrySet()){ 
	         int length = entry.getValue().size();
	         for(int i=0;i<length;i++)
	            System.out.println(entry.getKey()+"\t"+entry.getValue().get(i).phone+"\t"+entry.getValue().get(i).email+"\t"+entry.getValue().get(i).company);
	      }
	 }
}