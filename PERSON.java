package addressbook.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

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

	public TreeMap <String, List<PERSON > > Addresstree = new TreeMap<String, List<PERSON> >();
	public HashMap<String, PERSON> Numbertree=new HashMap<String, PERSON >();
	   
	   public void Add(String name, String email, String phone, String company){
	        PERSON NEW = new PERSON(name, email, phone, company);
	         this.Numbertree.put(phone,NEW);
	         if(this.Addresstree.containsKey(name))
	              this.Addresstree.get(name).add(NEW); 
	         else{
	              List <PERSON> Duplication=new ArrayList<PERSON>();
	              Duplication.add(NEW);
	              this.Addresstree.put(name,Duplication);
	          }
	         
	   }
	   
	 public void Print(){
		 int cnt=0;
         for(Map.Entry<String, List<PERSON>> entry : this.Addresstree.entrySet()){ 
            
             int length = entry.getValue().size();
             for(int i=0;i<length;i++){
                cnt++;
               
                PERSON NEW=entry.getValue().get(i);
                if(NEW.isindex) {
                   System.out.println("     "+NEW.name+"\t"+NEW.phone+"\t"+NEW.email+"\t"+NEW.company);
                   cnt--;
                }
                else {
                	System.out.printf("%3d. ", cnt);
                	System.out.println(NEW.name+"\t"+NEW.phone+"\t"+NEW.email+"\t"+NEW.company);
                }
             }//list의 크기만큼 for문
         }//key의 개수만큼 for문
         System.out.println("--------------------------------------------------------------");
         System.out.println("\n"+cnt+" contacts.");
	 }
}

class SEARCH extends JSON{
   
   public static int Search(PERSON_LIST Addressbook, String search_string){
	   if(!Addressbook.Addresstree.containsKey(search_string)&&!Addressbook.Numbertree.containsKey(search_string)){
           System.out.println("No results.\n");
           return 0;
        }
           
        else{
           int length = 0;
           if(Addressbook.Addresstree.containsKey(search_string)){
              length=Addressbook.Addresstree.get(search_string).size();
              for(int i=1;i<=length;i++){
                 PERSON list=Addressbook.Addresstree.get(search_string).get(i-1);
                  System.out.println(i+". "+list.name+"\t"+list.phone+"\t"+list.email+"\t"+list.company);
              }
              System.out.println();
           }
           if(Addressbook.Numbertree.containsKey(search_string)) {
              PERSON list=Addressbook.Numbertree.get(search_string);
              length++;
              System.out.println(length+". "+list.name+"\t"+list.phone+"\t"+list.email+"\t"+list.company+"\n");
           }
           
           return length;
        }
       
    }
   
   public static void Delete(PERSON_LIST Addressbook,String search_string, int index){
			
		if(!Pattern.matches("[a-zA-Z]+",search_string)){
			String phone_num = search_string;
			search_string=Addressbook.Numbertree.get(search_string).name;
			Addressbook.Numbertree.remove(phone_num);
    	    }
		List<PERSON> list = Addressbook.Addresstree.get(search_string);
		
		if(list.size()==1 )
			Addressbook.Addresstree.remove(search_string);
		else
			list.remove(index);
		
		 try{
		       if(!Addressbook.Addresstree.higherKey(search_string.substring(0, 1)).startsWith(search_string.substring(0, 1)))
		    	   Addressbook.Addresstree.remove(search_string.substring(0, 1));
		      }catch(NullPointerException e){
		    	  Addressbook.Addresstree.remove(search_string.substring(0, 1));
		      }
	}
	

   public static void Edit(PERSON_LIST Addressbook,String search_string, String edit_string, int editmenu, int index){
       String phone_num=Addressbook.Addresstree.get(search_string).get(index).phone;
       
       if(!Pattern.matches("[a-zA-Z]+",search_string))
    	   	search_string=Addressbook.Numbertree.get(search_string).name;
          
       if(editmenu==1){
        	  Addressbook.Addresstree.get(search_string).get(index).name=edit_string;
             List<PERSON> list =Addressbook.Addresstree.get(search_string);
    
             Addressbook.Add(edit_string, list.get(index).email, list.get(index).phone,list.get(index).company);
             Delete(Addressbook,search_string,index);
          }
          else if(editmenu==2){
        	 Addressbook.Addresstree.get(search_string).get(index).phone=edit_string;
             PERSON NEW = Addressbook.Numbertree.get(phone_num);
             NEW.phone=edit_string;
             Addressbook.Numbertree.remove(phone_num);
             Addressbook.Numbertree.put(edit_string, NEW);
          }
          else if(editmenu==3){
        	  Addressbook.Addresstree.get(search_string).get(index).email=edit_string;
        	  Addressbook.Numbertree.get(phone_num).email=edit_string;
          }
          else if(editmenu==4){
        	  Addressbook.Addresstree.get(search_string).get(index).company=edit_string;
        	  Addressbook.Numbertree.get(phone_num).company=edit_string;
          }
    }
	  
}