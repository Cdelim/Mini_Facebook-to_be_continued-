import java.util.ArrayList;
//import java.text.SimpleDateFormat;
//import java.util.Date;

public class User {
	private String name;
	private String userName;
	private String password;
	private String DoB;
	private String schoolG;
	private boolean Online;
	private int userID;
	private static int userID2=1;
	private String relationShip;
	ArrayList<User> friends=new ArrayList<User>();
	ArrayList<User>	block_friends=new ArrayList<User>();
	ArrayList<User>	block_users=new ArrayList<User>();
	ArrayList<TextPost> textposts=new ArrayList<TextPost>();
	ArrayList<ImagePost> imageposts=new ArrayList<ImagePost>();
	ArrayList<VideoPost> videoposts=new ArrayList<VideoPost>();
	ArrayList<Post> posts=new ArrayList<Post>();
	//(new SimpleDateFormat("dd.MM.yyyy").parse(Date_of_Birth))
	/**
	 * @param name Name of the	user object to be created
	 * @param userName	Username of the	user object to be created
	 * @param password	Passwordof the	user object to be created
	 * @param DoB		Date Of Birth of the	user object to be created
	 * @param schoolG	Graduated School of the	user object to be created
	 */
	public User(String name,String userName,String password,String DoB,String schoolG,String relationShip){
		this.name=name;
		this.userName=userName;
		this.password=password;
		//String[] dates;
		//dates=DoB.split("/");
		this.DoB=DoB;
		this.schoolG=schoolG;
		this.relationShip=relationShip;
		this.userID=userID2++;
	}
	/**Allows the user to update their own information according to the values they receive
	 * @param name New name
	 * @param DoB	New Date of Birth
	 * @param schoolG	New graduated school
	 */
	public void UPDATEPROFILE(String name,String DoB,String schoolG){
		if(Online==true){
			this.name=name;
			this.DoB=DoB;
			this.schoolG=schoolG;
			System.out.println("Your user profile has been successfully updated.");
		}
		else{
		System.out.println("Error: Please sign in and try again.");
		}
	}

