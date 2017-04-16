package addressbook;

import java.util.ArrayList;
import java.util.List;

public class SEARCH extends PERSON_LIST {
	
   public static List<PERSON> SEARCHLIST=new ArrayList<PERSON>();
   
   public static void Search(PERSON_LIST book, String search_string){
      if(!book.tree.containsKey(search_string))
         System.out.println("No results.");
      else{
         int length = book.tree.get(search_string).size();
         for(int i=0;i<length;i++)
            System.out.println(book.tree.get(search_string).get(i).name+
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