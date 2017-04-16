package addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PERSON_LIST extends PERSON{
	

	public PERSON_LIST() {
		super();
		// TODO Auto-generated constructor stub
	}

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