	/**If the old password is correct it will change the user's password
	 * @param oldPassword	Old password
	 * @param newPassword	New password
	 */
	public void	CHPASS(String oldPassword,String newPassword){
		if(Online==true){
			if(this.password.equals(oldPassword)){
				this.password=newPassword;
			}
			else{
				System.out.println("Password mismatch! Please, try again.");
			}
		}
		else{
		System.out.println("Error: Please sign in and try again.");
		}
	}
	/**Adds the user as friend based on the given name
	 * @param userName	Username
	 */
	/*public void	ADDFRIEND(String userName){
		if(Online==true){
			int j=1;
			for(int i=0;i<UserCollection.users.size();i++){
				if(UserCollection.users.get(i).userName.equals(userName)){
					if(friends.contains(UserCollection.users.get(i))){
						System.out.println("This user is already in your friend list!");
					}
					else{
						friends.add(UserCollection.users.get(i));
						System.out.println(userName+ " has been successfully added to your friend list.");
					}
					
				}
				else{
					j++;
				}
				if(j>UserCollection.users.size()){
					System.out.println("No such user!");
				}
			}	
		}
		else{
		System.out.println("Error: Please sign in and try again.");
		}
	}*/
	public void	ADDFRIEND(String userName,String userName2){
		for(int i=0;i<UserCollection.users.size();i++){
			if(UserCollection.users.get(i).userName.equals(userName)){
				for(int z=0;z<UserCollection.users.size();z++){
					if(UserCollection.users.get(z).userName.equals(userName2)){
							if(UserCollection.users.get(i).friends.contains(UserCollection.users.get(z))){
							}
							else{
								UserCollection.users.get(i).friends.add(UserCollection.users.get(z));
								UserCollection.users.get(z).friends.add(UserCollection.users.get(i));
							}
					}
				}	
			}
		}
	}
	/**Remove the user as friend based on the given name
	 * @param userName	Username
	 */
	public void	REMOVEFRIEND(String userName){
			int j=1;
			for(User usr:UserCollection.users){
				if(usr.getUserName().equals(userName)){
					System.out.println("123");
					friends.remove(usr);
				}
			}
			for(int i=0;i<friends.size();i++){
				if(friends.get(i).userName.equals(userName)){
						friends.remove(friends.get(i));
						//System.out.println(userName+ " has been successfully removed from your friend list.");
						break;
				}
				else{
						j++;
					}
				if(j>friends.size()){
					//System.out.println("No such friend!");
				}
			}
				
		
	}
	/**Blocks the user according to the given name
	 * @param userName Username
	 */
	/*public void BLOCK(String userName){
		if(Online==true){
			int j=1;
			for(int i=0;i<UserCollection.users.size();i++){
				if(UserCollection.users.get(i).userName.equals(userName)){
					if(friends.contains(UserCollection.users.get(i))){
						if(block_users.contains(UserCollection.users.get(i))){
							System.out.println("This user is already blocked!");
						}
						else{
							if(block_friends.contains(UserCollection.users.get(i))){
								System.out.println("This user is already blocked!");
							}
							else{
								block_friends.add(UserCollection.users.get(i));
								block_users.add(UserCollection.users.get(i));
								System.out.println(userName +" has been successfully blocked");
							}	
						}
					}
				else{
					if(block_users.contains(UserCollection.users.get(i))){
						System.out.println("This user is already blocked!");
					}
					else{
						block_users.add(UserCollection.users.get(i));
						System.out.println(userName +" has been successfully blocked");
					}
				}	
				}
				else{
					j++;
				}
				if(j>UserCollection.users.size()){
					System.out.println("No such user!");
				}
			}
		}
		else{
		System.out.println("Error: Please sign in and try again.");
		}
	}*/
	public void  BLOCK(String userName,String userName2){
		for(int i=0;i<UserCollection.users.size();i++){
			if(UserCollection.users.get(i).userName.equals(userName)){
				for(int q=0;q<UserCollection.users.size();q++){
					if(UserCollection.users.get(q).userName.equals(userName2)){
							//burda fried degilse blocklayabilir.bunu duzelt
							//if(UserCollection.users.get(i).friends.contains(UserCollection.users.get(q)))
							//boyle olabilir
							UserCollection.users.get(i).friends.remove(UserCollection.users.get(q));
							UserCollection.users.get(i).block_friends.add(UserCollection.users.get(q));
							UserCollection.users.get(q).friends.remove(UserCollection.users.get(i));
							UserCollection.users.get(q).block_friends.add(UserCollection.users.get(i));
					}
				}
			}
		}
		
	}
	/**Unblocks the user according to the given name
	 * @param userName Username
	 */
	public void UNBLOCK(String userName){
		if(Online==true){
			for(int i=0;i<block_friends.size();i++){
				if(block_friends.get(i).userName.equals(userName)){
					block_friends.remove(block_friends.get(i));
				}
			}
			int a=1;
			for(int i=0;i<block_users.size();i++){
				if(block_users.get(i).userName.equals(userName)){
					block_users.remove(block_users.get(i));
					System.out.println(userName +" has been successfully unblocked");
					break;
				}
				else{
					a++;
				}
				if(a>block_users.size()){
					System.out.println("No such user in your blocked users list!");
				}
			}
		}
		else{
		System.out.println("Error: Please sign in and try again.");
		}
	}
	/**
	 * List the user's friends with their information.
	 */
	public void LISTFRIENDS(){
		if(Online==true){
			if(friends.isEmpty()){
				System.out.println("You have not added any friends yet!");
			}
			else{
				for(int i=0;i<friends.size();i++){
					System.out.println(friends.get(i).toString());
					System.out.println("-----------------------");
				}
			}
		}
		else{
		System.out.println("Error: Please sign in and try again.");
		}
	}
	/**
	 * List all users.
	 */
	public void LISTUSERS(){
		if(Online==true){
			for(int i=0;i<UserCollection.users.size();i++){
				System.out.println(UserCollection.users.get(i).toString());
				System.out.println("-----------------------");
			}
		}
		else{
		System.out.println("Error: Please sign in and try again.");
		}
	}
	/**
	 * Lists blocked friends  with their information
	 */
	public void SHOWBLOCKEDFRIENDS(){
		if(Online==true){
			if(block_friends.isEmpty() && block_users.isEmpty()){
				System.out.println("You have not blocked any users yet!");
			}
			else{
				if(block_friends.isEmpty()){
					System.out.println("You have not blocked any friends yet!");	
				}
				else{
					for(int i=0;i<block_friends.size();i++){
						System.out.println(block_friends.get(i).toString());
						System.out.println("-----------------------");
					}		
				}
			}
		}
		else{
		System.out.println("Error: Please sign in and try again.");	
		}
	}
	/**
	 * Lists blocked users  with their information
	 */
	public void SHOWBLOCKEDUSERS(){
		if(Online==true){
			if(block_users.isEmpty() ){
				System.out.println("You have not blocked any users yet!");	
			}
			else{
				for(int i=0;i<block_users.size();i++){
					System.out.println(block_users.get(i).toString());
					System.out.println("-----------------------");
				}		
			}
		}
		else{
		System.out.println("Error: Please sign in and try again.");
		}
	}
	/**Inserts new text post  according to given datas
	 * @param textContent Text content of the new Post text
	 * @param longitude	Longitude of the new Post text
	 * @param latitude	latitude of the new Post text
	 * @param userNames	The persons to be labeled of the new Post text
	 */
	public void ADDPOSTTEXT(String textContent,String longitude,String latitude,String userNames){
		if(Online==true){
			String[] t_user;
			t_user=userNames.split(":");
			for(int q=0;q<t_user.length;q++){
				int a=1;
				for(int i=0;i<friends.size();i++){
					if(friends.get(i).userName.equals(t_user[q])){
						//friends mi olacak Main.online_user.friends mi olacak bak.
					}
					else{
						a++;
					}
					if(a>friends.size()){
						System.out.println(t_user[q]+" is not your friend, and will not be tagged!");
					}
					
				}
			}
			TextPost n_post=new TextPost(textContent,longitude,latitude,userNames);
			textposts.add(n_post);
			posts.add(n_post);
			System.out.println("The post has been successfully added.");
		}
		else{
		System.out.println("Error: Please sign in and try again");
		}
	}
	/**Inserts new image post according to given datas
	 * @param textContent	Text content of the new Post Image
	 * @param longitude	Longitude of the new Post Image
	 * @param latitude	Latitude of the new Post Image
	 * @param userNames	The persons to be labeled of the new Post Image
	 * @param filePath	Filename of the new Post Image
	 * @param resolution resolution of the new Post Image
	 */
	public void	ADDPOSTIMAGE(String textContent,String longitude,String latitude,String userNames,String filePath,String resolution){
		if(Online==true){
			String[] t_user;
			t_user=userNames.split(":");
			for(int q=0;q<t_user.length;q++){
				int a=1;
				for(int i=0;i<friends.size();i++){
					if(friends.get(i).userName.equals(t_user[q])){
						//friends mi olacak Main.online_user.friends mi olacak bak.
					}
					else{
						a++;
					}
					if(a>friends.size()){
						System.out.println(t_user[q]+" is not your friend, and will not be tagged!");
					}	
				}
			}
			ImagePost n_post=new ImagePost(textContent,longitude,latitude,userNames,filePath,resolution);
			imageposts.add(n_post);
			posts.add(n_post);
			System.out.println("The post has been successfully added.");
		}
		else{
		System.out.println("Error: Please sign in and try again");
		}
	}
	/**Inserts new video post according to given datas
	 * @param textContent	Text content of the new Post Video
	 * @param longitude	Longitude of the new Post Video
	 * @param latitude	Latitude of the new Post Video
	 * @param userNames	The persons to be labeled of the new Post Video
	 * @param filePath	Filename of the new Post Video
	 * @param videoDuration	Video duration of the new Video Post
	 */
	public void	ADDPOSTVIDEO(String textContent,String longitude,String latitude,String userNames,String filePath,String videoDuration){
		if(Online==true){
			if(Integer.parseInt(videoDuration)<=10){
				String[] t_user;
				t_user=userNames.split(":");
				for(int q=0;q<t_user.length;q++){
					int a=1;
					for(int i=0;i<friends.size();i++){
						if(friends.get(i).userName.equals(t_user[q])){
							//friends mi olacak Main.online_user.friends mi olacak bak.
						}
						else{
							a++;
						}
						if(a>friends.size()){
							System.out.println(t_user[q]+" is not your friend, and will not be tagged!");
						}
					}
				}
				VideoPost n_post=new VideoPost(textContent,longitude,latitude,userNames,filePath,videoDuration);
				videoposts.add(n_post);
				posts.add(n_post);
				System.out.println("The post has been successfully added.");
			}
			else{
			System.out.println("Error: Your video exceeds maximum allowed duration of 10 minutes.");
			}
		}
		else{
		System.out.println("Error: Please sign in and try again");
		}
		
	}
	/**
	 * Delete the last post of the user
	 */
	public void REMOVELASTPOST(){
		if(Online==true){
			if(posts.isEmpty()){
				System.out.println("Error: You don't have any posts.");
			}
			else{
				System.out.println("Your last post has been successfully removed.");
				if(posts.get(posts.size()-1).equals(textposts.get(textposts.size()-1))){
					textposts.remove(textposts.get(textposts.size()-1));
				}
				else if(posts.get(posts.size()-1).equals(videoposts.get(videoposts.size()-1))){
					videoposts.remove(videoposts.get(videoposts.size()-1));
				}
				else if(posts.get(posts.size()-1).equals(imageposts.get(imageposts.size()-1))){
					imageposts.remove(imageposts.get(imageposts.size()-1));
				}
				posts.remove(posts.get(posts.size()-1));
			}
		}
		else{
		System.out.println("Error: Please sign in and try again.");
		}
	}
	/**
	 * Allows the user to be offline
	 */
	public void SIGNOUT(){
		Online=false;
		System.out.println("You have successfully signed out.");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDoB() {
		return DoB;
	}
	public void setDoB(String doB) {
		DoB = doB;
	}
	public String getSchoolG() {
		return schoolG;
	}
	public void setSchoolG(String schoolG) {
		this.schoolG = schoolG;
	}
	public boolean isOnline() {
		return Online;
	}
	public void setOnline(boolean online) {
		Online = online;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getRelationShip() {
		return relationShip;
	}
	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}
	/*public String toString(){
		return ("Name: "+this.name+
				"\nUsername: "+this.userName+
				"\nDate of Birth: "+this.DoB+
				"\nSchool: "+this.schoolG+"\n");
	}*/
}
