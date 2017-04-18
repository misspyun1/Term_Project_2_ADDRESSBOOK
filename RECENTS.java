package addressbook.demo;

public class RECENTS extends JSON {
	String direction;
	String type;
	String name;
	String number;
	String time;
	String date;
	String contents;
	
	public void setlist(String direction, String type,String name, String number, String time, String date, String contents){
		this.direction = direction;
		this.type = type;
		this.name = name;
		this.number = number;
		this.time = time;
		this.date = date;
		this.contents = contents;
	}
	
	public void print(){
		System.out.println("        type\tname\tdate");
		for(int i=1;i<=getData().size();i++)
			System.out.println(i +". "+getData().get(i-1).direction+"\t"+
					getData().get(i-1).type+"\t"+getData().get(i-1).name+"\t"+getData().get(i-1).date);
		}
	
	public void Detail(int index){
		System.out.println(getData().get(index-1).direction+"\t"+
				getData().get(index-1).type+"\t"+getData().get(index-1).name+"\t"+
				getData().get(index-1).date+"\t"+getData().get(index-1).time+"\t"+"\n"+
				"\t"+"\""+getData().get(index-1).contents+"\"");
	}	
	
	 public void Show_contacts(PERSON_LIST Addressbook, int index){
	      RECENTS contact = getData().get(index);
	      if(Addressbook.Numbertree.containsKey(contact.number))
	    	  System.out.println(Addressbook.Numbertree.get(contact.number).name+"\t"+
	    			  Addressbook.Numbertree.get(contact.number).phone+"\t"+
	    			  Addressbook.Numbertree.get(contact.number).email+"\t"+
	    			  Addressbook.Numbertree.get(contact.number).company+"\n");
	      else
	    	  System.out.println("No result.");
	 }

}