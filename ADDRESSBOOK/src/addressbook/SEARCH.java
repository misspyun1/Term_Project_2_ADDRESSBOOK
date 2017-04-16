package addressbook;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
}