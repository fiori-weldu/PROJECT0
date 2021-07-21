package banking.driver;
import java.sql.SQLException;
import java.util.List;
//import java.sql.*;
import java.util.Scanner;

import com.banking.models.Account;
//import com.bank.services.AccountServices;
import com.banking.models.User;
import com.dao.AccountDao;
import com.dao.AccountDaoDB;
import com.dao.UserDaoDB;
import com.dao.userDao;
import com.services.AccountServices;
import com.services.UserService;

public class BankDriver {
	
	
	private static userDao uDao=new UserDaoDB();
    private static UserService Userve=new UserService(uDao);
    private static AccountDao aDao = new AccountDaoDB();
	private static AccountServices aServ = new AccountServices(aDao);
	static Account a;
  

    
	public static void main(String[] args) throws SQLException  {
//	 userDao uDao=new UserDaoDB();
//		 UserService uServe=new UserService(uDao);
//	 //uServe.signUp("fio", "weldu", "fioritetet2@gmail.com", "gygy");
//	    User u= new User("Fiorii","weldu","email@u.com","fiorina");
//	    uDao.createUser(u);
//	    System.out.println(uDao.getAllUsers());
		Scanner in=new Scanner(System.in);
		System.out.println("###########################");
		System.out.println();
		System.out.println("Welcome to FW Bank!");
		System.out.println();
		System.out.println("###########################");
		System.out.println();
		//this will be used to control our loop
	boolean  Done=false;
	User u=null;
	while(!Done) {
		if(u==null) {
			System.out.println("LogIn or SignIn?Press 1 to logIn or 2 to signIn");
			int choice=Integer.parseInt(in.nextLine());
			if(choice==1) {
				System.out.println("please enter your username: ");
				String username=in.nextLine();
				System.out.println("please enter your password");
				String password=in.nextLine();
				try {
					u=Userve.signIn(username, password);
					System.out.println("Welcome"+u.getFirstName());
				}
				catch(Exception e) {
					System.out.println("Username or password was incorrect");
					Done=true;
				}
				
			}
			else {
				System.out.println("Please enter your firstname");
				String firstname=in.nextLine();
				System.out.println("Please enter your lastname");
				String lastname=in.nextLine();
				System.out.println("Please enter your email");
				String email=in.nextLine(); 
				System.out.println("Please enter your password");
				String password=in.nextLine();
				try {
					u=Userve.signUp(firstname, lastname,email, password);
					System.out.println("Your Username :"+u.getUsername());
				} catch (Exception e) {
					System.out.println("Sorry, we couldnt process it. \n Try again later");
					Done=true;
					// TODO: handle exception
				}
			}
			System.out.println("###########################");
		}
		///////////////////////////
		
		
		else {
		System.out.println("What would you like to do?\n");
		System.out.println("1. View Account Balance\n"
				+ "2. Create Account\n"
				+ "3. Make A Deposit\n"
				+ "4. Make A withdrawal\n"
				+ "5. Make A Transfer\n"
				+ "6. Logout");
		int choice = Integer.parseInt(in.nextLine());
		//Switch statement for customer options
		switch(choice) {
		
			case 1:
				System.out.println("###########################");
				aDao.getAccountByUser(u).getCurrentBal();
			
			break;
				
			case 2:
				//Create an account 
				System.out.println("###########################");
				System.out.println("Please enter your Customer ID");
				System.out.println("Your Customer ID is: " + u.getId() + ".");
				int id = Integer.parseInt(in.nextLine());
				System.out.println(" ");
				System.out.println("Please enter the type of account you would like to create:\n1.CHECKINGS"
						+ " \n2.SAVINGS");
					String acctType = in.nextLine().toUpperCase();
					
						if(!"CHECKINGS".equals(acctType) && !"SAVINGS".equals(acctType)) {
							
						System.out.println("This is not a valid input, please enter checkings or savings");
						continue;
						
					}
				System.out.println("The minimium balance to start an account is $50. "
							+ "Please enter a balance of at least $50.");
					int balance = Integer.parseInt(in.nextLine());
		
					
					if (balance < 50) {
						System.out.println("You need at least $50 to make a new account."
								+ "Please enter a new amount.");
					}else {
						
						try {
							
							a = aServ.createAccount(id, balance, acctType);
							System.out.println("Your " + a.getAccountType().toLowerCase() + " account has been created! Your account number is "
									 + a.getAccountNum());	
							
						}catch (Exception e) {
					
						System.out.println("Sorry, we could not process you request.");
						System.out.println("Please try again later.");
						System.out.println("###########################");
						Done = true;
						}
					}
				break;
			case 3:
				//deposit 
				System.out.println("###########################");
				//System.out.println("Please enter your Account Number for Deposit: ");
				
				System.out.println("Accounts: " + aDao.getAccountByUser(u).getAccountNum());
				System.out.println("Please enter an amount you would like to deposit: ");
				int deposit = Integer.parseInt(in.nextLine());
				
				System.out.println("Deposit amount: $" + deposit);
				aDao.makeDeposit(u, deposit);
				
				System.out.println("Your new account balance is: $" + aDao.getAccountByUser(u).getCurrentBal() + "\n");
				break;
				
			case 4:
				// withdrawal 
				System.out.println("###########################");
				//System.out.println("Please enter your Account Number to withdrow: ");
				
				System.out.println("Please enter an amount you would like to withdrow: ");
				int withdrawal = Integer.parseInt(in.nextLine());
				
				System.out.println("withdrow amount: $" + withdrawal);
				aDao.makeWithdrawl(u, withdrawal);
				
				System.out.println("Your new account balance is: $" + aDao.getAccountByUser(u).getCurrentBal() + "\n");
				break;
			case 5:
				//transfer 
				System.out.println("###########################");
				aDao.transfer();
				break;
			case 6:
				//logout
				System.out.println("###########################");
				Done = true;
				break;
				
			default:
				
				System.out.println("Sorry, this is not a valid choice.");
		}//End switch 
		
		if(choice == 0) {
			
			List<Account> accountList = null;
			
			for(Account account: accountList) {
				System.out.println(account.getAccountNum() + ":");
				System.out.println(account.getAccountType());
				System.out.println();
			}
			System.out.println("Are you finished? Press 1 for yes, press 2 for no.");
			
			
	}//End While loop
	System.out.println("Goodbye.");
	//in.close();

	}//End Main Method
	}}

}//End BankDriver Class