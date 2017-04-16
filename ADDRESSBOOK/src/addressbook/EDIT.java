package addressbook;


import java.util.List;
import java.util.TreeMap;

public class EDIT extends SEARCH{
	
	public static void Delete(PERSON_LIST book,String key, int index){
		List<PERSON> list = book.tree.get(key);
		if(list.size()==1 ){
			book.tree.remove(key);
		}
		else{
			list.remove(index);
		}
		if(!book.tree.higherKey(key.substring(0, 1)).startsWith(key.substring(0, 1))||book.tree.higherKey(key.substring(0, 1))==null)
	          book.tree.remove(key.substring(0, 1));
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
