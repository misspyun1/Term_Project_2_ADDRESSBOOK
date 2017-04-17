package addressbook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSON extends PERSON_LIST{
   public void makeData(PERSON_LIST tree){
      
      JSONObject contact = new JSONObject();
       try{
          JSONArray jsonArray=new JSONArray();
          for(Map.Entry<String, List<PERSON>> entry : tree.tree.entrySet()){ 
               int length = entry.getValue().size();
               for(int i=0;i<length&&entry.getValue().get(0).isindex==false;i++){
                  PERSON person = entry.getValue().get(i);
                  JSONObject jsonObject=new JSONObject();
                  jsonObject.put("name", person.name);
                  jsonObject.put("phone",person.phone);
                  jsonObject.put("email",person.email);
                  jsonObject.put("company",person.company);
                  jsonArray.add(jsonObject);
               }
          }
          contact.put("contact", jsonArray);
          
            FileWriter fileWriter = new FileWriter("C:\\Users\\Administrator\\Desktop\\address.json\\");
            fileWriter.write(contact.toJSONString());
            fileWriter.flush();
            fileWriter.close();
            
         }catch(IOException e){
            e.printStackTrace();
         }
   }

   public void getData(PERSON_LIST tree){
      JSONParser parser = new JSONParser();
         
         try{
            Object object = parser.parse(new FileReader("C:\\Users\\Administrator\\Desktop\\address.json\\"));
            JSONObject jsonObject = (JSONObject)object;
            
            JSONArray contact = (JSONArray)jsonObject.get("contact");
            Iterator<JSONObject> iterator = contact.iterator();
            
            while(iterator.hasNext()){
               JSONObject it= iterator.next();
               String name = (String)it.get("name");
               String phone = (String)it.get("phone");
               String email = (String)it.get("email");
               String company = (String)it.get("company");
               tree.Add(name, phone, phone, company);
            }
           
         }catch(FileNotFoundException e){
            e.printStackTrace();
         }catch(IOException e){
            e.printStackTrace();
         }catch(org.json.simple.parser.ParseException e){
            e.printStackTrace();
         }
   }
   
   public List<RECENTS> getData(){
      JSONParser parser = new JSONParser();
      List<RECENTS> recent = new ArrayList();
       try{
    	   	Object object = parser.parse(new FileReader("C:\\Users\\Administrator\\Desktop\\recents.json\\"));
            JSONObject jsonObject = (JSONObject)object;
            
            JSONArray contact = (JSONArray)jsonObject.get("recents");
            Iterator<JSONObject> iterator = contact.iterator();
            
            while(iterator.hasNext()){
               JSONObject it= iterator.next();
               String direction = (String)it.get("direction");
               String type = (String)it.get("type");
               String name = (String)it.get("name");
               String time = (String)it.get("time");
               String date = (String)it.get("date");
               String contents = (String)it.get("contents");
               RECENTS recentlist = new RECENTS();
               recentlist.setlist(direction, type, name, time, date, contents);
               recent.add(recentlist);
            }
           
         }catch(FileNotFoundException e){
            e.printStackTrace();
         }catch(IOException e){
            e.printStackTrace();
         }catch(org.json.simple.parser.ParseException e){
            e.printStackTrace();
         }
       return recent;
   }

   public static void Makeindex(String name, PERSON_LIST book){
		   if(Pattern.matches("[a-zA-Z]+",name.substring(0, 1))){
	       	String index = name.substring(0, 1);
	       	if(book.tree.containsKey(index)){}
	          else{
	             
	             book.Add(index," "," "," ");
	             book.tree.get(index).get(0).isindex=true;
	          }
	       }
	   }
}
