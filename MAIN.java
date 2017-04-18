package addressbook.demo;

import java.util.Scanner;
public class MAIN extends SEARCH{  
   @SuppressWarnings("resource")
public static void main(String[] args) {
      // TODO Auto-generated method stub
	  System.out.println("\n--------------------HELLO:-)--------------------");
	  Scanner inputnum = new Scanner(System.in);
      Scanner inputstring = new Scanner(System.in);
       
      System.out.print("Enter your number: ");
      String my_phone = inputstring.nextLine();
	   
      JSON json = new JSON();
      RECENTS recents = new RECENTS();
      PERSON_LIST Addressbook=new PERSON_LIST(); 
      FAVORITE favorite = new FAVORITE();
      String[] editlist = {"name", "phone", "email", "company"};
      
      try{ json.getData(Addressbook);}
      catch(NullPointerException e){
         System.out.println("! No contact in the file !\n");
      }
      
      while(true){
         System.out.println("\n0. CONTACTS\n1. Add\n2. Search\n3. Favorite\n4. Recents\n5. Delete All\n6. Exit");
         System.out.print("Select menu: ");
         
       //  try{
            int menu = inputnum.nextInt();
            
            if(menu==0){
            	 System.out.println("\n-------------------------☎CONTACTS----------------------------");
            	System.out.println("My number> "+my_phone+"\n");
                System.out.println("   name\tphone\t\temail\t\t\tcompany");
                Addressbook.Print();
             }//menu==0
               
            else if(menu==1){
            	System.out.println("\n-----------------------Add-----------------------");
               System.out.print("name: ");
               String name = inputstring.nextLine();
               Makeindex(name, Addressbook);//주어진 name의 첫글자가 영어인지 판단하고, 인덱스를 만들어 주는 if문
               
               System.out.print("phone: ");
               String phone = inputstring.nextLine();
               
               System.out.print("email: ");
               String email = inputstring.nextLine();
               
               System.out.print("company: ");
               String company = inputstring.nextLine();
               
               if(Addressbook.Numbertree.containsKey(phone))
            	   System.out.println("This number already exist!");
               else
            	   Addressbook.Add(name, email, phone, company);
            }//menu==1 (CONTACTS)
            
            else if(menu==2){
               int edit_num=0, edit_menu=0;
               System.out.println("\n----------------------------Search----------------------------");
               System.out.print("Search: ");
               String search_string = inputstring.nextLine();
               System.out.println("   name\t\tphone\t\temail\t\t\tcompany");
               int length = Search(Addressbook, search_string);
               
               if(length==0){}
               
               else{
            	if(length==1) edit_num=1;//1개라면, 바로 그 연락처에 접근하게 한다.
               
            	else{
                  try{
                  System.out.print("\nEnter the number of contact to edit.\n(Enter 0 if you don't want to edit): ");
                  edit_num = inputnum.nextInt();
                  }catch(Exception e){
                     System.out.println("\n! Please enter the number !\n");
                  }
               }//만약 검색한 결과가 1개가 아니라면, 몇번째 연락처에 접근하고 싶은지 입력받는다. 
               }//search 성공시
                
            	if(edit_num!=0){
	             //  try{
	            	  
	                  System.out.println("\n0. Do not edit\n1. edit name\n2. edit phone\n3. edit email\n4. edit company\n5. add to Favorite\n6. delete");
	                  System.out.print("Select edit menu: ");
	                  edit_menu = inputnum.nextInt();
	                  if(edit_menu==0) {}
	                  else{
	                	  System.out.println("\n----------------------Edit----------------------");
	                  if(edit_menu <5){
	                     System.out.print("\nEnter new "+editlist[edit_menu-1]+": ");
	                     String edit_string = inputstring.nextLine();
	                     Edit(Addressbook,search_string, edit_string, edit_menu, 0);   
	                  }
	                  else if(edit_menu==5){
	                	  favorite.Add(Addressbook, search_string, edit_num-1);
	                  }
	                  else if(edit_menu==6){
	                     System.out.println("\n---------------------Deleted---------------------\n");
	                     Delete(Addressbook, search_string,edit_num-1);
	                  }
	                  else
	                     System.out.println("\n! Please select menu from 0 to 6 !\n");
	                  }
	             //  }catch(Exception e){
	               //   System.out.println("\n! Please enter the number !\n");
	               //} //edit menu 입력을 위한 try catch문
            	}//do edit
            }//menu==2(Edit)
            
            else if(menu==3){
            	System.out.println("\n--------------------Favorite--------------------");
                favorite.Print();
                System.out.println("1. Delete in favorite\n2. Quit");
                System.out.print("Select: ");
                try{
                int fav_delete = inputnum.nextInt();
                if(fav_delete==1){
                	System.out.print("Enter the number to delete: ");
                	int delete_num = inputnum.nextInt();
                	favorite.Delete(delete_num-1);
                }
                }catch(Exception e){}
            }//menu==3(Favorite)
            
            else if(menu==4){
            	System.out.println("\n----------------------Recents---------------------");
               recents.print();
               System.out.println("------------------------------------------------");
               System.out.print("\nSelect number of record want to see: ");
               int recent_num = inputnum.nextInt();
               System.out.println("------------------------------------------------");
               recents.Detail(recent_num);
               System.out.println("------------------------------------------------");
               System.out.print("\nDo you want more information?(y or n): ");
               char answer = inputnum.next().charAt(0);
               
               if(answer=='y'){
            	   System.out.println("\n-------------------Information-------------------");
                   recents.Show_contacts(Addressbook,recent_num-1);
               }
            }//menu==4(Recent)
            
            else if(menu==5){
            	System.out.println("\n--------------------DeleteAll--------------------");
            	Addressbook.Addresstree.clear();//menu==5
            }
            else if(menu==6){
            	System.out.println("\n---------------------BYE:-(---------------------");
            	break;//menu==6
            }
            else System.out.println("\n! Please select menu from 0 to 6 !\n");
            
         //}catch(Exception e){
           // System.out.println("\n! Please enter the number !\n");
       //  }//menu입력 try catch문
      }//전체 while문
      json.makeData(Addressbook);
   }//main 함수 
}//main 클래스 
