package addressbook;



public class PERSON {
   String name;
   String email;
   String phone;
   String company;
   Boolean isindex;
   
   public PERSON() {
	   // TODO Auto-generated constructor stub
   }
      
   public PERSON(String name, String email, String phone, String company){
	      this.name = name;
	      this.email = email;
	      this.phone = phone;
	      this.company = company;
	      this.isindex=false;
   }

}