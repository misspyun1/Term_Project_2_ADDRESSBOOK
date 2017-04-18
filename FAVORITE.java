package addressbook.demo;

import java.util.ArrayList;
import java.util.List;

public class FAVORITE implements FAVORITE_INTERFACE {
	
	 List<PERSON> favorite = new ArrayList<PERSON>();
	   
	   public void Add(PERSON_LIST Addressbook,String search_string, int index){
	      PERSON NEW = Addressbook.Addresstree.get(search_string).get(index);
	       if(this.favorite.contains(NEW.name))
	              System.out.println("Already exist in Favorite\n");
	       else{
	              this.favorite.add(NEW);
	       }
	   }
	   public void Print(){
	      int length=this.favorite.size();
	      for(int i = 1; i<=length;i++)	    	  
	         System.out.println(i+". "+this.favorite .get(i-1).name+"\t"
	      +this.favorite .get(i-1).phone+"\t"+this.favorite .get(i-1).email+
	      "\t"+this.favorite .get(i-1).company+"\n");
	   }
	   public void Delete(int index){
		      PERSON NEW=this.favorite .get(index);
		      if(this.favorite .contains(NEW)){
		         this.favorite .remove(NEW);
		      }
		      else{
		         System.out.println("It is not Favorite contact\n");
		      }
		   }
}