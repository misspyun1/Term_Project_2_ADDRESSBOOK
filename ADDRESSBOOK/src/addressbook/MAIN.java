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
               System.out.println("---------��CONTACTS-----------");
               Address_Tree.Print();
               System.out.println("1. Delete All Contact\n2. Quit\n");
               try{
            	   int contact_menu=inputnum.nextInt();
            	   if(contact_menu==1) DeleteAll(Address_Tree);
            	   else if(contact_menu==2) continue;
               }catch(Exception e){
                   System.out.println("\n! Please enter 1 or 2!\n");
               }//contact�޴����� 1 �Ǵ� 2�� �Է����� �� ���� ���� ���� try catch ��
            }//menu==0
               
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
               }//�־��� name�� ù���ڰ� �������� �Ǵ��ϰ�, �ε����� ����� �ִ� if��
               
               System.out.print("phone: ");
               String phone = inputstring.nextLine();
               
               System.out.print("email: ");
               String email = inputstring.nextLine();
               
               System.out.print("company: ");
               String company = inputstring.nextLine();
               
               
               Address_Tree.Add(name, email, phone, company);
            }//menu==1 (CONTACTS)
            
            else if(menu==2){
               int edit_num=0, editmenu=0;
               String search_string = inputstring.nextLine();
               int length = Search(Address_Tree, search_string);  //����ó ��������� ����
               
               if(length!=1){
                  try{
                  System.out.println("Enter the number of contact to edit\n");
                  edit_num = inputnum.nextInt();
                  }catch(Exception e){
                     System.out.println("\n! Please enter the number !\n");
                  }
               }//���� �˻��� ����� 1���� �ƴ϶��, ���° ����ó�� �����ϰ� ������ �Է¹޴´�. 
               else edit_num=1;//1�����, �ٷ� �� ����ó�� �����ϰ� �Ѵ�.
               
               try{
                  System.out.println("1. edit name\n2. edit phone\n3. edit email\n4. edit company\n5. add to Favorite\n6. delete\n7. Do not edit");
                  editmenu = inputnum.nextInt();
               
                  if(editmenu <5){
                     System.out.print("Enter new : ");
                     String edit_string = inputstring.nextLine();
                     Edit(Address_Tree,search_string, edit_string, editmenu, 0);   
                  }
                  else if(editmenu==5){
                	  favorite.Add(Address_Tree, search_string, edit_num-1);
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
               } //edit menu �Է��� ���� try catch��
            }//menu==2(Edit)
            
            else if(menu==3){
              favorite.Print();
            }//menu==3(Favorite)
            
            else if(menu==4){
               recents.print();
               System.out.println("\nSelect number of record want to see\n");
               int recent_num = inputnum.nextInt();
               recents.Detail(recent_num);
               System.out.println("\nDo you want more information?\n");
               char ans = inputnum.next().charAt(0);
               
               if(ans=='y')
            	   recents.Show_contacts(Address_Tree,recent_num-1); 
            }//menu==4(Recent)
            else if(menu==5) break;//menu==5
            else System.out.println("\n! Please select menu from 1 to 5 !\n");
            
         }catch(Exception e){
            System.out.println("\n! Please enter the number !\n");
         }//menu�Է� try catch��
      }//��ü while��
      json.makeData(Address_Tree);
   }//main �Լ� 
}//main Ŭ���� 