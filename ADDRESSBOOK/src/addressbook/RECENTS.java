package addressbook;

import java.util.List;

public class RECENTS extends JSON {
   String direction;
   String type;
   String name;
   String time;
   String date;
   String contents;
   
   JSON json = new JSON();
   
   public void setlist(String direction, String type,String name, String time, String date, String contents){
      this.direction = direction;
      this.type = type;
      this.name = name;
      this.time = time;
      this.date = date;
      this.contents = contents;
   }
   
   public void print(){
      for(int i=1;i<=json.getData().size();i++){
         System.out.println(i +". "+json.getData().get(i-1).direction+
               json.getData().get(i-1).type+json.getData().get(i-1).name);
      }
   }
   
   public void Detail(int index){
	      System.out.println(json.getData().get(index-1).direction+
	            json.getData().get(index-1).type+json.getData().get(index-1).name+"\n"+
	            json.getData().get(index-1).time+json.getData().get(index-1).date+
	            "\""+json.getData().get(index-1).contents+"\"");
   }
   
   public void Show_contacts(PERSON_LIST book, int index){
      RECENTS contact = json.getData().get(index);
      List<PERSON> samename = book.tree.get(contact.name);
      int length=samename.size();
      for(int i=0;i<length;i++)
    	  System.out.println(samename.get(i).name+"\t"+samename.get(i).phone+"\t"+samename.get(i).email+"\t"+samename.get(i).company+"\n");
      
   }   
}
