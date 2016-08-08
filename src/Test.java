import java.util.*;
import java.io.*;


public class Test {
	public static void main(String[] args) throws IOException {
	   
		Notification notfication = new Notification();
		
		Member m1 = new Member();
		m1.name = "Srinath Jagganath";
		m1.phoneNumber = "562-682-4406";
		m1.email = "sjsrinath92@gmail.com";
		
		Member m2 = new Member();
		m2.name = "Sumit Mendiratta";
		m2.phoneNumber = "669-232-7803";
		m2.email = "sumit.mendiratta@gmail.com";
		
		Member m3 = new Member();
		m3.name = "Anas Raza Firdousi";
		m3.phoneNumber = "408-816-4966";
		m3.email = "anas.firdousi@gmail.com";
		
		//TEST:01
		System.out.println("TEST 001");
		System.out.println("*********");
		
		notfication.setMessage("Driver waiting outside");
		notfication.setListener(m1);
		notfication.setListener(m2);
		notfication.send();
		
		//TEST:02
		
		System.out.println("TEST 002");
		System.out.println("*********");
		
		notfication.setMessage("Payment received");
		notfication.removeListener(m1);
		
		notfication.send();
		
		//TEST:03
		System.out.println("TEST 003");
		System.out.println("*********");
		
		notfication.resetListeners();
		notfication.setListener(m3);
		notfication.setMessage("Ride complete!");
		
		notfication.send();

		
		
//	    System.out.println(" Welcome to CarPool app");
//	    System.out.println(" What you would like to do?");
//	    System.out.println(" (S) Signup (L) Login");
//	    
//	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Enter Your Choice?");
//        String s = br.readLine();
//	    System.out.println(s);
//
//	    if(s.equals("S"))
//	    {
//	       System.out.println("Would you like to signup as (R)rider or (D)driver?            (O)SignOut ");
//	       System.out.println("Enter your choice?");
//	       String sc = br.readLine();
//	       if(sc.equals("S"))
//	       {
//	    	   System.out.println("Entered is Rider");
//	    	   System.out.println("Entered User Name ");
//	    	   String uername = br.readLine();
//	    	   System.out.println("Entered Email ID");
//	    	   String emailid = br.readLine();
//	    	   System.out.println("Entered Passowrd");
//	    	   String password = br.readLine();
//	    	   System.out.println("Entered Contact Number");
//	    	   String contactnumber = br.readLine();
//	    	   System.out.println("Entered Address");
//	    	   String addr = br.readLine();
//	    	   System.out.println("Entere Driving License Number");
//	    	   String dl = br.readLine();
//	    	   
//	    	   List list  = new ArrayList();
//		 	   list.add(uername);
//		 	   list.add(emailid);
//		 	   list.add(password);
//		 	   list.add(contactnumber);
//		 	   list.add(addr);
//		 	   list.add(dl);
//		 	
//		 	   System.out.println(list);
//	    	   
//	    	 }
//	       else{
//	    	   
//	    	   System.out.println("Entered is Driver");
//	    	   System.out.println("Entered is Rider");
//	    	   System.out.println("Entered User Name ");
//	    	   String uername = br.readLine();
//	    	   System.out.println("Entered Email ID");
//	    	   String emailid = br.readLine();
//	    	   System.out.println("Entered Passowrd");
//	    	   String password = br.readLine();
//	    	   System.out.println("Entered Contact Number");
//	    	   String contactnumber = br.readLine();
//	    	   System.out.println("Entered Address");
//	    	   String addr = br.readLine();
//	       }
//	       
//	       
//	    }
//	    else if(s.equals("L"))
//	    {
//	    	 System.out.println("Enter User Name");
//	    	 String uername = br.readLine();
//	    	 System.out.println("Enter Password");
//	    	 String pwd = br.readLine();
//	    	 
//	 
//	  
//	    	 
//	    }
//	    else{
//	    	System.out.println("Wrong Choice");
//	    }
//	    
	    
	    
	    
	    
	}
}
