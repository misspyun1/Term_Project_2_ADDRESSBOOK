package addressbook;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;

public class MAIN extends SEARCH{   
   @SuppressWarnings("resource")
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      JSON json = new JSON();
      RECENTS recents = new RECENTS();
      PERSON_LIST Address_Tree=new PERSON_LIST(); 
      FAVORITE favorite = new FAVORITE();
      
      try{ json.getData(Address_Tree);}
      catch(NullPointerException e){
         System.out.println("No contact in the file\n");
      }
      
      while(true){
         System.out.println("0. CONTACTS\n1. Add\n2. Search\n3. Favorite\n4. Recents\n5. Exit");
         System.out.print("Select menu: ");
         Scanner inputnum = new Scanner(System.in);
         Scanner inputstring = new Scanner(System.in);
         
         try{
            int menu = inputnum.nextInt();
         
            if(menu==0){
               System.out.println("---------☎CONTACTS-----------");
               Address_Tree.Print();
            }
               
            else if(menu==1){
               System.out.print("name: ");
               String name = inputstring.nextLine();
               
               if(Pattern.matches("[a-zA-Z]+",name.substring(0, 1))){
                  String index = name.substring(0, 1);
                  if(Address_Tree.tree.containsKey(index)){}
                  else{
                     
                     Address_Tree.Add(index," "," "," ");
                     Address_Tree.tree.get(index).get(0).isindex=true;
                  }
               }
               
               System.out.print("phone: ");
               String phone = inputstring.nextLine();
               
               System.out.print("email: ");
               String email = inputstring.nextLine();
               
               System.out.print("company: ");
               String company = inputstring.nextLine();
               
               
               Address_Tree.Add(name, email, phone, company);
            }
            
            else if(menu==2){
               int edit_num=0, editmenu=0;
               String search_string = inputstring.nextLine();
               Search(Address_Tree, search_string);
               int length = Address_Tree.tree.get(search_string).size();   //연락처 비어있으면 오류
               
               if(length!=1){
                  try{
                  System.out.println("Enter the number of contact to edit\n");
                  edit_num = inputnum.nextInt();
                  }catch(Exception e){
                     System.out.println("\n! Please enter the number !\n");
                  }
               }
               else edit_num=1;
               try{
                  System.out.println("1. edit name\n2. edit phone\n3. edit email\n4. edit company\n5. add to Favorite\n6. delete\n7. Do not edit");
                  editmenu = inputnum.nextInt();
               
                  if(editmenu <5){
                     System.out.print("Enter new : ");
                     String edit_string = inputstring.nextLine();
                     Edit(Address_Tree,search_string, edit_string, editmenu, 0);   
                  }
            
                  else if(editmenu==6){
                     System.out.println("\n-----------Deleted------------\n");
                     Delete(Address_Tree, search_string,edit_num-1);
                  }
                  else if(editmenu==7){}
                  else
                     System.out.println("\n! Please select menu from 1 to 7 !\n");
                  
               }catch(Exception e){
                  System.out.println("\n! Please enter the number !\n");
               } 
            }
            
            else if(menu==3)
              favorite.Print();
            
            else if(menu==4){
               recents.print();
               System.out.println("\nSelect number of record want to see\n");
               int recent_num = inputnum.nextInt();
               recents.Detail(recent_num);
               System.out.println("\nDo you want more information?\n");
               char ans = inputnum.next().charAt(0);
               
               if(ans=='y')
            	   recents.Show_contacts(Address_Tree,recent_num-1);
               
            }
            else if(menu==4){
                recents.print();
                
                
             }
            
            else if(menu==5) break;
            else System.out.println("\n! Please select menu from 1 to 5 !\n");
         }catch(Exception e){
            System.out.println("\n! Please enter the number !\n");
         }
      }
      json.makeData(Address_Tree);
   }
}