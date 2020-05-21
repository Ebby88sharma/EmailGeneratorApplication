package emailApp;

import java.util.Scanner;

public class Email {
 private String fname;      //private (So that no one can access directly
 private String lname;
 private String password;
 private String email;
 private String department;
 private int mailboxCapacity=500;
 private int defaultpasswordLength=10;
 private String alternateEmail;
 private String companySuffix="breedworks.com";
     
       //constructors to recieve fname and lname
        public Email(String fname,String lname) {
		    this.fname=fname;
 	        this.lname=lname;
 	 
 	//call a method asking for the department
 	   this.department=setdepartment();
 	 
 	  //call a method that returns a random password
 	  this.password=randomPassword(defaultpasswordLength);
 	  System.out.println("\nYour password is:- "+this.password);
 	  //Combine elements to generate email
 	  email = fname.toLowerCase() + lname.toLowerCase() +"@"+ department.toLowerCase()+"." + companySuffix;
	   
        }
	   //ask for department
       private String setdepartment() {
    	   System.out.print("\nDepartment codes:\n1 for Sales\n2 for Development\n3 for Accounts\n0 for none\n Enter department code");
		  Scanner in=new Scanner(System.in); 
		  int depChoice=in.nextInt();
		  if(depChoice==1) {return"Sales";}
		  else if(depChoice==2) {return"Development";}
		  else if(depChoice==3) {return"Accounts";}
		  else {return"";}
       }
       //Generate random password
       private String randomPassword(int length) {
    	   String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%"; // to choose the possiblities(allowed characters) mentioned here for password
    	   char [] password=new char [length];
    	   for(int i=0;i<length;i++) {
    		  int rand= (int)(Math.random()*passwordSet.length());
    		  password[i]=passwordSet.charAt(rand);
    		 
    	   }
    	   return new String(password);
       }
       
       //Setters
       //Set the mailbox capacity
       public void setMailboxCapacity(int capacity) {
    	   this.mailboxCapacity=capacity;
       }
       //Set the alternate email
       public void setAlternateEmail(String altEmail) {
    	   this.alternateEmail=altEmail;
       }
       
       //Change the password
       public void changePassword(String password) {
    	   this.password=password;
       }
       //getters
       public int getMailboxCapacity() {
    	   return mailboxCapacity;
       }
       public String getAlternateEmail() {
    	   return alternateEmail;
       }
       public String getPassword() {return password;}
       
       public String showinfo() {
    	   return"DISPLAY Name:"+ fname+" "+lname+
    	           "\nCOMPANY Email:"+email+
    	           "\nMAILBOX Capacity:"+ mailboxCapacity+"mb";
       }
}
