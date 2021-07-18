package banking.driver;
import java.sql.SQLException;
//import java.sql.*;
import java.util.Scanner;

import com.banking.models.User;
import com.dao.UserDaoDB;
import com.dao.userDao;
import com.services.UserService;

public class BankDriver {
	private static userDao uDao=new UserDaoDB();
    private static UserService Userve=new UserService(uDao);

    
	public static void main(String[] args)  {
//		 userDao uDao=new UserDaoDB();
//		 UserService uServe=new UserService(uDao);
//		 uServe.signUp("fio", "weldu", "fioritetet2@gmail.com", "gygy");
	   // User u= new User("Fiori","weldu","email@.com","fiorina");
	    //uDao.createUser(u);
	    //System.out.println(uDao.getAllUsers());
		Scanner in=new Scanner(System.in);
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
			
		}
		///////////////////////////
		
		
//		 else {
////			System.out.println("To view posts press 1, to create a post press 2");
////			int choice = Integer.parseInt(in.nextLine());
////			//If the user chooses 1, we will show them the list of posts
////			if(choice == 1) {
////				List<PostDesplay> posts = pserv.getAllPosts();
////				for(PostDesplay post: posts) {
////					System.out.println(post.getUsername() + ":");
////					System.out.println(post.getContent());
////					System.out.println();
////				}
////				System.out.println("Are you finished? Press 1 for yes, press 2 for no");
////				choice = Integer.parseInt(in.nextLine());
////				Done = (choice == 1) ? true : false;
////			} else {
////				System.out.println("Please enter your content below:");
////				String content = in.nextLine();
//////				Post p = new Post(u.getId(),u.getId(), content);
////				pserv.addPost(u.getId(), u.getId(), content);
////				System.out.println("Post was received, are you finished? Press 1 for yes, press 2 for no");
////				choice = Integer.parseInt(in.nextLine());
////				Done = (choice == 1) ? true : false;
////			}
////		
////		
////				
////			}
////			
		///////
		
//		}
	System.out.println("See you later");
	in.close();
		}

	}

}
