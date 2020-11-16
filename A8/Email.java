import java.util.Random;
import java.util.Scanner;

public class Email {

    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";
    private String firstName;
    private String lastName;
    private String[] departments;
    private String email;
    private String pwd;
    private String depart = "none";
    Scanner sc = new Scanner(System.in);

    public Email(String firstName, String lastName) {
    	this.firstName = firstName;
    	this.lastName = lastName;  	
    	departments = new String[] {"None", "Sales", "dev", "Accounting"};
    	this.depart = this.SetDepartment();
    	this.email = firstName + "." + lastName + "@" + this.depart + "." + this.companySuffix;
    	this.pwd = this.randomPassword(this.defaultPasswordLength);
    }
    
    public String showInfo() {
    	String ans = "";
    	ans += "DISPLAY NAME: " + this.getName();
    	ans += "\nDEPARTMENT: " + this.depart;
        ans += "\nCOMPANY EMAIL: " + this.getEmail();
        ans += "\nPASSWORD: " + pwd;
        ans += "\nMAILBOX CAPACITY: " + this.getMailboxCapacity() + "mb";
        return ans;
    }
    
    private String SetDepartment() {
    	System.out.println("New Worker: " + this.firstName + " " + this.lastName + ". Department Codes:");
        for(int i = 1; i < this.departments.length; i++) {
        	System.out.println( i + " for " + this.departments[i]);
        }
        System.out.println("0 for " + this.departments[0]);
        System.out.println("Enter department code:");
        String code = sc.next();  
    	return this.departments[Integer.parseInt(code)];
    }
    
    private String randomPassword(int length) {
    	Random r = new Random();
    	// index 0 - 40.
    	String element = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
    	String pwd = "";
    	while(length > 0) {
    		int n = r.nextInt(41);
    		pwd += element.charAt(n);
    		length--;
    	}
    	return pwd;
    }
    
    public String getName() {
    	return this.firstName + " " + this.lastName;
    }
    
    public int getMailboxCapacity() {
    	return this.mailboxCapacity;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public void setNewPassword() {
    	System.out.println("Please type the new password you want change to:");
    	String pwd = sc.next();
    	this.pwd = pwd;
    }
    
    public void setAlternateEmail() {
    	System.out.println("Please type the alternate email you want to change to:");
    	String email = sc.next();
    	this.email = email;
    }
    
    public void setMailCapacity() {
    	System.out.println("Please type the mail capacity you want to change to:");
    	int capacity = sc.nextInt();
    	this.mailboxCapacity = capacity;
    }

}