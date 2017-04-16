package addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FAVORITE extends EDIT{
	
	public static List<PERSON> tree = new ArrayList();
	public static List<PERSON> Favorite(PERSON favorite, int index){
	    if(Favorite_list.contains(favorite))
	           System.out.println("Already exist in Favorite\n");
	    else{
	           Favorite_list.add(favorite);
	    }
	    return Favorite_list;
	}
	
	public void Print(){
		System.out.println("favorite print\n");
	}
}
