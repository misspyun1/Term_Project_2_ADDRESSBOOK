package addressbook;

import java.util.ArrayList;
import java.util.List;

public class FAVORITE extends PERSON{
	
	List<PERSON> list = new ArrayList<PERSON>();
	
	public void Add(PERSON_LIST book,String search_string, int index){
		PERSON NEW=book.tree.get(search_string).get(index);
	    if(this.list.contains(NEW.name))
	           System.out.println("Already exist in Favorite\n");
	    else{
	           this.list.add(NEW);
	    }
	}
	
	public void Print(){
		int length=this.list.size();
		for(int i = 0; i <length;i++)
			System.out.println(this.list.get(i).name+"\t"+this.list.get(i).phone+"\t"+this.list.get(i).email+"\t"+this.list.get(i).company+"\n");
	}
}
