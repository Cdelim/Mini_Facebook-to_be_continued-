import java.util.ArrayList;

public class UserCollection {
	static  ArrayList<User> users=new ArrayList<User>();
	//The UserCollection class should also provide means for a user sign-in given the same parameters.
	public UserCollection(){
		
	}
	/**Add a new user.
	 * @param name Name of the new User
	 * @param userName	Username of the new User
	 * @param password	Password of the new User
	 * @param DoB	Date of Birth of the new User
	 * @param schoolG	Graduated school of the new User
	 */
	public static	void addUser(String name,String userName,String password,String DoB,String schoolG,String rS){
		User asd=new User(name,userName,password,DoB,schoolG,rS);
		users.add(asd);
		System.out.println(name +" has been successfully added.");
	}
	/**	Deletes user according to given ID
	 * @param user_ID ID of user to delete
	 */
	public	static void	removeUser(int user_ID){
		int j=1;
		for(int i=0;i<users.size();i++){
			if(users.get(i).getUserID()==user_ID){
				users.remove(users.get(i));
				System.out.println("User has been successfully removed.");
			}
			else{
				j++;
			}
			if (j>users.size()){
				System.out.println("No such user!");
			}	
		}	
	}
	/**Allows the user to be online
	 * @param userName	The username of the user to be online
	 * @param password	The password of the user to be online
	 */
	public static void userSignIn(String userName,String password){
		int j=1;
		for(int i=0;i<users.size();i++){
			if(users.get(i).getUserName().equals(userName)){
				if(users.get(i).getPassword().equals(password)){
					users.get(i).setOnline(true);
					System.out.println("You have successfully signed in.");
				}
				else{
					System.out.println("Invalid username or password! Please try again.");
				}
			}
			else{
				j++;
			}
			if (j>users.size()){
				System.out.println("No such user!");
			}	
		}
	}
	/**All the posts of the user in the entered name are indicated by their information.
	 * @param userName	Username
	 */
	public static void	showPosts(String userName){
		int a=1;
		for(int i=0;i<users.size();i++){
			if(users.get(i).getUserName().equals(userName)){
				if(users.get(i).posts.isEmpty() ){
					System.out.println(userName+" does not have any posts yet.");
				}
				else{
					System.out.println(userName+"' Posts");
					for(int b=0;b<users.get(i).textposts.size();b++){
						System.out.println(users.get(i).textposts.get(b).getText());
						System.out.println("Date: "+users.get(i).textposts.get(b).getDate_p());
						users.get(i).textposts.get(b).ShowPostLocation();
						System.out.print("Friends tagged in this post: ");
						users.get(i).textposts.get(b).ShowTaggedUsers();
						System.out.println("\n");
						System.out.println("----------------------");
					}
					for(int b=0;b<users.get(i).imageposts.size();b++){
						System.out.println(users.get(i).imageposts.get(b).getText());
						System.out.println("Date: "+users.get(i).imageposts.get(b).getDate_p());
						users.get(i).imageposts.get(b).ShowPostLocation();
						System.out.println("Image: "+users.get(i).imageposts.get(b).getfilePath());
						System.out.println("Image resolution: "+users.get(i).imageposts.get(b).getResolution());
						System.out.print("Friends tagged in this post: ");
						users.get(i).imageposts.get(b).ShowTaggedUsers();
						System.out.println("\n");
						System.out.println("----------------------");
					}
					for(int b=0;b<users.get(i).videoposts.size();b++){
						System.out.println(users.get(i).videoposts.get(b).getText());
						System.out.println("Date: "+users.get(i).videoposts.get(b).getDate_p());
						users.get(i).videoposts.get(b).ShowPostLocation();
						System.out.println("Video: "+users.get(i).videoposts.get(b).getFilename());
						System.out.println("Video duration: "+users.get(i).videoposts.get(b).getDuration());
						System.out.print("Friends tagged in this post: ");
						users.get(i).videoposts.get(b).ShowTaggedUsers();
						System.out.println("\n");
						System.out.println("----------------------");
					}
				}
			}
			else{
				a++;
			}
			if(a>users.size()){
				System.out.println("No such user!");
			}
		}
	}
}

