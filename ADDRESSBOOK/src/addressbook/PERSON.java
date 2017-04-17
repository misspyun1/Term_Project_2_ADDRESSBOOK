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
		 int cnt=0;
	      for(Map.Entry<String, List<PERSON>> entry : this.tree.entrySet()){ 
	    	  
	          int length = entry.getValue().size();
	          for(int i=0;i<length;i++){
	        	  cnt++;
	        	 
	        	  PERSON NEW=entry.getValue().get(i);
	        	  if(NEW.isindex) {
	        		  System.out.println("   "+entry.getKey()+"\t"+NEW.phone+"\t"+NEW.email+"\t"+NEW.company);
	        		  cnt--;
	        	  }
	        	  else System.out.println(cnt+ ". "+entry.getKey()+"\t"+NEW.phone+"\t"+NEW.email+"\t"+NEW.company);
	          }//list의 크기만큼 for문
	      }//key의 개수만큼 for문
	      System.out.println("\n"+cnt+" contacts\n");
	 }
}

class SEARCH {
	
	   public static List<PERSON> SEARCHLIST=new ArrayList<PERSON>();
	   
	   public static void Search(PERSON_LIST book, String search_string){
	      if(!book.tree.containsKey(search_string))
	         System.out.println("No results.");
	      else{
	         int length = book.tree.get(search_string).size();
	         for(int i=1;i<=length;i++)
	            System.out.println(i+book.tree.get(search_string).get(i).name+
	                  "\t"+book.tree.get(search_string).get(i).phone+
	                  "\t"+book.tree.get(search_string).get(i).email+
	                  "\t"+book.tree.get(search_string).get(i).company);
	      }
	   }
	   public static void Delete(PERSON_LIST book,String key, int index){
			List<PERSON> list = book.tree.get(key);
			if(list.size()==1 ){
				book.tree.remove(key);
			}
			else{
				list.remove(index);
			}
			try{
	           if(!book.tree.higherKey(key.substring(0, 1)).startsWith(key.substring(0, 1)))
	               book.tree.remove(key.substring(0, 1));
	           }catch(NullPointerException e){
	              book.tree.remove(key.substring(0, 1));
	           }
		}
		

		public static void Edit(PERSON_LIST book,String search_string, String edit_string, int editmenu, int index){
		      if(editmenu==1){
		         book.tree.get(search_string).get(index).name=edit_string;
		         List<PERSON> list =book.tree.get(search_string);
		
		         book.Add(edit_string, list.get(index).email, list.get(index).phone,list.get(index).company);
		         Delete(book,search_string,index);
		      }
		      else if(editmenu==2)
		         book.tree.get(search_string).get(index).phone=edit_string;
		      else if(editmenu==3)
		         book.tree.get(search_string).get(index).email=edit_string;
		      else if(editmenu==4)
		         book.tree.get(search_string).get(index).company=edit_string;
		   
		}
	}